package com.jikjk.handler;

import com.alibaba.fastjson.JSON;
import com.jikjk.entity.*;
import com.jikjk.entity.utilpojo.ResSendResume;
import com.jikjk.service.*;
import com.jikjk.util.Md5;
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
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by lenovo on 2018/10/11.
 */
@RequestMapping("user")
@Controller()
public class UserServlet {
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
    @InitBinder
    public void initBinder(ServletRequestDataBinder binder){
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),
                true));
    }

    /**
     * �ο�ע��
     * @param uName
     * @param uPassword
     * @return
     */
    @RequestMapping("register")
    public String register(String uName,String uPassword){
        Timestamp uCreatetime=new Timestamp(System.currentTimeMillis());
        User user=new User(-1,-1,uName,uPassword,uCreatetime,0);
        userServiceImpl.insert(user);
        return "userLogin";
    }

    /**
     * �ο���֤���û����Ƿ����
     * @param uName
     * @return
     */
    @RequestMapping("varifySameUname")
    @ResponseBody
    public String varifySameUname(String uName){
        //���ηǿ���֤
        User user=userServiceImpl.selectByUname(uName);
        if(user!=null){
            return "yes";
        }else {
            return "no";
        }
    }
    /**
     * ��¼����user����session
     * @param uName
     * @param uPassword
     * @param session
     * @return
     */
    @RequestMapping("login")
    public String login(String uName, String uPassword, HttpSession session,ModelMap map){
        //���ηǿ���֤
        String uPassword1= Md5.md5(uPassword);
        User user=null;
        try {
            user=userServiceImpl.selectTologin(uName,uPassword1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(user!=null){
            session.setAttribute("user",user);
        }
        if(user!=null&&user.getStatus()==0){
            return "userPage";
        }
        if(user!=null&&user.getStatus()==1){
            Employee employee=employeeServiceImpl.selectByUid(user.getuId());
            session.setAttribute("employee",employee);
            return "empPage";
        }
        if(user!=null&&user.getStatus()==2){
            Administrator administrator=admServiceImpl.selectByUid(user.getuId());
            session.setAttribute("adm",administrator);
            return "admPage";
        }
        return "forward:/login.jsp";
    }

    /**
     * �鿴��Ƹ��Ϣ
     * @return
     */
    @RequestMapping("lookJob")
    public String lookJob(ModelMap map){
        List<InviteJob> inviteJobs=inviteJobServiceImpl.selectAll();
        map.addAttribute("inviteJobs",inviteJobs);
        return "userLookJob";
    }
    /**
     * �û�����޸ļ���
     * @param map
     * @param session
     * @return
     */
    @RequestMapping("resume")
    public String addResume(ModelMap map,HttpSession session){
    /*    Integer uId=0;
        try {
            uId=Integer.valueOf(request.getParameter("uId"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }*/
        User user= (User) session.getAttribute("user");
        Resume resume=resumeServiceImpl.selectByUid(user.getuId());
        if(resume!=null){
            //�жϼ����Ƿ���ڻ���
            String aimDuty=positionServiceImpl.selectNameByPid(resume.getAimDuty());
            map.addAttribute("resume",resume);
            map.addAttribute("aimDuty",aimDuty);
        }
    /*    //�ж���ӻ����޸�
        if(uId!=0){
            //�޸ļ������޼�����ת���
            if(resume==null){
                List<Department> departments=departmentServiceImpl.selectAll();
                map.addAttribute("departments",departments);
                return "userResume";
            }else {
                //�޸Ļ���
                String aimDuty=positionServiceImpl.selectNameByPid(resume.getAimDuty());
                map.addAttribute("resume",resume);
                map.addAttribute("aimDuty",aimDuty);
            }
        }*/
        List<Department> departments=departmentServiceImpl.selectAll();
        map.addAttribute("departments",departments);
        return "userResume";
    }

    /**
     * ��Ӽ���
     * @param map
     * @param resume
     * @return
     */
    @RequestMapping("commitAddResume")
    public String commitAddResume(ModelMap map,Resume resume){
        System.out.println(resume);
        resumeServiceImpl.insert(resume);
        map.addAttribute("resume",resume);
        return "userPage";
    }

    /**
     * �޸ļ���
     * @param resume
     * @param request
     * @return
     */
    @RequestMapping("commitSetResume")
    public String commitSetResume(Resume resume,HttpServletRequest request){
        resumeServiceImpl.update(resume);
        return "userPage";
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
     * ���ͼ���
     * @param request
     * @param session
     * @return
     */
    @RequestMapping("sendResume")
    public String sendResume(HttpServletRequest request,HttpSession session){
        User user=(User)session.getAttribute("user");
        int uId=user.getuId();
        Resume resume=resumeServiceImpl.selectByUid(uId);
        //���ͼ����޼������½�����
        if(resume==null){
            return "forward:resume";
        }
        int rId=resumeServiceImpl.selectByUid(uId).getrId();
        Date date=new Date(System.currentTimeMillis());
        //�������������¼
        sendResumeServiceImpl.insert(rId,uId,date);
        MassageResume massageResume=new MassageResume(0,rId,date,"","");
        massageResumeServiceImpl.insert(massageResume);
        return "userPage";
    }

    /**
     * �鿴������״̬
     * @param request
     * @param map
     * @return
     */
    @RequestMapping("lookResumeState")
    public String lookResumeState(HttpServletRequest request,ModelMap map){
        int uId=0;
        try {
            uId=Integer.valueOf(request.getParameter("uId"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        List<ResSendResume> resSendResumes=sendResumeServiceImpl.selectResByUid(uId);
        map.addAttribute("sendResumes",resSendResumes);
        return "userlookResumeState";
    }

    /**
     * ������ҳ
     * @return
     */
    @RequestMapping("gotoUserPage")
    public String gotoUserPage(){
        return "userPage";
    }

    @RequestMapping("lookInform")
    public String lookInform(HttpServletRequest request,ModelMap map){
        int rId=0;
        try {
            rId=Integer.valueOf(request.getParameter("rId"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        Interview interview=interviewServiceImpl.selectByRid(rId);
        map.addAttribute("interview",interview);
        return "userLookInform";
    }
}
