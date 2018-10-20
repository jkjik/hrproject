package com.jikjk.entity;

import java.sql.Date;


/**
 * Created by lenovo on 2018/10/16.
 */
public class PunishMoney {
    //½±³Í±í
    private Integer puId;
    private Integer eId;
    private String cause;
    private Integer puMoney;
    private Date puCreateTime;

    public PunishMoney() {
    }

    public PunishMoney(Integer puId, Integer eId, String cause, Integer puMoney, Date puCreateTime) {
        this.puId = puId;
        this.eId = eId;
        this.cause = cause;
        this.puMoney = puMoney;
        this.puCreateTime = puCreateTime;
    }

    public Integer getPuId() {
        return puId;
    }

    public void setPuId(Integer puId) {
        this.puId = puId;
    }

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public Integer getPuMoney() {
        return puMoney;
    }

    public void setPuMoney(Integer puMoney) {
        this.puMoney = puMoney;
    }

    public Date getPuCreateTime() {
        return puCreateTime;
    }

    public void setPuCreateTime(Date puCreateTime) {
        this.puCreateTime = puCreateTime;
    }

    @Override
    public String toString() {
        return "PunishMoney{" +
                "puId=" + puId +
                ", eId=" + eId +
                ", cause='" + cause + '\'' +
                ", puMoney=" + puMoney +
                ", puCreateTime=" + puCreateTime +
                '}';
    }
}
