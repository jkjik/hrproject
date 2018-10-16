package com.jikjk.entity;

/**
 * Created by lenovo on 2018/10/16.
 */
public class BasicMoney {
    private Integer bmId;//»ù±¾Ð½×Ê
    private Integer eId;
    private Integer bMoney;

    public BasicMoney() {
    }

    public Integer getBmId() {
        return bmId;
    }

    public void setBmId(Integer bmId) {
        this.bmId = bmId;
    }

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public Integer getbMoney() {
        return bMoney;
    }

    public void setbMoney(Integer bMoney) {
        this.bMoney = bMoney;
    }

    @Override
    public String toString() {
        return "BasicMoney{" +
                "bmId=" + bmId +
                ", eId=" + eId +
                ", bMoney=" + bMoney +
                '}';
    }
}
