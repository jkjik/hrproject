package com.jikjk.entity;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by lenovo on 2018/10/16.
 */
public class Employee {
    private Integer eId;
    private Integer uId;//游客id
    private String eName;
    private Integer dId;//部门id
    private String duty;//职务
    private String eSex;
    private Integer eAge;
    private String eEducation;
    private String ePhone;
    private String eEmail;
    private Date eCreateTime;
    private int eState;//状态

    public Employee() {
    }

    public Employee(Integer eId, Integer uId, String eName, Integer dId, String duty, String eSex, Integer eAge, String eEducation, String ePhone, String eEmail, Date eCreateTime, int eState) {
        this.eId = eId;
        this.uId = uId;
        this.eName = eName;
        this.dId = dId;
        this.duty = duty;
        this.eSex = eSex;
        this.eAge = eAge;
        this.eEducation = eEducation;
        this.ePhone = ePhone;
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

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
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

    public Integer geteAge() {
        return eAge;
    }

    public void seteAge(Integer eAge) {
        this.eAge = eAge;
    }

    public String geteEducation() {
        return eEducation;
    }

    public void seteEducation(String eEducation) {
        this.eEducation = eEducation;
    }

    public String getePhone() {
        return ePhone;
    }

    public void setePhone(String ePhone) {
        this.ePhone = ePhone;
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
                ", dId=" + dId +
                ", duty='" + duty + '\'' +
                ", eSex='" + eSex + '\'' +
                ", eAge=" + eAge +
                ", eEducation='" + eEducation + '\'' +
                ", ePhone='" + ePhone + '\'' +
                ", eEmail='" + eEmail + '\'' +
                ", eCreateTime=" + eCreateTime +
                ", eState=" + eState +
                '}';
    }
}
