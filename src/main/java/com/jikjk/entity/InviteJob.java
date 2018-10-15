package com.jikjk.entity;

/**
 * Created by lenovo on 2018/10/14.
 */
public class InviteJob {
    //ÕÐÆ¸ÐÅÏ¢
    private int ijId;
    private String company;
    private String job;
    private int pay;
    private String welfare;//¸£Àû
    private int aId;

    public InviteJob() {
    }

    public InviteJob(int ijId, String company, String job, int pay, String welfare, int aId) {
        this.ijId = ijId;
        this.company = company;
        this.job = job;
        this.pay = pay;
        this.welfare = welfare;
        this.aId = aId;
    }

    public int getIjId() {
        return ijId;
    }

    public void setIjId(int ijId) {
        this.ijId = ijId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    public String getWelfare() {
        return welfare;
    }

    public void setWelfare(String welfare) {
        this.welfare = welfare;
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    @Override
    public String toString() {
        return "InviteJob{" +
                "ijId=" + ijId +
                ", company='" + company + '\'' +
                ", job='" + job + '\'' +
                ", pay=" + pay +
                ", welfare='" + welfare + '\'' +
                ", aId=" + aId +
                '}';
    }
}
