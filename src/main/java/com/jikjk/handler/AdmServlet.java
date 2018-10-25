package com.jikjk.handler;

import com.jikjk.entity.*;
import com.jikjk.entity.CloseWage;
import com.jikjk.entity.utilpojo.ResMassageResume;
import com.jikjk.entity.utilpojo.ResWage;
import com.jikjk.service.*;
import com.jikjk.util.CloseBonusMoney;
import com.jikjk.util.CloseOverTimeMoney;
import com.jikjk.util.ClosePunishMoney;
import com.jikjk.util.ResumeToEmp;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by lenovo on 2018/10/14.
 */
@RequestMapping("adm")
@Controller
public class AdmServlet {
    @Autowired
    private InviteJobService inviteJobServiceImpl;
    @Autowired
    private MassageResumeService massageResumeServiceImpl;
    @Autowired
    private SendResumeService sendResumeServiceImpl;
    @Autowired
    private ResumeService resumeServiceImpl;
    @Autowired
    private InterviewService interviewServiceImpl;
    @Autowired
    private InterviewResultService interviewResultServiceImpl;
    @Autowired
    private PositionService positionServiceImpl;
    @Autowired
    private DepartmentService departmentServiceImpl;
    @Autowired
    private EmployeeService employeeServiceImpl;
    @Autowired
    private UserService userServiceImpl;
    @Autowired
    private CreateCultivateService createCultivateServiceImpl;
    @Autowired
    private BasicMoneyService basicMoneyServiceImpl;
    @Autowired
    private SocialMoneyService socialMoneyServiceImpl;
    @Autowired
    private WageService wageServiceImpl;
    @Autowired
    private OverTimeMoneyService overTimeMoneyServiceImpl;
    @Autowired
    private OnWorkService onWorkServiceImpl;
    @Autowired
    private PunishMoneyService punishMoneyServiceImpl;
    @Autowired
    private BonusMoneyService bonusMoneyServiceImpl;
    @Autowired
    private WageAdviseService wageAdviseServiceImpl;
    @Autowired
    private CloseWageService closeWageServiceImpl;
    @Autowired
    private LeaveEmployeeService leaveEmployeeServiceImpl;
    @Autowired
    private AdministratorService administratorServiceImpl;
    @InitBinder
    public void initBinder(ServletRequestDataBinder binder){
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),
                true));
    }

    /**
     * 发布招聘信息
     * @return
     */
    @RequestMapping("sendInvite")
    public String sendInviteJob(ModelMap map){
        List<InviteJob> inviteJobs=inviteJobServiceImpl.selectAll();
        map.addAttribute("inviteJobs",inviteJobs);

        List<Department> departments=departmentServiceImpl.selectAll();
        map.addAttribute("departments",departments);
        return "admSendInvite";
    }

    /**
     * 保存发送信息
     * @param inviteJob
     * @return
     */
    @RequestMapping("commitSendInvite")
    public String commitSendInvite(InviteJob inviteJob){
        inviteJobServiceImpl.insert(inviteJob);
        return "admPage";
    }

    /**
     * 获取职位数据
     * @param dep
     * @return
     */
    @RequestMapping(value = "getPosition" ,method= RequestMethod.POST,produces={"application/json;charset=utf-8"})
    @ResponseBody
    public String getPosition(Integer dep) {
        List<Position> positions=positionServiceImpl.selectById(dep);
        ObjectMapper mapper = new ObjectMapper();
        String json= null;
        try {
            json = mapper.writeValueAsString(positions);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    /**
     * 查看所有简历
     * @param map
     * @return
     */
    @RequestMapping("lookResume")
    public String lookResume(ModelMap map){
        List<ResMassageResume> massageResumes=massageResumeServiceImpl.selectAll();
        map.addAttribute("massageResumes",massageResumes);
        return "admLookResume";
    }
    /**
     * 查看个人简历
     * @param request
     * @return
     */
    @RequestMapping("lookingResume")
    public String lookingResume(HttpServletRequest request,ModelMap map){
        int rId=0;
        try {
            rId=Integer.valueOf(request.getParameter("rId"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        //修改sendResmue的查看状态
        sendResumeServiceImpl.updateReadState(rId,"已查看");
        //修改简历记录查看状态
        massageResumeServiceImpl.updateStateRead(rId,"已查看");
        Resume resume=resumeServiceImpl.selectByRid(rId);
        map.addAttribute("resume",resume);
        return "admLookingResume";
    }

    /**
     * 删除简历
     * @param request
     * @return
     */
    @RequestMapping("deleteMasResume")
    public String deleteMasResume(HttpServletRequest request){
        int rId=0;
        try {
            rId=Integer.valueOf(request.getParameter("rId"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        massageResumeServiceImpl.delete(rId);
        return "forward:lookResume";
    }

    /**
     * 创建面试
     * @return
     */
    @RequestMapping("interview")
    public String interview(HttpServletRequest request,ModelMap map){
        int rId=0;
        try {
            rId=Integer.valueOf(request.getParameter("rId"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        //已经通知直接查看
        Interview interview=interviewServiceImpl.selectByRid(rId);
        System.out.println(interview);
        if(interview!=null){
            map.addAttribute("interview",interview);
        }else {
            Resume resume=resumeServiceImpl.selectByRid(rId);
            map.addAttribute("resume",resume);
            //管理员
            List<Administrator> administrators=administratorServiceImpl.selectAll();
            map.addAttribute("administrators",administrators);
        }
        return "admInterview";
    }

    /**
     * 创建面试通知
     * @param interview
     * @return
     */
    @RequestMapping("interviewInform")
    public String interviewInform(Interview interview){
        interviewServiceImpl.insert(interview);
        //修改游客端的面试通知
        sendResumeServiceImpl.updateInformState(interview.getrId(),"已通知");
        return "forward:lookingResume";
    }

    /**
     * 返回查看简历
     * @return
     */
    @RequestMapping("gotoLookResume")
    public String gotoLookResume(){
        return "forward:lookResume";
    }

    /**
     * 面试结果
     * @param request
     * @param map
     * @return
     */
    @RequestMapping("intvResult")
    public String intvResult(HttpServletRequest request,ModelMap map){
        int rId=0;
        try {
            rId=Integer.valueOf(request.getParameter("rId"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        InterviewResult interviewResult=interviewResultServiceImpl.selectByRid(rId);
        if(interviewResult!=null){
            map.addAttribute("interviewResult",interviewResult);
        }else {
            Interview interview=interviewServiceImpl.selectByRid(rId);
            Resume resume=resumeServiceImpl.selectByRid(rId);
            map.addAttribute("resume",resume);
            map.addAttribute("interview",interview);
        }

        return "admIntvResult";
    }

    /**
     * 添加面试结果(录用)
     * @param interviewResult
     * @return
     */
    @RequestMapping("addIntvResult")
    public String addIntvResult(InterviewResult interviewResult){
        java.sql.Date date=new java.sql.Date(System.currentTimeMillis());
        interviewResult.setIrCreatetimr(date);
        //创建面试结果类
        interviewResultServiceImpl.insert(interviewResult);
        //游客面试通知
        sendResumeServiceImpl.updateInformState(interviewResult.getrId(),"有通知");
        //添加用户
        Resume resume=resumeServiceImpl.selectByRid(interviewResult.getrId());
        int duty=positionServiceImpl.selectDidByName(resume.getAimDuty());
        Employee employee= ResumeToEmp.toChange(resume,duty);
        employeeServiceImpl.insert(employee);
        //修改面试信息状态
        massageResumeServiceImpl.updateStateInterview(resume.getrId(),"已面试");
        //修改登录权限
        userServiceImpl.updateStatue(resume.getuId(),1);
        return "forward:gotoAdmPage";
    }

    /**
     * 返回管理员主页
     * @return
     */
    @RequestMapping("gotoAdmPage")
    public String gotoAdmPage(){
        return "admPage";
    }

    /**
     * 查看部门
     * @param map
     * @return
     */
    @RequestMapping("lookDuty")
    public String lookDuty(ModelMap map){
        List<Department> departments=departmentServiceImpl.selectAll();
        map.addAttribute("departments",departments);
        //职位为空时，显现添加职位
        List<Position> positions=positionServiceImpl.selectAll();
        if(positions.size()==0){
            map.addAttribute("addPost","addPost");
            List<Department> depre=departmentServiceImpl.selectAll();
            map.addAttribute("department",depre);
        }
        return "admLookingDuty";
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
        //职位
        List<Position> positions= positionServiceImpl.selectById(dId);
        map.addAttribute("positions",positions);

        return "forward:lookDuty";
    }

    /**
     * 删除部门
     * @param request
     * @return
     */
    @RequestMapping("deleteDepartment")
    public String deleteDepartment(HttpServletRequest request,ModelMap map){
        int dId=0;
        try {
            dId=Integer.valueOf(request.getParameter("dId"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if(dId!=0){
            //删除部门
            departmentServiceImpl.delete(dId);
            //删除部门下的职位
            positionServiceImpl.deleteByDid(dId);
        }
        return "forward:lookDuty";
    }

    /**
     * 删除职位
     * @param request
     * @param map
     * @return
     */
    @RequestMapping("deletePosition")
    public String deletePosition(HttpServletRequest request,ModelMap map){
        int pId=0;
        try {
            pId=Integer.valueOf(request.getParameter("pId"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if(pId!=0){
            positionServiceImpl.delete(pId);
        }

        return "forward:lookDuty";
    }
    /**
     * 添加部门
     * @param request
     * @param map
     * @return
     */
    @RequestMapping("addDep")
    public String addDep(HttpServletRequest request,ModelMap map){
        int dep=0;
        try {
            dep=Integer.valueOf(request.getParameter("dep"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if(dep==1){
            map.addAttribute("dep",dep);
        }

        return "forward:lookDuty";
    }

    /**
     * 奖赏员工
     * @param request
     * @param map
     * @return
     */
    @RequestMapping("awardEmployee")
    public String awardEmployee(HttpServletRequest request,ModelMap map){
        int eId=0;
        try {
            eId=Integer.valueOf(request.getParameter("eId"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        LeaveEmployee leaveEmployee=leaveEmployeeServiceImpl.selectByEid(eId);
        if(leaveEmployee!=null){

        }else {
            map.addAttribute("eId",eId);
            map.addAttribute("award","award");
        }
        return "forward:employeeManage";
    }

    /**
     * 查看员工详细信息
     * @param request
     * @param map
     * @return
     */
    @RequestMapping("lookEmpAll")
    public String lookEmpAll(HttpServletRequest request,ModelMap map){
        int eId=0;
        try {
            eId=Integer.valueOf(request.getParameter("eId"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        Employee employee=employeeServiceImpl.SelectByEid(eId);
        BasicMoney basicMoney=basicMoneyServiceImpl.selectBasic(eId);
        SocialMoney socialMoney=socialMoneyServiceImpl.selectSocialMoney(eId);
        map.addAttribute("employee",employee);
        map.addAttribute("basicMoney",basicMoney);
        map.addAttribute("socialMoney",socialMoney);
        return "admEmployeeManage";
    }
    /**
     * 查看考勤
     * @Param request
     * @Param map
     * @return
     */
    @RequestMapping("lookEmpOnWork")
    public String lookEmpWork(HttpServletRequest request,ModelMap map){
        int eId=0;
        try {
            eId=Integer.valueOf(request.getParameter("eId"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        List<OnWork> onWorks=onWorkServiceImpl.selectByEid(eId);
        map.addAttribute("onWorks",onWorks);

        List<Employee> employees=employeeServiceImpl.selectAll();
        map.addAttribute("employees",employees);
        List<LeaveEmployee> leaveEmployees=leaveEmployeeServiceImpl.selectAll();
        map.addAttribute("leaveEmployees",leaveEmployees);
        return "admEmployeeManage";
    }

    /**
     * 查看奖惩信息
     * @param request
     * @param map
     * @return
     */
    @RequestMapping("lookEmpPunish")
    public String lookEmpPunish(HttpServletRequest request,ModelMap map){
        int eId=0;
        try {
            eId=Integer.valueOf(request.getParameter("eId"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        List<PunishMoney> punishMonies=punishMoneyServiceImpl.selectPunishMoney(eId);
        map.addAttribute("punishMonies",punishMonies);

        List<Employee> employees=employeeServiceImpl.selectAll();
        map.addAttribute("employees",employees);
        List<LeaveEmployee> leaveEmployees=leaveEmployeeServiceImpl.selectAll();
        map.addAttribute("leaveEmployees",leaveEmployees);
        return "admEmployeeManage";
    }

    /**
     * 保存奖赏
     * @param eId
     * @param cause
     * @param puMoney
     * @return
     */
    @RequestMapping("commitAward")
    public String commitAward(Integer eId,String cause,Integer puMoney){
        java.sql.Date date=new java.sql.Date(System.currentTimeMillis());
        PunishMoney punishMoney=new PunishMoney(0,eId,cause,puMoney,date);
        punishMoneyServiceImpl.insert(punishMoney);
        return "forward:employeeManage";
    }

    /**
     * 添加效绩奖金
     * @param eId
     * @param boMoney
     * @return
     */
    @RequestMapping("addBonusMoney")
    public String addBonusMoney(Integer eId,Integer boMoney){
        java.sql.Date date=new java.sql.Date(System.currentTimeMillis());
        BonusMoney bonusMoney=new BonusMoney(0,eId,boMoney,date);
        bonusMoneyServiceImpl.insert(bonusMoney);
        return "forward:wageManage";
    }

    /**
     * 添加职位
     * @param request
     * @param map
     * @return
     */
    @RequestMapping("addPos")
    public String addPos(HttpServletRequest request,ModelMap map){
        int pos=0;
        try {
            pos=Integer.valueOf(request.getParameter("pos"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if(pos==1){
            map.addAttribute("pos",pos);
            List<Department> depre=departmentServiceImpl.selectAll();
            map.addAttribute("depre",depre);
        }
        //所有部门
        List<Department> departments=departmentServiceImpl.selectAll();
        map.addAttribute("departments",departments);
        return "admLookingDuty";
    }

    /**
     * 删除部门判断
     * @param dName
     * @return
     */
    @RequestMapping("deleteDep")
    @ResponseBody
    public String deleteDep(String dName){
        Department department=departmentServiceImpl.selectBydName(dName);
        List<Employee> employees=employeeServiceImpl.selectEmployee(department.getdId());
        if(employees.size()!=0){
            return "no";
        }else {
            return "ok";
        }
    }

    /**
     * 删除职位判断
     * @param pName
     * @return
     */
    @RequestMapping("deletePos")
    @ResponseBody
    public String deletePos(String pName){
        List<Employee> employees=employeeServiceImpl.selectByDuty(pName);
        if(employees.size()!=0){
            return "no";
        }else {
            return "ok";
        }
    }

    /**
     * 部门保存到数据库
     * @param map
     * @param dName
     * @return
     */
    @RequestMapping("commitAddDep")
    public String commitAddDep(ModelMap map,String dName){
        Timestamp timestamp=new Timestamp(System.currentTimeMillis());
        Department department=new Department(0,dName,timestamp);
        departmentServiceImpl.insert(department);

        return "forward:lookDuty";
    }

    /**
     * 职位保存到数据库
     * @param map
     * @param dId
     * @param pName
     * @return
     */
    @RequestMapping("commitAddPos")
    public String commitAddPos(ModelMap map,Integer dId,String pName){
        Timestamp timestamp=new Timestamp(System.currentTimeMillis());
        Position position=new Position(0,pName,dId,timestamp);
        positionServiceImpl.insert(position);

        return "forward:lookDuty";
    }

    /**
     * 员工管理
     * @param map
     * @return
     */
    @RequestMapping("employeeManage")
    public String employeeManage(ModelMap map){
        List<Employee> employees=employeeServiceImpl.selectAll();
        map.addAttribute("employees",employees);
        List<LeaveEmployee> leaveEmployees=leaveEmployeeServiceImpl.selectAll();
        map.addAttribute("leaveEmployees",leaveEmployees);
        return "admEmployeeManage";
    }

    /**
     * 跳转人事调度
     * @param map
     * @return
     */
    @RequestMapping("dutyManage")
    public String dutyManage(ModelMap map,HttpServletRequest request){
        int eId=0;
        try {
            eId=Integer.valueOf(request.getParameter("eId"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        LeaveEmployee leaveEmployee=leaveEmployeeServiceImpl.selectByEid(eId);
        if(leaveEmployee!=null){

        }else {
            Employee employee=employeeServiceImpl.SelectByEid(eId);
            List<Department> departments=departmentServiceImpl.selectAll();
            map.addAttribute("employee",employee);
            map.addAttribute("departments",departments);
        }
        return "admEmployeeManage";
    }

    /**
     * 保存人事调动
     * @param duty
     * @param eId
     * @param map
     * @return
     */
    @RequestMapping("commitDuty")
    public String commitDuty(String duty,Integer eId,Integer dId,ModelMap map){
        employeeServiceImpl.updateDuty(eId,dId,duty);
        List<Employee> employees=employeeServiceImpl.selectAll();
        map.addAttribute("employees",employees);
        return "admEmployeeManage";
    }
    /**
     * 发送培训
     * @param map
     * @return
     */
    @RequestMapping("sendCultivate")
    public String sendCultivate(ModelMap map){
        List<Department> departments=departmentServiceImpl.selectAll();
        map.addAttribute("departments",departments);
        return "admSendCultivate";
    }

    /**
     * 保存培训
     * @param createCultivate
     * @return
     */
    @RequestMapping("commitCultivate")
    public String commitCultivate(CreateCultivate createCultivate){
        createCultivateServiceImpl.insert(createCultivate);
        return "forward:gotoAdmPage";
    }

    /**
     * 开除员工
     * @param request
     * @param map
     * @return
     */
    @RequestMapping("deleteEmployee")
    public String deleteEmployee(HttpServletRequest request,ModelMap map){
        int eId=0;
        try {
            eId=Integer.valueOf(request.getParameter("eId"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        LeaveEmployee leaveEmployee1=leaveEmployeeServiceImpl.selectByEid(eId);
        if(leaveEmployee1!=null){

        }else {
            //改变员工的状态
            employeeServiceImpl.updateState(eId,0);
            //加入开除表
            java.sql.Date date=new java.sql.Date(System.currentTimeMillis());
            LeaveEmployee leaveEmployee=new LeaveEmployee(0,eId,date);
            leaveEmployeeServiceImpl.insert(leaveEmployee);
            //变成游客
            Employee employee=employeeServiceImpl.SelectByEid(eId);
            userServiceImpl.updateStatue(employee.getuId(),0);

            List<Department> departments=departmentServiceImpl.selectAll();
            map.addAttribute("departments",departments);
        }
        return "forward:employeeManage";
    }

    /**
     * 薪资管理
     * @param map
     * @return
     */
    @RequestMapping("wageManage")
    public String wageManage(ModelMap map){

       List<ResWage> resWages=employeeServiceImpl.selectAllResWage();
       map.addAttribute("resWages",resWages);
        return "admWageManage";
    }

    /**
     * 查看已发工资
     * @param request
     * @param map
     * @return
     */
    @RequestMapping("lookOldWage")
    public String lookOldWage(HttpServletRequest request,ModelMap map){
        int eId=0;
        try {
            eId=Integer.valueOf(request.getParameter("eId"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        List<Wage> wages=wageServiceImpl.selectByEid(eId);
        map.addAttribute("wages",wages);
        return "forward:wageManage";
    }

    /**
     * 结算工资
     * @param request
     * @param map
     * @return
     */
    @RequestMapping("closeWage")
    public String closeWage(HttpServletRequest request,ModelMap map){
        int eId=0;
        try {
            eId=Integer.valueOf(request.getParameter("eId"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM");
        //上个月的模糊时间
        Calendar car=Calendar.getInstance();
        car.setTime(new Date());
        car.add(Calendar.MONTH,-1);
        Date lastTime=car.getTime();
        String last=sf.format(lastTime);
        String lastMonth="%"+last+"%";
        //当前月的模糊时间
        Calendar calendar=Calendar.getInstance();
        Date newTime=calendar.getTime();
        String newMonth="%"+sf.format(newTime)+"%";
        CloseWage closeWage=null;
        try {
            closeWage=closeWageServiceImpl.selectCloseWage(newMonth,eId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(closeWage!=null){
            //如果已经结算，直接返回结果
            map.addAttribute("resCloseWage",closeWage);
            List<ResWage> resWages=employeeServiceImpl.selectAllResWage();
            map.addAttribute("resWages",resWages);
            return "admWageManage";
        }else {
            //上个月的天数
            int monthDay = car.getActualMaximum(Calendar.DATE);
            //出勤天数
            List<OnWork> onWorks=onWorkServiceImpl.selectMonthWorkTime(lastMonth,eId);
            int onWorkDay=onWorks.size();
            //基本工资
            BasicMoney basicMoney=basicMoneyServiceImpl.selectBasic(eId);
            //社保
            SocialMoney socialMoney=socialMoneyServiceImpl.selectSocialMoney(eId);
            //加班工资
            List<OverTimeMoney> overTimeMonies=overTimeMoneyServiceImpl.selectOverMoney(lastMonth,eId);
            int overTimeMoney= CloseOverTimeMoney.getOverMoney(overTimeMonies);
            //奖惩工资
            List<PunishMoney> punishMonies=punishMoneyServiceImpl.selectMonthMoney(lastMonth,eId);
            int punishMoney= ClosePunishMoney.getPunishMoney(punishMonies);
            //效绩奖金(当前月发奖金)
            List<BonusMoney> bonusMonies=bonusMoneyServiceImpl.selectBonusMoney(newMonth,eId);
            int bonusMoney= CloseBonusMoney.getBonusMoney(bonusMonies);
            //合计
            int total=0;
            if(onWorkDay==25){
                total=basicMoney.getbMoney()-socialMoney.getsMoney()+overTimeMoney+punishMoney+bonusMoney;
            }else if(onWorkDay<25){
                //整天未打卡每天减100
                total=basicMoney.getbMoney()-socialMoney.getsMoney()+overTimeMoney+punishMoney+bonusMoney-(25-onWorkDay)*100;
            }else if(25<onWorkDay&&onWorkDay<monthDay){
                //整天加班每天200，再加班（3小时记录在打卡中）
                total=basicMoney.getbMoney()-socialMoney.getsMoney()+overTimeMoney+punishMoney+bonusMoney+(onWorkDay-25)*200;
            }
            java.sql.Date date=new java.sql.Date(System.currentTimeMillis());
            CloseWage resCloseWage=new CloseWage(0,eId,monthDay,onWorkDay,basicMoney.getbMoney(),socialMoney.getsMoney(),overTimeMoney,punishMoney,bonusMoney,total,date);
            closeWageServiceImpl.insert(resCloseWage);
            //复议工资
            WageAdvise wageAdvise=wageAdviseServiceImpl.selectWageAdvise(lastMonth,eId,"同意");
            map.addAttribute("resCloseWage",resCloseWage);
            map.addAttribute("wageAdvise",wageAdvise);

            List<ResWage> resWages=employeeServiceImpl.selectAllResWage();
            map.addAttribute("resWages",resWages);
            return "admWageManage";
        }
    }

    /**
     * 发放工资
     * @param request
     * @return
     */
    @RequestMapping("sendWage")
    public String sendWage(HttpServletRequest request){
        int eId=0;
        try {
            eId=Integer.valueOf(request.getParameter("eId"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        //开除员工不能发放
        LeaveEmployee leaveEmployee=leaveEmployeeServiceImpl.selectByEid(eId);
        if(leaveEmployee!=null){

        }else {
            java.sql.Date date=new java.sql.Date(System.currentTimeMillis());
            SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM");
            //当前月的模糊时间
            Calendar calendar=Calendar.getInstance();
            Date newTime=calendar.getTime();
            String newMonth="%"+sf.format(newTime)+"%";
            //上个月的模糊时间
            Calendar car=Calendar.getInstance();
            car.setTime(new Date());
            car.add(Calendar.MONTH,-1);
            Date lastTime=car.getTime();
            String last=sf.format(lastTime);
            String lastMonth="%"+last+"%";
            //查找结算工资表
            CloseWage closeWage=null;
            try {
                closeWage=closeWageServiceImpl.selectCloseWage(newMonth,eId);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(closeWage==null){
                //如果未结算，跳转结算工资
                return "forward:wageManage";
            }else {
                //重复发工资
                Wage wage1=wageServiceImpl.selectWage(newMonth,eId);
                if(wage1!=null){

                }else {
                    //发放工资添加复议工资
                    WageAdvise wageAdvise=wageAdviseServiceImpl.selectWageAdvise(lastMonth,eId,"同意");
                    Wage wage=null;
                    if(wageAdvise==null){
                        wage=new Wage(0,closeWage.geteId(),closeWage.getBasicMoney(),closeWage.getBonusMoney(),closeWage.getOverTimeMoney(),closeWage.getPunishMoney(),closeWage.getSocialMoney(),date,0,closeWage.getTotal());
                    }else {
                        int total=closeWage.getTotal()+wageAdvise.getAdMoney();
                        wage=new Wage(0,closeWage.geteId(),closeWage.getBasicMoney(),closeWage.getBonusMoney(),closeWage.getOverTimeMoney(),closeWage.getPunishMoney(),closeWage.getSocialMoney(),date,wageAdvise.getAdMoney(),total);
                    }
                    wageServiceImpl.insert(wage);
                    return "forward:employeeManage";
                }
            }
        }
       return "forward:employeeManage";
    }

    /**
     * 添加社保
     * @param map
     * @param request
     * @return
     */
    @RequestMapping("addSocialMoney")
    public String addSocialMoney(ModelMap map,HttpServletRequest request){
        int eId=0;
        try {
            eId=Integer.valueOf(request.getParameter("eId"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        LeaveEmployee leaveEmployee=leaveEmployeeServiceImpl.selectByEid(eId);
        if(leaveEmployee!=null){

        }else {
            List<Employee> employees=employeeServiceImpl.selectAll();
            map.addAttribute("employees",employees);
            map.addAttribute("eId",eId);
            map.addAttribute("social","social");
        }
        return "admEmployeeManage";
    }

    /**
     * 保存社保数据
     * @param map
     * @param socialMoney
     * @return
     */
    @RequestMapping("commitSocialMoney")
    public String commitSocialMoney(ModelMap map,SocialMoney socialMoney){
        socialMoneyServiceImpl.insert(socialMoney);
        List<Employee> employees=employeeServiceImpl.selectAll();
        map.addAttribute("employees",employees);
        return "admEmployeeManage";
    }

    /**
     * 添加基本工资
     * @param request
     * @param map
     * @return
     */
    @RequestMapping("addBasicMoney")
    public String addBasicMoney(HttpServletRequest request,ModelMap map){
        int eId=0;
        try {
            eId=Integer.valueOf(request.getParameter("eId"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        LeaveEmployee leaveEmployee=leaveEmployeeServiceImpl.selectByEid(eId);
        if(leaveEmployee!=null){

        }else {
            List<Employee> employees=employeeServiceImpl.selectAll();
            map.addAttribute("employees",employees);
            map.addAttribute("eId",eId);
            map.addAttribute("basic","basic");
        }
        return "admEmployeeManage";
    }

    /**
     * 保存基本工资数据
     * @param map
     * @param basicMoney
     * @return
     */
    @RequestMapping("commitBasicMoney")
    public String commitBasicMoney(ModelMap map,BasicMoney basicMoney){
        basicMoneyServiceImpl.insert(basicMoney);
        List<Employee> employees=employeeServiceImpl.selectAll();
        map.addAttribute("employees",employees);
        return "admEmployeeManage";
    }

    /**
     * 跳转异议管理
     * @param map
     * @return
     */
    @RequestMapping("wageAdvice")
    public String wageAdvice(ModelMap map){
        List<WageAdvise> wageAdvises=wageAdviseServiceImpl.selectByResult("未查看");
        if(wageAdvises.size()==0){
            List<WageAdvise> wageAdvises1=wageAdviseServiceImpl.selectAll();
            map.addAttribute("wageAdvises1",wageAdvises1);
        }
        map.addAttribute("wageAdvises",wageAdvises);
        return "admWageAdvice";
    }

    /**
     * 保存复议结果
     * @param eId
     * @param waResult
     * @return
     */
    @RequestMapping("commitWageAdvice")
    public String commitWageAdvice(Integer eId,String waResult,ModelMap map){
        java.sql.Date date=new java.sql.Date(System.currentTimeMillis());
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM");
        //当前月的模糊时间
        Calendar calendar=Calendar.getInstance();
        Date newTime=calendar.getTime();
        String newMonth="%"+sf.format(newTime)+"%";
        wageAdviseServiceImpl.updateResult(newMonth,eId,waResult);
        List<WageAdvise> wageAdvises=wageAdviseServiceImpl.selectByResult("未查看");
        if(wageAdvises.size()==0){
            List<WageAdvise> wageAdvises1=wageAdviseServiceImpl.selectAll();
            map.addAttribute("wageAdvises1",wageAdvises1);
        }
        map.addAttribute("wageAdvises",wageAdvises);
        return "admWageAdvice";
    }
}
