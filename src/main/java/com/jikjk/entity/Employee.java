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
    private int eState;//状态

    public Employee() {
    }

    public Employee(Integer eId, Integer uId, String eName, Integer d_id, String duty, String eSex, Integer e_age, String e_education, BigInteger e_phone, String eEmail, Date eCreateTime, int eState) {
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
        this.eState = eState;
    }

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public Integer getD_id() {
        return d_id;
    }

    public void setD_id(Integer d_id) {
        this.d_id = d_id;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String geteSex() {
        return eSex;
    }

    public void seteSex(String eSex) {
        this.eSex = eSex;
    }

    public Integer getE_age() {
        return e_age;
    }

    public void setE_age(Integer e_age) {
        this.e_age = e_age;
    }

    public String getE_education() {
        return e_education;
    }

    public void setE_education(String e_education) {
        this.e_education = e_education;
    }

    public BigInteger getE_phone() {
        return e_phone;
    }

    public void setE_phone(BigInteger e_phone) {
        this.e_phone = e_phone;
    }

    public String geteEmail() {
        return eEmail;
    }

    public void seteEmail(String eEmail) {
        this.eEmail = eEmail;
    }

    public Date geteCreateTime() {
        return eCreateTime;
    }

    public void seteCreateTime(Date eCreateTime) {
        this.eCreateTime = eCreateTime;
    }

    public int geteState() {
        return eState;
    }

    public void seteState(int eState) {
        this.eState = eState;
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
                ", eTayue=" + eState +
                '}';
    }
}
