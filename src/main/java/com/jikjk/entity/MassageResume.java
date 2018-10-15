package com.jikjk.entity;

import java.sql.Date;

/**
 * Created by lenovo on 2018/10/13.
 */
public class MassageResume {
    //管理查看简历的状态
    private int mId;
    private int rId;//简历id
    private Date mCreateTime;//创建时间
    private String stateRead;//是否阅读
    private String stateInterview;//是否面试

    public MassageResume() {
    }

    public MassageResume(int mId, int rId, Date mCreateTime, String stateRead, String stateInterview) {
        this.mId = mId;
        this.rId = rId;
        this.mCreateTime = mCreateTime;
        this.stateRead = stateRead;
        this.stateInterview = stateInterview;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public int getrId() {
        return rId;
    }

    public void setrId(int rId) {
        this.rId = rId;
    }

    public Date getmCreateTime() {
        return mCreateTime;
    }

    public void setmCreateTime(Date mCreateTime) {
        this.mCreateTime = mCreateTime;
    }

    public String getStateRead() {
        return stateRead;
    }

    public void setStateRead(String stateRead) {
        this.stateRead = stateRead;
    }

    public String getStateInterview() {
        return stateInterview;
    }

    public void setStateInterview(String stateInterview) {
        this.stateInterview = stateInterview;
    }

    @Override
    public String toString() {
        return "MassageResume{" +
                "mId=" + mId +
                ", rId=" + rId +
                ", mCreateTime=" + mCreateTime +
                ", stateRead=" + stateRead +
                ", stateInterview=" + stateInterview +
                '}';
    }
}
