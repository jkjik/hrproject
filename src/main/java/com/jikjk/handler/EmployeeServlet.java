package com.jikjk.handler;

import com.jikjk.dao.EmployeeDao;
import com.jikjk.entity.*;
import com.jikjk.service.*;
import com.jikjk.util.OffWorkTime;
import com.jikjk.util.OnWorkTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by lenovo on 2018/10/16.
 */
@RequestMapping("emp")
@Controller
public class EmployeeServlet {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private UserService userServiceImpl;
    @Autowired
    private DepartmentService departmentServiceImpl;
    @Autowired
    private PositionService positionServiceImpl;
    @Autowired
    private ResumeService resumeServiceImpl;
    @Autowired
    private AdministratorService admServiceImpl;
    @Autowired
    private SendResumeService sendResumeServiceImpl;
    @Autowired
    private MassageResumeService massageResumeServiceImpl;
    @Autowired
    private InviteJobService inviteJobServiceImpl;
    @Autowired
    private InterviewService interviewServiceImpl;
    @Autowired
    private EmployeeService employeeServiceImpl;
    @Autowired
    private CreateCultivateService createCultivateServiceImpl;
    @Autowired
    private OnWorkService onWorkServiceImpl;
    @Autowired
    private PunishMoneyService punishMoneyServiceImpl;
    @Autowired
    private OverTimeMoneyService overTimeMoneyServiceImpl;
    @Autowired
    private WageAdviseService wageAdviseServiceImpl;
    @Autowired
    private WageService wageServiceImpl;

    @InitBinder
    public void initBinder(ServletRequestDataBinder binder){
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),
                true));
    }

    /**
     * 返回用户主页
     * @return
     */
    @RequestMapping("gotoEmpPage")
    public String gotoEmpPage(){
        return "empPage";
    }

    /**
     * 查看部门信息
     * @return
     */
    @RequestMapping("lookDuty")
    public String lookDuty(ModelMap map){
        List<Department> departments=departmentServiceImpl.selectAll();
        map.addAttribute("departments",departments);
        return "empLookingDuty";
    }

    /**
     * 查看职位
     * @param request
     * @param map
     * @param session
     * @return
     */
    @RequestMapping("getPosition")
    public String getPosition(HttpServletRequest request,ModelMap map,HttpSession session){
        int dId=0;
        try {
            dId=Integer.valueOf(request.getParameter("dId"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        System.out.println(dId);
        Employee employee= (Employee) session.getAttribute("employee");
        //查看本部门员工
        if(employee.getdId()==dId){
            List<Employee> employees=employeeServiceImpl.selectEmployee(employee.getdId());
            System.out.println(employees);
            map.addAttribute("employees",employees);
        }
        List<Position> positions= positionServiceImpl.selectById(dId);
        map.addAttribute("positions",positions);
        //部门信息
        List<Department> departments=departmentServiceImpl.selectAll();
        map.addAttribute("departments",departments);
        return "empLookingDuty";
    }

    /**
     * 查看个人信息
     * @param session
     * @param map
     * @return
     */
    @RequestMapping("lookingYourself")
    public String lookingYourself(HttpSession session,ModelMap map){
        Employee employee= (Employee) session.getAttribute("employee");
        map.addAttribute("employee",employee);
        return "empYourself";
    }

    /**
     * 查看培训通知
     * @param map
     * @param session
     * @return
     */
    @RequestMapping("lookCultivate")
    public String lookCultivate(ModelMap map,HttpSession session){
        Employee employee= (Employee) session.getAttribute("employee");
        String cDuty=departmentServiceImpl.selectNameByDid(employee.getdId());
        List<CreateCultivate> createCultivate=createCultivateServiceImpl.selectByDuty(cDuty);
        map.addAttribute("createCultivate",createCultivate);
        return "empLookingCultivate";
    }

    /**
     * 上班打卡
     * @param session
     * @return
     */
    @RequestMapping("onWork")
    public String onWork(HttpSession session){
        Employee employee= (Employee) session.getAttribute("employee");
        Integer eId=employee.geteId();
        Timestamp timestamp=new Timestamp(System.currentTimeMillis());
        java.sql.Date date=new java.sql.Date(System.currentTimeMillis());
        String onWorkState= OnWorkTime.CheckOnWork(timestamp);
        if("正常".equals(onWorkState)){

        }
        if("迟到".equals(onWorkState)){
            //迟到扣50
            PunishMoney punishMoney=new PunishMoney(0,eId,onWorkState,-50,date);
            punishMoneyServiceImpl.insert(punishMoney);
        }
        if("缺勤".equals(onWorkState)){
            //缺勤扣100
            PunishMoney punishMoney=new PunishMoney(0,eId,onWorkState,-100,date);
            punishMoneyServiceImpl.insert(punishMoney);
        }
        OnWork onWork=new OnWork(0,employee.geteId(),timestamp,timestamp,onWorkState,"未打卡");
        onWorkServiceImpl.insert(onWork);
        return "forward:gotoEmpPage";
    }

    /**
     * 下班打卡
     * @param session
     * @return
     */
    @RequestMapping("offWork")
    public String offWork(HttpSession session){
        Employee employee= (Employee) session.getAttribute("employee");
        Integer eId=employee.geteId();
        Timestamp timestamp=new Timestamp(System.currentTimeMillis());
        java.sql.Date date=new java.sql.Date(System.currentTimeMillis());
        String offWorkState= OffWorkTime.CheckOnWork(timestamp);
        if("正常".equals(offWorkState)){
            //不能实现上午打下班卡
            //各种打卡bug注意
        }
        if("早退".equals(offWorkState)){
            //早退扣50
            PunishMoney punishMoney=new PunishMoney(0,eId,offWorkState,-50,date);
            punishMoneyServiceImpl.insert(punishMoney);
        }
        if("加班".equals(offWorkState)){
            //加班费加入加班表
            OverTimeMoney overTimeMoney=new OverTimeMoney(0,eId,100,date);
            overTimeMoneyServiceImpl.insert(overTimeMoney);
        }
        //查询到今天的记录
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
        String start=sf.format(date);
        String startTimeLike="%"+start+"%";
        OnWork onWork=onWorkServiceImpl.selectByLike(startTimeLike,eId);
        onWork.setEndTime(timestamp);
        onWork.setOffWorkState(offWorkState);
        //打卡
        onWorkServiceImpl.update(onWork);
        return "forward:gotoEmpPage";
    }

    /**
     * 查看所有考勤
     * @param session
     * @param map
     * @return
     */
    @RequestMapping("lookToWork")
    public String lookToWork(HttpSession session,ModelMap map){
        Employee employee= (Employee) session.getAttribute("employee");
        int eId=employee.geteId();
        List<OnWork> onWorks=onWorkServiceImpl.selectByEid(eId);
        map.addAttribute("onWorks",onWorks);
        return "empLookWork";
    }

    /**
     * 查看当月考勤
     * @param session
     * @param map
     * @return
     */
    @RequestMapping("lookMonthWork")
    public String lookMonthWork(HttpSession session,ModelMap map){
        Employee employee= (Employee) session.getAttribute("employee");
        int eId=employee.geteId();
        java.sql.Date date=new java.sql.Date(System.currentTimeMillis());
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM");
        String start=sf.format(date);
        String monthWorkTime="%"+start+"%";
        List<OnWork> onWorkMonth=onWorkServiceImpl.selectMonthWorkTime(monthWorkTime,eId);
        map.addAttribute("onWorkMonth",onWorkMonth);
        map.addAttribute("monthWorkTime",start);
        return  "empLookWork";
    }

    /**
     * 查看奖惩记录
     * @param session
     * @param map
     * @return
     */
    @RequestMapping("lookPunish")
    public String lookPunish(HttpSession session,ModelMap map){
        Employee employee= (Employee) session.getAttribute("employee");
        int eId=employee.geteId();
        List<PunishMoney> punishMonies=punishMoneyServiceImpl.selectPunishMoney(eId);
        map.addAttribute("punishMonies",punishMonies);
        return "empLookWork";
    }

    /**
     * 查看工资条
     * @param session
     * @param map
     * @return
     */
    @RequestMapping("lookMonthWage")
    public String lookMonthWage(HttpSession session,ModelMap map){
        Employee employee= (Employee) session.getAttribute("employee");
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM");
        //上个月的模糊时间
        Calendar car=Calendar.getInstance();
        car.setTime(new java.util.Date());
        car.add(Calendar.MONTH,-1);
        java.util.Date lastTime=car.getTime();
        String last=sf.format(lastTime);
        String lastMonth="%"+last+"%";
        Wage wage=wageServiceImpl.selectWage(lastMonth,employee.geteId());
        System.out.println(wage);
        map.addAttribute("wage",wage);
        return "empLookMonthWage";
    }

    @RequestMapping("wageAdvice")
    public String wageAdvice(String waCause,Integer adMoney,HttpSession session){
        Employee employee= (Employee) session.getAttribute("employee");
        java.sql.Date date=new java.sql.Date(System.currentTimeMillis());
        WageAdvise wageAdvise=new WageAdvise(0,employee.geteId(),adMoney,"",date,waCause);
        System.out.println(wageAdvise);
        wageAdviseServiceImpl.insert(wageAdvise);
        return "forward:lookMonthWage";
    }
}
