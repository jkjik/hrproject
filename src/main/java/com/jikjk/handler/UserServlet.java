package com.jikjk.handler;

import com.jikjk.entity.User;
import com.jikjk.service.UserService;
import com.jikjk.util.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lenovo on 2018/10/11.
 */
@RequestMapping("user")
@Controller()
public class UserServlet {
    @Autowired
    private UserService userServiceImpl;
    @RequestMapping("register")
    public String register(String uName,String uPassword){
        Timestamp uCreatetime=new Timestamp(System.currentTimeMillis());
        User user=new User(-1,uName,uPassword,uCreatetime,0);
        userServiceImpl.insert(user);
        return "userPage";
    }
    @RequestMapping("varifySameUname")
    @ResponseBody
    public String varifySameUname(String uName){
        System.out.println(uName);
        User user=userServiceImpl.selectByUname(uName);
        System.out.println(user);
        if(user!=null){
            return "yes";
        }else {
            return "no";
        }
    }
    @RequestMapping("login")
    public String login(String uName,String uPassword){
        //∑«ø’—È÷§
        String uPassword1= Md5.md5(uPassword);
        User user=userServiceImpl.selectTologin(uName,uPassword1);
        if(user!=null&&user.getStatue()==0){
            return "userToEmploy";
        }
        return "forward:login";
    }
}
