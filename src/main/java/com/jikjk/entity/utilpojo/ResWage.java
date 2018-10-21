package com.jikjk.entity.utilpojo;

/**
 * Created by lenovo on 2018/10/20.
 */
public class ResWage {
    private Integer eId;
    private String eName;
    private Integer basicMoney;
    private Integer socialMoney;

    public ResWage() {
    }

    public ResWage(Integer eId, String eName, Integer basicMoney, Integer socialMoney) {
        this.eId = eId;
        this.eName = eName;
        this.basicMoney = basicMoney;
        this.socialMoney = socialMoney;
    }

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
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

    @Override
    public String toString() {
        return "ResWage{" +
                "eId=" + eId +
                ", eName='" + eName + '\'' +
                ", basicMoney=" + basicMoney +
                ", socialMoney=" + socialMoney +
                '}';
    }
}
