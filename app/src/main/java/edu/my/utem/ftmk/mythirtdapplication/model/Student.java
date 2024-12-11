package edu.my.utem.ftmk.mythirtdapplication.model;
public class Student {
    private String strFullname, strStudNo, strEmail, strGender, strBirthdate, strState;

    public Student(String strFullname, String strStudNo, String strEmail, String strGender, String strBirthdate, String strState){
        this.strFullname = strFullname;
        this.strStudNo = strStudNo;
        this.strEmail = strEmail;
        this.strGender = strGender;
        this.strBirthdate = strBirthdate;
        this.strState = strState;
    }

    public String getFullname() {
        return strFullname;
    }

    public String getStudNo() {
        return strStudNo;
    }

    public String getEmail() {
        return strEmail;
    }

    public String getGender() {
        return strGender;
    }

    public String getBirthdate() {
        return strBirthdate;
    }

    public String getState() {
        return strState;
    }

    public void setFullname(String strFullname) {
        this.strFullname = strFullname;
    }

    public void setStudNo(String strStudNo) {
        this.strStudNo = strStudNo;
    }

    public void setEmail(String strEmail) {
        this.strEmail = strEmail;
    }

    public void setGender(String strGender) {
        this.strGender = strGender;
    }

    public void setBirthdate(String strBirthdate) {
        this.strBirthdate = strBirthdate;
    }

    public void setState(String strState) {
        this.strState = strState;
    }
}
