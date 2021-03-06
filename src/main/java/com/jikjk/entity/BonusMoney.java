package com.jikjk.entity;

import java.sql.Date;

/**
 * Created by lenovo on 2018/10/16.
 */
public class BonusMoney {
    private Integer bId;
    private Integer eId;
    private Integer boMoney;
    private Date bCreateTime;

    public BonusMoney() {
    }

    public BonusMoney(Integer bId, Integer eId, Integer boMoney, Date bCreateTime) {
        this.bId = bId;
        this.eId = eId;
        this.boMoney = boMoney;
        this.bCreateTime = bCreateTime;
    }

    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
    }

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public Integer getBoMoney() {
        return boMoney;
    }

    public void setBoMoney(Integer boMoney) {
        this.boMoney = boMoney;
    }

    public Date getbCreateTime() {
        return bCreateTime;
    }

    public void setbCreateTime(Date bCreateTime) {
        this.bCreateTime = bCreateTime;
    }

    @Override
    public String toString() {
        return "BonusMoney{" +
                "bId=" + bId +
                ", eId=" + eId +
                ", boMoney=" + boMoney +
                ", bCreateTime=" + bCreateTime +
                '}';
    }
}
