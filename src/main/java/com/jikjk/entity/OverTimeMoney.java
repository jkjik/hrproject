package com.jikjk.entity;

import java.sql.Date;

/**
 * Created by lenovo on 2018/10/16.
 */
public class OverTimeMoney {
    private Integer omId;
    private Integer eId;
    private Integer oMoney;
    private Date omCreateTime;

    public OverTimeMoney() {
    }

    public OverTimeMoney(Integer omId, Integer eId, Integer oMoney, Date omCreateTime) {
        this.omId = omId;
        this.eId = eId;
        this.oMoney = oMoney;
        this.omCreateTime = omCreateTime;
    }

    public Integer getOmId() {
        return omId;
    }

    public void setOmId(Integer omId) {
        this.omId = omId;
    }

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public Integer getoMoney() {
        return oMoney;
    }

    public void setoMoney(Integer oMoney) {
        this.oMoney = oMoney;
    }

    public Date getOmCreateTime() {
        return omCreateTime;
    }

    public void setOmCreateTime(Date omCreateTime) {
        this.omCreateTime = omCreateTime;
    }

    @Override
    public String toString() {
        return "OverTimeMoney{" +
                "omId=" + omId +
                ", eId=" + eId +
                ", oMoney=" + oMoney +
                ", omCreateTime=" + omCreateTime +
                '}';
    }
}
