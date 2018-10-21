package com.jikjk.entity;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Date;

/**
 * Created by lenovo on 2018/10/21.
 */
public class LeaveEmployee {
    private Integer leId;
    private Integer eId;
    private Date leCreateTime;

    public LeaveEmployee(Integer leId, Integer eId, Date leCreateTime) {
        this.leId = leId;
        this.eId = eId;
        this.leCreateTime = leCreateTime;
    }

    public LeaveEmployee() {
    }

    public Integer getLeId() {
        return leId;
    }

    public void setLeId(Integer leId) {
        this.leId = leId;
    }

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public Date getLeCreateTime() {
        return leCreateTime;
    }

    public void setLeCreateTime(Date leCreateTime) {
        this.leCreateTime = leCreateTime;
    }

    @Override
    public String toString() {
        return "LeaveEmployee{" +
                "leId=" + leId +
                ", eId=" + eId +
                ", leCreateTime=" + leCreateTime +
                '}';
    }
}
