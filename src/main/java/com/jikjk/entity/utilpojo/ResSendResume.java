package com.jikjk.entity.utilpojo;

import com.jikjk.entity.Resume;

import java.sql.Date;

/**
 * Created by lenovo on 2018/10/15.
 */
public class ResSendResume {
    private Integer sId;
    private Resume resume;
    private Integer uId;
    private Date sCreateTime;
    private String sStateRead;//是否阅读
    private String intvInform;//面试通知

    public ResSendResume() {
    }

    public ResSendResume(Integer sId, Resume resume, Integer uId, Date sCreateTime, String sStateRead, String intvInform) {
        this.sId = sId;
        this.resume = resume;
        this.uId = uId;
        this.sCreateTime = sCreateTime;
        this.sStateRead = sStateRead;
        this.intvInform = intvInform;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Date getsCreateTime() {
        return sCreateTime;
    }

    public void setsCreateTime(Date sCreateTime) {
        this.sCreateTime = sCreateTime;
    }

    public String getsStateRead() {
        return sStateRead;
    }

    public void setsStateRead(String sStateRead) {
        this.sStateRead = sStateRead;
    }

    public String getIntvInform() {
        return intvInform;
    }

    public void setIntvInform(String intvInform) {
        this.intvInform = intvInform;
    }

    @Override
    public String toString() {
        return "ResSendResume{" +
                "sId=" + sId +
                ", resume=" + resume +
                ", uId=" + uId +
                ", sCreateTime=" + sCreateTime +
                ", sStateRead='" + sStateRead + '\'' +
                ", intvInform='" + intvInform + '\'' +
                '}';
    }
}
