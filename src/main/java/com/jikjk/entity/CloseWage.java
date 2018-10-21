package com.jikjk.entity;

import java.sql.Date;

/**
 * Created by lenovo on 2018/10/20.
 */
public class CloseWage {
    private Integer cwId;
    private Integer eId;//Ա��id
    private Integer monthDay;//�·�����
    private Integer omWorkDay;//��������
    private Integer basicMoney;//��������
    private Integer socialMoney;//�籣
    private Integer overTimeMoney;//�Ӱ๤��
    private Integer punishMoney;//���͹���
    private Integer bonusMoney;//Ч������
    private Integer total;//�ϼ�
    private Date cwCreateTime;//����ʱ��
    public CloseWage() {
    }

    public CloseWage(Integer cwId, Integer eId, Integer monthDay, Integer omWorkDay, Integer basicMoney, Integer socialMoney, Integer overTimeMoney, Integer punishMoney, Integer bonusMoney, Integer total, Date cwCreateTime) {
        this.cwId = cwId;
        this.eId = eId;
        this.monthDay = monthDay;
        this.omWorkDay = omWorkDay;
        this.basicMoney = basicMoney;
        this.socialMoney = socialMoney;
        this.overTimeMoney = overTimeMoney;
        this.punishMoney = punishMoney;
        this.bonusMoney = bonusMoney;
        this.total = total;
        this.cwCreateTime = cwCreateTime;
    }

    public Integer getCwId() {
        return cwId;
    }

    public void setCwId(Integer cwId) {
        this.cwId = cwId;
    }

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public Integer getMonthDay() {
        return monthDay;
    }

    public void setMonthDay(Integer monthDay) {
        this.monthDay = monthDay;
    }

    public Integer getOmWorkDay() {
        return omWorkDay;
    }

    public void setOmWorkDay(Integer omWorkDay) {
        this.omWorkDay = omWorkDay;
    }

    public Integer getBasicMoney() {
        return basicMoney;
    }

    public void setBasicMoney(Integer basicMoney) {
        this.basicMoney = basicMoney;
    }

    public Integer getSocialMoney() {
        return socialMoney;
    }

    public void setSocialMoney(Integer socialMoney) {
        this.socialMoney = socialMoney;
    }

    public Integer getOverTimeMoney() {
        return overTimeMoney;
    }

    public void setOverTimeMoney(Integer overTimeMoney) {
        this.overTimeMoney = overTimeMoney;
    }

    public Integer getPunishMoney() {
        return punishMoney;
    }

    public void setPunishMoney(Integer punishMoney) {
        this.punishMoney = punishMoney;
    }

    public Integer getBonusMoney() {
        return bonusMoney;
    }

    public void setBonusMoney(Integer bonusMoney) {
        this.bonusMoney = bonusMoney;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Date getCwCreateTime() {
        return cwCreateTime;
    }

    public void setCwCreateTime(Date cwCreateTime) {
        this.cwCreateTime = cwCreateTime;
    }

    @Override
    public String toString() {
        return "CloseWage{" +
                "cwId=" + cwId +
                ", eId=" + eId +
                ", monthDay=" + monthDay +
                ", omWorkDay=" + omWorkDay +
                ", basicMoney=" + basicMoney +
                ", socialMoney=" + socialMoney +
                ", overTimeMoney=" + overTimeMoney +
                ", punishMoney=" + punishMoney +
                ", bonusMoney=" + bonusMoney +
                ", total=" + total +
                ", cwCreateTime=" + cwCreateTime +
                '}';
    }
}
