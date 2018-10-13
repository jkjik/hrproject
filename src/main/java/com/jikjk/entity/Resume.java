package com.jikjk.entity;

/**
 * Created by lenovo on 2018/10/12.
 */
public class Resume {
    private int rId;
    private int uId;
    private String rName;
    private int rAge;
    private String rSex;
    private String education;
    private String school;
    private String aimDuty;
    private String email;
    private String phone;
    private String lastWork;
    private String project;
    private String yourself;
    private int aimPay;

    public Resume() {
    }

    public Resume(int rId, int uId, String rName, int rAge, String rSex, String education, String school, String aimDuty, String email, String phone, String lastWork, String project, String yourself, int aimPay) {
        this.rId = rId;
        this.uId = uId;
        this.rName = rName;
        this.rAge = rAge;
        this.rSex = rSex;
        this.education = education;
        this.school = school;
        this.aimDuty = aimDuty;
        this.email = email;
        this.phone = phone;
        this.lastWork = lastWork;
        this.project = project;
        this.yourself = yourself;
        this.aimPay = aimPay;
    }

    public int getrId() {
        return rId;
    }

    public void setrId(int rId) {
        this.rId = rId;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public int getrAge() {
        return rAge;
    }

    public void setrAge(int rAge) {
        this.rAge = rAge;
    }

    public String getrSex() {
        return rSex;
    }

    public void setrSex(String rSex) {
        this.rSex = rSex;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getAimDuty() {
        return aimDuty;
    }

    public void setAimDuty(String aimDuty) {
        this.aimDuty = aimDuty;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLastWork() {
        return lastWork;
    }

    public void setLastWork(String lastWork) {
        this.lastWork = lastWork;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getYourself() {
        return yourself;
    }

    public void setYourself(String yourself) {
        this.yourself = yourself;
    }

    public int getAimPay() {
        return aimPay;
    }

    public void setAimPay(int aimPay) {
        this.aimPay = aimPay;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "rId=" + rId +
                ", uId=" + uId +
                ", rName='" + rName + '\'' +
                ", rAge=" + rAge +
                ", rSex='" + rSex + '\'' +
                ", education='" + education + '\'' +
                ", school='" + school + '\'' +
                ", aimDuty='" + aimDuty + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", lastWork='" + lastWork + '\'' +
                ", project='" + project + '\'' +
                ", yourself='" + yourself + '\'' +
                ", aimPay=" + aimPay +
                '}';
    }
}
