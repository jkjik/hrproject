package com.jikjk.handler;

import com.jikjk.entity.*;
import com.jikjk.entity.utilpojo.ResMassageResume;
import com.jikjk.service.*;
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
    @InitBinder
    public void initBinder(ServletRequestDataBinder binder){
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"),
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
     * ������Խ��
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
        System.out.println(dId);
        //ְλ
        List<Position> positions= positionServiceImpl.selectById(dId);
        map.addAttribute("positions",positions);
        System.out.println(positions);
        //���в���
        List<Department> departments=departmentServiceImpl.selectAll();
        System.out.println(departments);
        map.addAttribute("departments",departments);
        return "admLookingDuty";
    }

    /**
     * ɾ�����Ż�ְλ
     * @param request
     * @return
     */
    @RequestMapping("deleteDepAndPos")
    public String deleteDepAndPos(HttpServletRequest request,ModelMap map){
        int dId=0;
        int pId=0;
        try {
            pId=Integer.valueOf(request.getParameter("pId"));
            dId=Integer.valueOf(request.getParameter("dId"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if(dId!=0){
            departmentServiceImpl.delete(dId);
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
    @RequestMapping("addDepAndPos")
    public String addDepAndPos(HttpServletRequest request,ModelMap map){
        int dep=0;
        int pos=0;
        try {
            dep=Integer.valueOf(request.getParameter("dep"));
            pos=Integer.valueOf(request.getParameter("pos"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if(dep==1){
            map.addAttribute("dep",dep);
        }
        if(pos==1){
            List<Department> depre=departmentServiceImpl.selectAll();
            map.addAttribute("pos",pos);
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
        List<Position> positions=positionServiceImpl.selectById(department.getdId());
        if(positions!=null){
            return "no";
        }
        return "ok";
    }
}
