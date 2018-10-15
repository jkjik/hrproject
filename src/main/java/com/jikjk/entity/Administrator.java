package com.jikjk.entity;

/**
 * Created by lenovo on 2018/10/14.
 */
public class Administrator {
    private int aId;
    private String aName;
    private int uId;

    public Administrator() {
    }

    public Administrator(int aId, String aName, int uId) {
        this.aId = aId;
        this.aName = aName;
        this.uId = uId;
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "aId=" + aId +
                ", aName='" + aName + '\'' +
                ", uId=" + uId +
                '}';
    }
}
