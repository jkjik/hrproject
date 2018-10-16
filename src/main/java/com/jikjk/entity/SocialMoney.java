package com.jikjk.entity;

/**
 * Created by lenovo on 2018/10/16.
 */
public class SocialMoney {
    private Integer smId;
    private Integer eId;
    private Integer sMoney;

    public SocialMoney() {
    }

    public SocialMoney(Integer smId, Integer eId, Integer sMoney) {
        this.smId = smId;
        this.eId = eId;
        this.sMoney = sMoney;
    }

    public Integer getSmId() {
        return smId;
    }

    public void setSmId(Integer smId) {
        this.smId = smId;
    }

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public Integer getsMoney() {
        return sMoney;
    }

    public void setsMoney(Integer sMoney) {
        this.sMoney = sMoney;
    }

    @Override
    public String toString() {
        return "SocialMoney{" +
                "smId=" + smId +
                ", eId=" + eId +
                ", sMoney=" + sMoney +
                '}';
    }
}
