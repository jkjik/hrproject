package com.jikjk.entity;

/**
 * Created by lenovo on 2018/10/12.
 */
public class Position {
    private int pId;
    private String pName;
    private int dId;
    public Position() {
    }

    public Position(int pId, String pName, int dId) {
        this.pId = pId;
        this.pName = pName;
        this.dId = dId;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getdId() {
        return dId;
    }

    public void setdId(int dId) {
        this.dId = dId;
    }

    @Override
    public String toString() {
        return "Position{" +
                "pId=" + pId +
                ", pName='" + pName + '\'' +
                ", dId=" + dId +
                '}';
    }
}
