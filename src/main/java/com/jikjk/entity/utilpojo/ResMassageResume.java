package com.jikjk.entity.utilpojo;

import com.jikjk.entity.Resume;

import java.sql.Date;

/**
 * Created by lenovo on 2018/10/14.
 */
public class ResMassageResume {
    private int mId;
    private Resume resume;//简历id
    private Date mCreateTime;//创建时间
    private String stateRead;//是否阅读
    private String stateInterview;//是否面试

    public ResMassageResume() {
    }

    public ResMassageResume(int mId, Resume resume, Date mCreateTime, String stateRead, String stateInterview) {
        this.mId = mId;
        this.resume = resume;
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

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
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
        return "ResMassageResume{" +
                "mId=" + mId +
                ", resume=" + resume +
                ", mCreateTime=" + mCreateTime +
                ", stateRead='" + stateRead + '\'' +
                ", stateInterview='" + stateInterview + '\'' +
                '}';
    }
}
