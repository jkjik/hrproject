package com.jikjk.handler;

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
import org.springframework.web.bind.annotation.ResponseBody;

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
    private DepartmentService departmentServiceImpl;
    @Autowired
    private PositionService positionServiceImpl;
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
        Employee employee= (Employee) session.getAttribute("employee");
        //查看本部门员工
        if(employee.getdId()==dId){
            List<Employee> employees=employeeServiceImpl.selectEmployee(employee.getdId());
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
     * 打上班卡成功
     * @param session
     * @return
     */
    @RequestMapping("onWorkCard")
    @ResponseBody
    public String onWorkCard(HttpSession session){
        Employee employee= (Employee) session.getAttribute("employee");
        Integer eId=employee.geteId();
        Timestamp timestamp=new Timestamp(System.currentTimeMillis());
        java.sql.Date date=new java.sql.Date(System.currentTimeMillis());
        //重复打上班卡问题
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
        String start=sf.format(date);
        String startTimeLike="%"+start+"%";
        OnWork onWork1=onWorkServiceImpl.selectByLike(startTimeLike,eId);
        if(onWork1!=null){
            return "fail";
        }else {
            String onWorkState= OnWorkTime.CheckOnWork();
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
        }
        //判断是否打卡成功
        OnWork onWork2=onWorkServiceImpl.selectByLike(startTimeLike,eId);
        if(onWork2!=null){
            return "ok";
        }else {
            return "no";
        }
    }

    /**
     * 下班打卡成功
     * @param session
     * @return
     */
    @RequestMapping("offWorkCard")
    @ResponseBody
    public String offWorkCard(HttpSession session){
        Employee employee= (Employee) session.getAttribute("employee");
        Integer eId=employee.geteId();
        Timestamp timestamp=new Timestamp(System.currentTimeMillis());
        java.sql.Date date=new java.sql.Date(System.currentTimeMillis());
        String offWorkState= OffWorkTime.CheckOnWork();
        if("正常".equals(offWorkState)){

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
        OnWork onWork=null;
        try {
            onWork=onWorkServiceImpl.selectByLike(startTimeLike,eId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(onWork!=null){
            //重复打卡
            if(!"未打卡".equals(onWork.getOffWorkState())){
                return "fail";
            }else {
                onWork.setEndTime(timestamp);
                onWork.setOffWorkState(offWorkState);
                //打卡
                onWorkServiceImpl.update(onWork);
            }

        }
        //判断是否打卡成功
        OnWork onWork1=onWorkServiceImpl.selectByLike(startTimeLike,eId);
        if("未打卡".equals(onWork1.getOffWorkState())){
            return "no";
        }else {
            return "ok";
        }
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
        //当前月的模糊时间
        Calendar calendar=Calendar.getInstance();
        Date newTime=calendar.getTime();
        String newMonth="%"+sf.format(newTime)+"%";
        Wage wage=wageServiceImpl.selectWage(newMonth,employee.geteId());
        map.addAttribute("wage",wage);
        //查看异议
        List<WageAdvise> wageAdvises=wageAdviseServiceImpl.selectByEid(employee.geteId());
        map.addAttribute("wageAdvises",wageAdvises);
        return "empLookMonthWage";
    }

    /**
     * 添加工资异议
     * @param waCause
     * @param adMoney
     * @param session
     * @return
     */
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
