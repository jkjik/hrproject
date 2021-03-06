package com.jikjk.entity;

import java.sql.Date;

/**
 * Created by lenovo on 2018/10/13.
 */
public class SendResume {
    //游客发送简历状态
    private Integer sId;
    private Integer rId;
    private Integer uId;
    private Date sCreateTime;
    private String sStateRead;//是否阅读
    private String intvInform;//面试通知

    public SendResume() {
    }

    public SendResume(Integer sId, Integer rId, Integer uId, Date sCreatetime, String sStateRead, String intvInform) {
        this.sId = sId;
        this.rId = rId;
        this.uId = uId;
        this.sCreateTime = sCreatetime;
        this.sStateRead = sStateRead;
        this.intvInform = intvInform;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
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

    public Date getsCreateTime() {
        return sCreateTime;
    }

    public void setsCreateTime(Date sCreateTime) {
        this.sCreateTime = sCreateTime;
    }

    @Override
    public String toString() {
        return "SendResume{" +
                "sId=" + sId +
                ", rId=" + rId +
                ", uId=" + uId +
                ", sCreatetime=" + sCreateTime +
                ", sStateRead='" + sStateRead + '\'' +
                ", intvInform='" + intvInform + '\'' +
                '}';
    }
}
