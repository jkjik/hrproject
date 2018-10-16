package com.jikjk.entity;

import java.math.BigInteger;
import java.sql.Date;

/**
 * Created by lenovo on 2018/10/16.
 */
public class Employee {
    private Integer eId;
    private Integer uId;//游客id
    private String eName;
    private Integer d_id;//部门id
    private String duty;//职务
    private String eSex;
    private Integer e_age;
    private String e_education;
    private BigInteger e_phone;
    private String eEmail;
    private Date eCreateTime;
    private int eTayue;//状态

    public Employee() {
    }

    public Employee(Integer eId, Integer uId, String eName, Integer d_id, String duty, String eSex, Integer e_age, String e_education, BigInteger e_phone, String eEmail, Date eCreateTime, int eTayue) {
        this.eId = eId;
        this.uId = uId;
        this.eName = eName;
        this.d_id = d_id;
        this.duty = duty;
        this.eSex = eSex;
        this.e_age = e_age;
        this.e_education = e_education;
        this.e_phone = e_phone;
        this.eEmail = eEmail;
        this.eCreateTime = eCreateTime;
        this.eTayue = eTayue;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eId=" + eId +
                ", uId=" + uId +
                ", eName='" + eName + '\'' +
                ", d_id=" + d_id +
                ", duty='" + duty + '\'' +
                ", eSex='" + eSex + '\'' +
                ", e_age=" + e_age +
                ", e_education='" + e_education + '\'' +
                ", e_phone=" + e_phone +
                ", eEmail='" + eEmail + '\'' +
                ", eCreateTime=" + eCreateTime +
                ", eTayue=" + eTayue +
                '}';
    }
}
