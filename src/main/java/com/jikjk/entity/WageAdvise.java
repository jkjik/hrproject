package com.jikjk.entity;

import java.sql.Date;

/**
 * Created by lenovo on 2018/10/16.
 */
public class WageAdvise {
    private Integer waId;//¸´Òé
    private Integer eId;
    private Integer ad_money;//¸´Òé½ð¶î
    private String waResult;
    private Date waCreateTime;

    public WageAdvise() {
    }

    public WageAdvise(Integer waId, Integer eId, Integer ad_money, String waResult, Date waCreateTime) {
        this.waId = waId;
        this.eId = eId;
        this.ad_money = ad_money;
        this.waResult = waResult;
        this.waCreateTime = waCreateTime;
    }

    public Integer getWaId() {
        return waId;
    }

    public void setWaId(Integer waId) {
        this.waId = waId;
    }

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public Integer getAd_money() {
        return ad_money;
    }

    public void setAd_money(Integer ad_money) {
        this.ad_money = ad_money;
    }

    public String getWaResult() {
        return waResult;
    }

    public void setWaResult(String waResult) {
        this.waResult = waResult;
    }

    public Date getWaCreateTime() {
        return waCreateTime;
    }

    public void setWaCreateTime(Date waCreateTime) {
        this.waCreateTime = waCreateTime;
    }

    @Override
    public String toString() {
        return "WageAdvise{" +
                "waId=" + waId +
                ", eId=" + eId +
                ", ad_money=" + ad_money +
                ", waResult='" + waResult + '\'' +
                ", waCreateTime=" + waCreateTime +
                '}';
    }
}
