package com.jikjk.entity;

import com.jikjk.util.Md5;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by lenovo on 2018/10/11.
 */
public class User {
    private int id;//Ա��(����Ա)id
    private int uId;
    private String uName;
    private String uPassword;
    private Timestamp uCreatetime;
    private int status;

    public User() {
    }

    public User(int id, int uId, String uName, String uPassword, Timestamp uCreatetime, int status) {
        this.id = id;
        this.uId = uId;
        this.uName = uName;
        this.uPassword = Md5.md5(uPassword);
        this.uCreatetime = uCreatetime;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        this.uPassword = Md5.md5(uPassword);
    }

    public Timestamp getuCreatetime() {
        return uCreatetime;
    }

    public void setuCreatetime(Timestamp uCreatetime) {
        this.uCreatetime = uCreatetime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", uId=" + uId +
                ", uName='" + uName + '\'' +
                ", uPassword='" + uPassword + '\'' +
                ", uCreatetime=" + uCreatetime +
                ", status=" + status +
                '}';
    }
}
