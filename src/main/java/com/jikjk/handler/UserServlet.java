package com.jikjk.handler;

import com.alibaba.fastjson.JSON;
import com.jikjk.entity.Department;
import com.jikjk.entity.Position;
import com.jikjk.entity.Resume;
import com.jikjk.entity.User;
import com.jikjk.service.DepartmentService;
import com.jikjk.service.PositionService;
import com.jikjk.service.ResumeService;
import com.jikjk.service.UserService;
import com.jikjk.util.Md5;
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
import java.util.Date;
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

    /**
     * 游客注册
     * @param uName
     * @param uPassword
     * @return
     */
    @RequestMapping("register")
    public String register(String uName,String uPassword){
        Timestamp uCreatetime=new Timestamp(System.currentTimeMillis());
        User user=new User(-1,uName,uPassword,uCreatetime,0);
        userServiceImpl.insert(user);
        return "userPage";
    }

    /**
     * 游客验证此用户名是否存在
     * @param uName
     * @return
     */
    @RequestMapping("varifySameUname")
    @ResponseBody
    public String varifySameUname(String uName){
        //传参非空验证
        User user=userServiceImpl.selectByUname(uName);
        if(user!=null){
            return "yes";
        }else {
            return "no";
        }
    }
    @RequestMapping("login")
    public String login(String uName, String uPassword, HttpSession session){
        //传参非空验证
        String uPassword1= Md5.md5(uPassword);
        User user=userServiceImpl.selectTologin(uName,uPassword1);
        if(user!=null){
            session.setAttribute("user",user);
        }
        if(user!=null&&user.getStatue()==0){

            return "userToEmploy";
        }
        return "forward:login";
    }

    /**
     * 用户添加修改简历
     * @param map
     * @param request
     * @return
     */
    @RequestMapping("Resume")
    public String addResume(ModelMap map, HttpServletRequest request){
        Integer uId=0;
        try {
            uId=Integer.valueOf(request.getParameter("uId"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if(uId!=0){
            Resume resume=resumeServiceImpl.selectByUid(uId);
            String aimDuty=positionServiceImpl.selectNameByPid(resume.getAimDuty());
            map.addAttribute("resume",resume);
            map.addAttribute("aimDuty",aimDuty);
        }
        List<Department> departments=departmentServiceImpl.selectAll();
        map.addAttribute("departments",departments);
        return "userResume";
    }

    /**
     * 获取职位数据
     * @param dept
     * @return
     */
    @RequestMapping("getPosition")
    @ResponseBody
    public String getPosition(Integer dept){
        List<Position> positions=positionServiceImpl.selectById(dept);
        String json=JSON.toJSONString(positions);
        System.out.println(json);
        return json;
    }
}
