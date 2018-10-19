package com.jikjk.entity;


import java.sql.Date;
import java.text.SimpleDateFormat;


/**
 * Created by lenovo on 2018/10/16.
 */
public class CreateCultivate {
    private Integer cId;
    private String cName;
    private String cDuty;
    private Date cCreateTime;

    public CreateCultivate() {
    }

    public CreateCultivate(Integer cId, String cName, String cDuty, Date cCreateTime) {
        this.cId = cId;
        this.cName = cName;
        this.cDuty = cDuty;
        this.cCreateTime = cCreateTime;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcDuty() {
        return cDuty;
    }

    public void setcDuty(String cDuty) {
        this.cDuty = cDuty;
    }

    public Date getcCreateTime() {
        return cCreateTime;
    }

    public void setcCreateTime(Date cCreateTime) {
        this.cCreateTime = cCreateTime;
    }

    @Override
    public String toString() {
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
        String time=sf.format(cCreateTime);
        return "CreateCultivate{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                ", cDuty='" + cDuty + '\'' +
                ", cCreateTime=" + time +
                '}';
    }
}
