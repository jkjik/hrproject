package com.jikjk.entity;

import java.sql.Timestamp;

/**
 * Created by lenovo on 2018/10/16.
 */
public class OnWork {
    private Integer onId;
    private Integer eId;
    private Timestamp startTime;
    private Timestamp endTime;
    private String onWorkState;
    private String offWorkState;

    public OnWork() {
    }

    public OnWork(Integer onId, Integer eId, Timestamp startTime, Timestamp endTime, String onWorkState, String offWorkState) {
        this.onId = onId;
        this.eId = eId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.onWorkState = onWorkState;
        this.offWorkState = offWorkState;
    }

    public Integer getOnId() {
        return onId;
    }

    public void setOnId(Integer onId) {
        this.onId = onId;
    }

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public String getOnWorkState() {
        return onWorkState;
    }

    public void setOnWorkState(String onWorkState) {
        this.onWorkState = onWorkState;
    }

    public String getOffWorkState() {
        return offWorkState;
    }

    public void setOffWorkState(String offWorkState) {
        this.offWorkState = offWorkState;
    }

    @Override
    public String toString() {
        return "OnWork{" +
                "onId=" + onId +
                ", eId=" + eId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", onWorkState='" + onWorkState + '\'' +
                ", offWorkState='" + offWorkState + '\'' +
                '}';
    }
}
