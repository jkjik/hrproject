package com.jikjk.handler;

import com.jikjk.entity.*;
import com.jikjk.entity.respojo.ResMassageResume;
import com.jikjk.service.*;
import com.jikjk.service.impl.InterviewResultServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping("sendInvite")
    public String sendInviteJob(){
        return "admSendInvite";
    }
    @RequestMapping("commitSendInvite")
    public String commitSendInvite(InviteJob inviteJob){
        inviteJobServiceImpl.insert(inviteJob);
        return "admPage";
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
        return "admLookingResume";
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
        interviewResultServiceImpl.insert(interviewResult);
        sendResumeServiceImpl.updateInformState(interviewResult.getrId(),"��֪ͨ");
        return "forward:interviewInform";
    }
}
