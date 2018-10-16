package com.jikjk.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * Created by lenovo on 2018/10/13.
 */
public class Interview {
    //通知面试
    private int iId;
    private int rId;
    private int uId;
    private String intvTime;//面试时间
    private String intvSite;//面试地点
    private String intvPeople;//面试人名
    private BigInteger intvPhone;//联系方式

    public Interview() {
    }

    public Interview(int iId, int rId, int uId, String intvTime, String intvSite, String intvPeople, BigInteger intvPhone) {
        this.iId = iId;
        this.rId = rId;
        this.uId = uId;
        this.intvTime = intvTime;
        this.intvSite = intvSite;
        this.intvPeople = intvPeople;
        this.intvPhone = intvPhone;
    }

    public int getiId() {
        return iId;
    }

    public void setiId(int iId) {
        this.iId = iId;
    }

    public int getrId() {
        return rId;
    }

    public void setrId(int rId) {
        this.rId = rId;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getIntvTime() {
        return intvTime;
    }

    public void setIntvTime(String intvTime) {
        this.intvTime = intvTime;
    }

    public String getIntvSite() {
        return intvSite;
    }

    public void setIntvSite(String intvSite) {
        this.intvSite = intvSite;
    }

    public String getIntvPeople() {
        return intvPeople;
    }

    public void setIntvPeople(String intvPeople) {
        this.intvPeople = intvPeople;
    }

    public BigInteger getIntvPhone() {
        return intvPhone;
    }

    public void setIntvPhone(BigInteger intvPhone) {
        this.intvPhone = intvPhone;
    }

    @Override
    public String toString() {
        return "Interview{" +
                "iId=" + iId +
                ", rId=" + rId +
                ", uId=" + uId +
                ", intvTime='" + intvTime + '\'' +
                ", intvSite='" + intvSite + '\'' +
                ", intvPeople='" + intvPeople + '\'' +
                ", intvPhone=" + intvPhone +
                '}';
    }
}
