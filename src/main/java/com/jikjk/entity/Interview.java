package com.jikjk.entity;

import java.sql.Timestamp;

/**
 * Created by lenovo on 2018/10/13.
 */
public class Interview {
    //通知面试
    private int iId;
    private int rId;
    private int uId;
    private Timestamp intvTime;//面试时间
    private String intvSite;//面试地点
    private String intvPeople;//面试人名
    private int intvPhone;//联系方式

    public Interview() {
    }
    public Interview(int iId, int rId, int uId, Timestamp intvTime, String intvSite, String intvPeople, int intvPhone) {
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

    public Timestamp getIntvTime() {
        return intvTime;
    }

    public void setIntvTime(Timestamp intvTime) {
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

    public int getIntvPhone() {
        return intvPhone;
    }

    public void setIntvPhone(int intvPhone) {
        this.intvPhone = intvPhone;
    }
    @Override
    public String toString() {
        return "Interview{" +
                "iId=" + iId +
                ", rId=" + rId +
                ", uId=" + uId +
                ", intvTime=" + intvTime +
                ", intvSite='" + intvSite + '\'' +
                ", intvPeople='" + intvPeople + '\'' +
                ", intvPhone=" + intvPhone +
                '}';
    }
}
