package com.jikjk.entity;

import java.sql.Date;

/**
 * Created by lenovo on 2018/10/16.
 */
public class Wage {
    private Integer wId;//工资id
    private Integer eId;
    private Integer basic;//基本工资
    private Integer bonus;//效绩工资
    private Integer overTime;//加班
    private Integer punish;//奖惩
    private Integer social;//社保
    private Date wCreateTime;
    private Integer advice;//复议
    private Integer total;//总计

    public Wage() {
    }

    public Wage(Integer wId, Integer eId, Integer basic, Integer bonus, Integer overTime, Integer punish, Integer social, Date wCreateTime, Integer advice, Integer total) {
        this.wId = wId;
        this.eId = eId;
        this.basic = basic;
        this.bonus = bonus;
        this.overTime = overTime;
        this.punish = punish;
        this.social = social;
        this.wCreateTime = wCreateTime;
        this.advice = advice;
        this.total = total;
    }

    public Integer getwId() {
        return wId;
    }

    public void setwId(Integer wId) {
        this.wId = wId;
    }

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public Integer getBasic() {
        return basic;
    }

    public void setBasic(Integer basic) {
        this.basic = basic;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    public Integer getOverTime() {
        return overTime;
    }

    public void setOverTime(Integer overTime) {
        this.overTime = overTime;
    }

    public Integer getPunish() {
        return punish;
    }

    public void setPunish(Integer punish) {
        this.punish = punish;
    }

    public Integer getSocial() {
        return social;
    }

    public void setSocial(Integer social) {
        this.social = social;
    }

    public Date getwCreateTime() {
        return wCreateTime;
    }

    public void setwCreateTime(Date wCreateTime) {
        this.wCreateTime = wCreateTime;
    }

    public Integer getAdvice() {
        return advice;
    }

    public void setAdvice(Integer advice) {
        this.advice = advice;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Wage{" +
                "wId=" + wId +
                ", eId=" + eId +
                ", basic=" + basic +
                ", bonus=" + bonus +
                ", overTime=" + overTime +
                ", punish=" + punish +
                ", social=" + social +
                ", wCreateTime=" + wCreateTime +
                ", advice=" + advice +
                ", total=" + total +
                '}';
    }
}
