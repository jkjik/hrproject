package com.jikjk.util;

import com.jikjk.entity.Employee;
import com.jikjk.entity.Resume;
import java.sql.Date;

/**
 * Created by lenovo on 2018/10/17.
 */
public class ResumeToEmp {
    public static Employee toChange(Resume resume,int duty){
        Date date=new Date(System.currentTimeMillis());
        Employee employee=new Employee(0,resume.getuId(),resume.getrName(),duty,resume.getAimDuty(),resume.getrSex(),resume.getrAge(),resume.getEducation(),resume.getPhone(),resume.getEmail(),date,1);
        return employee;
    }
}
