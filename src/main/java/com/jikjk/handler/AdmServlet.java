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
    @InitBinder
    public void initBinder(ServletRequestDataBinder binder){
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),
                true));
    }

    /**
     * ������Ƹ��Ϣ
     * @return
     */
    @RequestMapping("sendInvite")
    public String sendInviteJob(ModelMap map){
        List<Department> departments=departmentServiceImpl.selectAll();
        map.addAttribute("departments",departments);
        return "admSendInvite";
    }

    /**
     * ���淢����Ϣ
     * @param inviteJob
     * @return
     */
    @RequestMapping("commitSendInvite")
    public String commitSendInvite(InviteJob inviteJob){
        inviteJobServiceImpl.insert(inviteJob);
        return "admPage";
    }

    /**
     * ��ȡְλ����
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
     * �鿴���м���
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
     * �鿴���˼���
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
        //�޸�sendResmue�Ĳ鿴״̬
        sendResumeServiceImpl.updateReadState(rId,"�Ѳ鿴");
        //�޸ļ�����¼�鿴״̬
        massageResumeServiceImpl.updateStateRead(rId,"�Ѳ鿴");
        Resume resume=resumeServiceImpl.selectByRid(rId);
        map.addAttribute("resume",resume);
        return "admLookingResume";
    }

    /**
     * ɾ������
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
        return "admLookResume";
    }

    /**
     * ��������
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
        Resume resume=resumeServiceImpl.selectByRid(rId);
        map.addAttribute("resume",resume);
        return "admInterview";
    }

    /**
     * ����֪ͨ
     * @param interview
     * @return
     */
    @RequestMapping("interviewInform")
    public String interviewInform(Interview interview){
        interviewServiceImpl.insert(interview);
        //�޸��οͶ˵�����֪ͨ
        sendResumeServiceImpl.updateInformState(interview.getrId(),"��֪ͨ");
        return "forward:lookingResume";
    }

    /**
     * ���ز鿴����
     * @return
     */
    @RequestMapping("gotoLookResume")
    public String gotoLookResume(){
        return "forward:lookResume";
    }

    /**
     * ���Խ��
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
        Interview interview=interviewServiceImpl.selectByRid(rId);
        Resume resume=resumeServiceImpl.selectByRid(rId);
        map.addAttribute("resume",resume);
        map.addAttribute("interview",interview);
        map.addAttribute("interviewResult",interviewResult);
        return "admIntvResult";
    }

    /**
     * ������Խ��(¼��)
     * @param interviewResult
     * @return
     */
    @RequestMapping("addIntvResult")
    public String addIntvResult(InterviewResult interviewResult){
        java.sql.Date date=new java.sql.Date(System.currentTimeMillis());
        interviewResult.setIrCreatetimr(date);
        //�������Խ����
        interviewResultServiceImpl.insert(interviewResult);
        //�ο�����֪ͨ
        sendResumeServiceImpl.updateInformState(interviewResult.getrId(),"��֪ͨ");
        //����û�
        Resume resume=resumeServiceImpl.selectByRid(interviewResult.getrId());
        int duty=positionServiceImpl.selectDidByName(resume.getAimDuty());
        Employee employee= ResumeToEmp.toChange(resume,duty);
        employeeServiceImpl.insert(employee);
        userServiceImpl.updateStatue(resume.getuId(),1);
        return "forward:gotoAdmPage";
    }

    /**
     * ���ع���Ա��ҳ
     * @return
     */
    @RequestMapping("gotoAdmPage")
    public String gotoAdmPage(){
        return "admPage";
    }

    /**
     * �鿴����
     * @param map
     * @return
     */
    @RequestMapping("lookDuty")
    public String lookDuty(ModelMap map){
        List<Department> departments=departmentServiceImpl.selectAll();
        map.addAttribute("departments",departments);
        return "admLookingDuty";
    }

    /**
     * �鿴ְλ
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
        //ְλ
        List<Position> positions= positionServiceImpl.selectById(dId);
        map.addAttribute("positions",positions);
        //���в���
        List<Department> departments=departmentServiceImpl.selectAll();
        map.addAttribute("departments",departments);
        return "admLookingDuty";
    }

    /**
     * ɾ������
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
            //ɾ������
            departmentServiceImpl.delete(dId);
            //ɾ�������µ�ְλ
            positionServiceImpl.deleteByDid(dId);
        }
        //���в���
        List<Department> departments=departmentServiceImpl.selectAll();
        map.addAttribute("departments",departments);
        return "admLookingDuty";
    }

    /**
     * ɾ��ְλ
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
        //���в���
        List<Department> departments=departmentServiceImpl.selectAll();
        map.addAttribute("departments",departments);
        return "admLookingDuty";
    }
    /**
     * ��Ӳ���
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

        //���в���
        List<Department> departments=departmentServiceImpl.selectAll();
        map.addAttribute("departments",departments);
        return "admLookingDuty";
    }

    /**
     * ����Ա��
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
        map.addAttribute("eId",eId);
        map.addAttribute("award","award");
        return "forward:employeeManage";
    }

    /**
     * ��ת�鿴����
     * @Param request
     * @Param map
     * @return
     */
    @RequestMapping("lookEmpWork")
    public String lookEmpWork(HttpServletRequest request,ModelMap map){
        int eId=0;
        try {
            eId=Integer.valueOf(request.getParameter("eId"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        List<OnWork> onWorks=onWorkServiceImpl.selectByEid(eId);
        map.addAttribute("onWorks",onWorks);
        return "admLookEmpWork";
    }
/*
    *//**
     * ��ҳ�Ĵ�ֵ
     * @return
     *//*
    @RequestMapping("lookingEmpWork")
    @ResponseBody
    public String lookingEmpWork(){
        List<OnWork> onWorks=onWorkServiceImpl.selectAll();
        ObjectMapper mapper=new ObjectMapper();
        String json= null;
        try {
            json = mapper.writeValueAsString(onWorks);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }*/
    /**
     * ���潱��
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
     * ���Ч������
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
     * ���ְλ
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
        //���в���
        List<Department> departments=departmentServiceImpl.selectAll();
        map.addAttribute("departments",departments);
        return "admLookingDuty";
    }

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
     * ���ű��浽���ݿ�
     * @param map
     * @param dName
     * @return
     */
    @RequestMapping("commitAddDep")
    public String commitAddDep(ModelMap map,String dName){
        Timestamp timestamp=new Timestamp(System.currentTimeMillis());
        Department department=new Department(0,dName,timestamp);
        departmentServiceImpl.insert(department);
        //���в���
        List<Department> departments=departmentServiceImpl.selectAll();
        map.addAttribute("departments",departments);
        return "admLookingDuty";
    }

    /**
     * ְλ���浽���ݿ�
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
        //���в���
        List<Department> departments=departmentServiceImpl.selectAll();
        map.addAttribute("departments",departments);
        return "admLookingDuty";
    }

    /**
     * Ա������
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
     * ��ת���µ���
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
        Employee employee=employeeServiceImpl.SelectByEid(eId);
        List<Department> departments=departmentServiceImpl.selectAll();
        map.addAttribute("employee",employee);
        map.addAttribute("departments",departments);
        return "admEmployeeManage";
    }

    /**
     * �������µ���
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
     * ������ѵ
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
     * ������ѵ
     * @param createCultivate
     * @return
     */
    @RequestMapping("commitCultivate")
    public String commitCultivate(CreateCultivate createCultivate){
        createCultivateServiceImpl.insert(createCultivate);
        return "forward:gotoAdmPage";
    }

    /**
     * ����Ա��
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
        employeeServiceImpl.updateState(eId,0);
        //���뿪����
        java.sql.Date date=new java.sql.Date(System.currentTimeMillis());
        LeaveEmployee leaveEmployee=new LeaveEmployee(0,eId,date);
        leaveEmployeeServiceImpl.insert(leaveEmployee);
        //����ο�
        Employee employee=employeeServiceImpl.SelectByEid(eId);
        userServiceImpl.updateStatue(employee.getuId(),0);
        List<Department> departments=departmentServiceImpl.selectAll();
        map.addAttribute("departments",departments);
        return "forward:employeeManage";
    }

    /**
     * н�ʹ���
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
     * �鿴�ѷ�����
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
     * ���㹤��
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
        //�ϸ��µ�ģ��ʱ��
        Calendar car=Calendar.getInstance();
        car.setTime(new Date());
        car.add(Calendar.MONTH,-1);
        Date lastTime=car.getTime();
        String last=sf.format(lastTime);
        String lastMonth="%"+last+"%";
        //�ϸ��µ�����
        int monthDay = car.getActualMaximum(Calendar.DATE);
        //��������
        List<OnWork> onWorks=onWorkServiceImpl.selectMonthWorkTime(lastMonth,eId);
        int onWorkDay=onWorks.size();
        //��������
        BasicMoney basicMoney=basicMoneyServiceImpl.selectBasic(eId);
        //�籣
        SocialMoney socialMoney=socialMoneyServiceImpl.selectSocialMoney(eId);
        //�Ӱ๤��
        List<OverTimeMoney> overTimeMonies=overTimeMoneyServiceImpl.selectOverMoney(lastMonth,eId);
        int overTimeMoney= CloseOverTimeMoney.getOverMoney(overTimeMonies);
        //���͹���
        List<PunishMoney> punishMonies=punishMoneyServiceImpl.selectMonthMoney(lastMonth,eId);
        int punishMoney= ClosePunishMoney.getPunishMoney(punishMonies);
        //Ч������
        List<BonusMoney> bonusMonies=bonusMoneyServiceImpl.selectBonusMoney(lastMonth,eId);
        int bonusMoney= CloseBonusMoney.getBonusMoney(bonusMonies);
        //�ϼ�
        int total=0;
        if(onWorkDay==25){
           total=basicMoney.getbMoney()-socialMoney.getsMoney()+overTimeMoney+punishMoney+bonusMoney;
        }else if(onWorkDay<25){
            //����δ��ÿ���100
            total=basicMoney.getbMoney()-socialMoney.getsMoney()+overTimeMoney+punishMoney+bonusMoney-(25-onWorkDay)*100;
        }else if(25<onWorkDay&&onWorkDay<monthDay){
            //����Ӱ�ÿ��200���ټӰࣨ3Сʱ��¼�ڴ��У�
            total=basicMoney.getbMoney()-socialMoney.getsMoney()+overTimeMoney+punishMoney+bonusMoney+(onWorkDay-25)*200;
        }
        java.sql.Date date=new java.sql.Date(System.currentTimeMillis());
        CloseWage resCloseWage=new CloseWage(0,eId,monthDay,onWorkDay,basicMoney.getbMoney(),socialMoney.getsMoney(),overTimeMoney,punishMoney,bonusMoney,total,date);
        closeWageServiceImpl.insert(resCloseWage);
        //���鹤��
        WageAdvise wageAdvise=wageAdviseServiceImpl.selectWageAdvise(lastMonth,eId,"ͬ��");
        map.addAttribute("resCloseWage",resCloseWage);
        map.addAttribute("wageAdvise",wageAdvise);

        List<ResWage> resWages=employeeServiceImpl.selectAllResWage();
        map.addAttribute("resWages",resWages);
        return "admWageManage";
    }

    /**
     * ��֤���Ź���
     * @param eId
     * @return
     */
    @RequestMapping("sendWageTime")
    @ResponseBody
    public String sendWageTime(Integer eId){
        SimpleDateFormat sf1=new SimpleDateFormat("dd");
        Date date=new Date();
        String day=sf1.format(date);
        System.out.println(eId);
        System.out.println(day);
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM");
        //�ϸ��µ�ģ��ʱ��
        Calendar car=Calendar.getInstance();
        car.setTime(new Date());
        car.add(Calendar.MONTH,-1);
        Date lastTime=car.getTime();
        String last=sf.format(lastTime);
        String lastMonth="%"+last+"%";
        CloseWage closeWage=closeWageServiceImpl.selectCloseWage(lastMonth,eId);
        if(!day.equals("15")){
            return "noTime";
        }else if(closeWage==null){
            return "noClose";
        }else{
            return "ok";
        }
    }

    /**
     * ���Ź���
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
        java.sql.Date date=new java.sql.Date(System.currentTimeMillis());
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM");
        //�ϸ��µ�ģ��ʱ��
        Calendar car=Calendar.getInstance();
        car.setTime(new Date());
        car.add(Calendar.MONTH,-1);
        Date lastTime=car.getTime();
        String last=sf.format(lastTime);
        String lastMonth="%"+last+"%";
        CloseWage closeWage=closeWageServiceImpl.selectCloseWage(lastMonth,eId);
        WageAdvise wageAdvise=wageAdviseServiceImpl.selectWageAdvise(lastMonth,eId,"ͬ��");
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
    /**
     * ����籣
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
        List<Employee> employees=employeeServiceImpl.selectAll();
        map.addAttribute("employees",employees);
        map.addAttribute("eId",eId);
        map.addAttribute("social","social");
        return "admEmployeeManage";
    }

    /**
     * �����籣����
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
     * ��ӻ�������
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
        List<Employee> employees=employeeServiceImpl.selectAll();
        map.addAttribute("employees",employees);
        map.addAttribute("eId",eId);
        map.addAttribute("basic","basic");
        return "admEmployeeManage";
    }

    /**
     * ���������������
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
     * ��ת�������
     * @param map
     * @return
     */
    @RequestMapping("wageAdvice")
    public String wageAdvice(ModelMap map){
        List<WageAdvise> wageAdvises=wageAdviseServiceImpl.selectByResult("δ�鿴");
        System.out.println(wageAdvises);
        if(wageAdvises.size()==0){
            List<WageAdvise> wageAdvises1=wageAdviseServiceImpl.selectAll();
            map.addAttribute("wageAdvises1",wageAdvises1);
        }
        map.addAttribute("wageAdvises",wageAdvises);
        return "admWageAdvice";
    }

    /**
     * ���渴����
     * @param eId
     * @param waResult
     * @return
     */
    @RequestMapping("commitWageAdvice")
    public String commitWageAdvice(Integer eId,String waResult,ModelMap map){
        java.sql.Date date=new java.sql.Date(System.currentTimeMillis());
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM");
        //�ϸ��µ�ģ��ʱ��
        Calendar car=Calendar.getInstance();
        car.setTime(new Date());
        car.add(Calendar.MONTH,-1);
        Date lastTime=car.getTime();
        String last=sf.format(lastTime);
        String lastMonth="%"+last+"%";
        wageAdviseServiceImpl.updateResult(lastMonth,eId,waResult);
        List<WageAdvise> wageAdvises=wageAdviseServiceImpl.selectByResult("δ�鿴");
        if(wageAdvises.size()==0){
            List<WageAdvise> wageAdvises1=wageAdviseServiceImpl.selectAll();
            map.addAttribute("wageAdvises1",wageAdvises1);
        }
        map.addAttribute("wageAdvises",wageAdvises);
        return "admWageAdvice";
    }
}
