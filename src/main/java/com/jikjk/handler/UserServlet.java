package com.jikjk.handler;

import com.jikjk.entity.User;
import com.jikjk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Created by lenovo on 2018/10/11.
 */
@RequestMapping("user")
@Controller()
public class UserServlet {
    @Autowired
    private UserService userServiceImpl;
    @RequestMapping("register")
    public String register(User user){
        Timestamp uCreatetime= new Timestamp(System.currentTimeMillis());
        user.setuCreatetime(uCreatetime);
        System.out.println(user);
        return "userPage";
    }
    @RequestMapping("test")
    public String test(int id){
        System.out.println(id);
        return "userPage";
    }
   /* @InitBinder
    public void initBinder(ServletRequestDataBinder binder){
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"),
                true));
    }*/
}
