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
     * �����û���ҳ
     * @return
     */
    @RequestMapping("gotoEmpPage")
    public String gotoEmpPage(){
        return "empPage";
    }

    /**
     * �鿴������Ϣ
     * @return
     */
    @RequestMapping("lookDuty")
    public String lookDuty(ModelMap map){
        List<Department> departments=departmentServiceImpl.selectAll();
        map.addAttribute("departments",departments);
        return "empLookingDuty";
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
        Employee employee= (Employee) session.getAttribute("employee");
        //�鿴������Ա��
        if(employee.getdId()==dId){
            List<Employee> employees=employeeServiceImpl.selectEmployee(employee.getdId());
            map.addAttribute("employees",employees);
        }
        List<Position> positions= positionServiceImpl.selectById(dId);
        map.addAttribute("positions",positions);
        //������Ϣ
        List<Department> departments=departmentServiceImpl.selectAll();
        map.addAttribute("departments",departments);
        return "empLookingDuty";
    }

    /**
     * �鿴������Ϣ
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
     * �鿴��ѵ֪ͨ
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
     * ���ϰ࿨�ɹ�
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
        //�ظ����ϰ࿨����
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
        String start=sf.format(date);
        String startTimeLike="%"+start+"%";
        OnWork onWork1=onWorkServiceImpl.selectByLike(startTimeLike,eId);
        if(onWork1!=null){
            return "fail";
        }else {
            String onWorkState= OnWorkTime.CheckOnWork();
            if("����".equals(onWorkState)){

            }
            if("�ٵ�".equals(onWorkState)){
                //�ٵ���50
                PunishMoney punishMoney=new PunishMoney(0,eId,onWorkState,-50,date);
                punishMoneyServiceImpl.insert(punishMoney);
            }
            if("ȱ��".equals(onWorkState)){
                //ȱ�ڿ�100
                PunishMoney punishMoney=new PunishMoney(0,eId,onWorkState,-100,date);
                punishMoneyServiceImpl.insert(punishMoney);
            }
            OnWork onWork=new OnWork(0,employee.geteId(),timestamp,timestamp,onWorkState,"δ��");
            onWorkServiceImpl.insert(onWork);
        }
        //�ж��Ƿ�򿨳ɹ�
        OnWork onWork2=onWorkServiceImpl.selectByLike(startTimeLike,eId);
        if(onWork2!=null){
            return "ok";
        }else {
            return "no";
        }
    }

    /**
     * �°�򿨳ɹ�
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
        if("����".equals(offWorkState)){

        }
        if("����".equals(offWorkState)){
            //���˿�50
            PunishMoney punishMoney=new PunishMoney(0,eId,offWorkState,-50,date);
            punishMoneyServiceImpl.insert(punishMoney);
        }
        if("�Ӱ�".equals(offWorkState)){
            //�Ӱ�Ѽ���Ӱ��
            OverTimeMoney overTimeMoney=new OverTimeMoney(0,eId,100,date);
            overTimeMoneyServiceImpl.insert(overTimeMoney);
        }
        //��ѯ������ļ�¼
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
            //�ظ���
            if(!"δ��".equals(onWork.getOffWorkState())){
                return "fail";
            }else {
                onWork.setEndTime(timestamp);
                onWork.setOffWorkState(offWorkState);
                //��
                onWorkServiceImpl.update(onWork);
            }

        }
        //�ж��Ƿ�򿨳ɹ�
        OnWork onWork1=onWorkServiceImpl.selectByLike(startTimeLike,eId);
        if("δ��".equals(onWork1.getOffWorkState())){
            return "no";
        }else {
            return "ok";
        }
    }
    /**
     * �鿴���п���
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
     * �鿴���¿���
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
     * �鿴���ͼ�¼
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
     * �鿴������
     * @param session
     * @param map
     * @return
     */
    @RequestMapping("lookMonthWage")
    public String lookMonthWage(HttpSession session,ModelMap map){
        Employee employee= (Employee) session.getAttribute("employee");
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM");
        //��ǰ�µ�ģ��ʱ��
        Calendar calendar=Calendar.getInstance();
        Date newTime=calendar.getTime();
        String newMonth="%"+sf.format(newTime)+"%";
        Wage wage=wageServiceImpl.selectWage(newMonth,employee.geteId());
        map.addAttribute("wage",wage);
        //�鿴����
        List<WageAdvise> wageAdvises=wageAdviseServiceImpl.selectByEid(employee.geteId());
        map.addAttribute("wageAdvises",wageAdvises);
        return "empLookMonthWage";
    }

    /**
     * ��ӹ�������
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
