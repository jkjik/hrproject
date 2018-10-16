package com.jikjk.entity;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by lenovo on 2018/10/13.
 */
public class InterviewResult {
    //面试结果类
    private int irId;
    private String aName;//面试官名
    private String uName;
    private String iResult;//是否录取
    private int rId;
    private Date irCreateTime;
    public InterviewResult() {
    }

    public InterviewResult(int irId, String aName, String uName, String iResult, int rId, Date irCreateTime) {
        this.irId = irId;
        this.aName = aName;
        this.uName = uName;
        this.iResult = iResult;
        this.rId = rId;
        this.irCreateTime = irCreateTime;
    }

    public int getIrId() {
        return irId;
    }

    public void setIrId(int irId) {
        this.irId = irId;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getiResult() {
        return iResult;
    }

    public void setiResult(String iResult) {
        this.iResult = iResult;
    }

    public Date getIrCreatetimr() {
        return irCreateTime;
    }

    public void setIrCreatetimr(Date irCreatetimr) {
        this.irCreateTime = irCreatetimr;
    }

    public int getrId() {
        return rId;
    }

    public void setrId(int rId) {
        this.rId = rId;
    }

    @Override
    public String toString() {
        return "InterviewResult{" +
                "irId=" + irId +
                ", aName='" + aName + '\'' +
                ", uName='" + uName + '\'' +
                ", iResult='" + iResult + '\'' +
                ", rId=" + rId +
                ", irCreateTime=" + irCreateTime +
                '}';
    }
}
