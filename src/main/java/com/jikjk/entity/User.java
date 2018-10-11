package com.jikjk.entity;

import java.sql.Timestamp;

/**
 * Created by lenovo on 2018/10/11.
 */
public class User {
    private int uId;
    private String uName;
    private String uPassword;
    private Timestamp uCreatetime;
    private int status;

    public User() {
    }

    public User(int uId, String uName, String uPassword, Timestamp uCreatetime, int status) {
        this.uId = uId;
        this.uName = uName;
        this.uPassword = uPassword;
        this.uCreatetime = uCreatetime;
        this.status = status;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public Timestamp getuCreatetime() {
        return uCreatetime;
    }

    public void setuCreatetime(Timestamp uCreatetime) {
        this.uCreatetime = uCreatetime;
    }

    public int getStatue() {
        return status;
    }

    public void setStatue(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "uId=" + uId +
                ", uName='" + uName + '\'' +
                ", uPassword='" + uPassword + '\'' +
                ", uCreatetime='" + uCreatetime + '\'' +
                ", status=" + status +
                '}';
    }
}
