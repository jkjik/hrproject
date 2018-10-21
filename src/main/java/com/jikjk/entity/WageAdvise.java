package com.jikjk.entity;

import java.sql.Date;

/**
 * Created by lenovo on 2018/10/16.
 */
public class WageAdvise {
    private Integer waId;//¸´Òé
    private Integer eId;
    private Integer adMoney;//¸´Òé½ð¶î
    private String waResult;
    private Date waCreateTime;
    private String waCause;

    public WageAdvise() {
    }

    public WageAdvise(Integer waId, Integer eId, Integer adMoney, String waResult, Date waCreateTime, String waCause) {
        this.waId = waId;
        this.eId = eId;
        this.adMoney = adMoney;
        this.waResult = waResult;
        this.waCreateTime = waCreateTime;
        this.waCause = waCause;
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

    public Integer getAdMoney() {
        return adMoney;
    }

    public void setAdMoney(Integer adMoney) {
        this.adMoney = adMoney;
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

    public String getWaCause() {
        return waCause;
    }

    public void setWaCause(String waCause) {
        this.waCause = waCause;
    }

    @Override
    public String toString() {
        return "WageAdvise{" +
                "waId=" + waId +
                ", eId=" + eId +
                ", adMoney=" + adMoney +
                ", waResult='" + waResult + '\'' +
                ", waCreateTime=" + waCreateTime +
                ", waCause='" + waCause + '\'' +
                '}';
    }
}
