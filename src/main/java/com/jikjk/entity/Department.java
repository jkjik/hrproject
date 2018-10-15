package com.jikjk.entity;

import java.sql.Timestamp;

/**
 * Created by lenovo on 2018/10/12.
 */
public class Department {
    private int dId;
    private String dName;
    private Timestamp dCreateTime;
    public Department() {
    }

    public Department(int dId, String dName, Timestamp dCreateTime) {
        this.dId = dId;
        this.dName = dName;
        this.dCreateTime = dCreateTime;
    }

    public int getdId() {
        return dId;
    }

    public void setdId(int dId) {
        this.dId = dId;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public Timestamp getdCreateTime() {
        return dCreateTime;
    }

    public void setdCreateTime(Timestamp dCreateTime) {
        this.dCreateTime = dCreateTime;
    }

    @Override
    public String toString() {
        return "Department{" +
                "dId=" + dId +
                ", dName='" + dName + '\'' +
                ", dCreateTime=" + dCreateTime +
                '}';
    }
}
