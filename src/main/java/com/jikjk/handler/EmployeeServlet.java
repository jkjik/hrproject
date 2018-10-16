package com.jikjk.handler;

import com.jikjk.dao.EmployeeDao;
import com.jikjk.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by lenovo on 2018/10/16.
 */
@RequestMapping("emp")
@Controller
public class EmployeeServlet {
    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping("lookDuty")
    public String lookDuty(){
        return "empLookingDuty";
    }
    @RequestMapping("lookingYourself")
    public String lookingYourself(HttpSession session){
        return "empYourself";
    }
}
