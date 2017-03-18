package com.example.a88481.studentmanage.Model;

/**
 * Created by 88481 on 2017/3/18 0018.
 */

public class Student {
    private String name;
    private String major;
    private String phoneNumber;
    private String qq;

    public Student(){
    }

    public Student(String name,String major,String phoneNumber,String qq){
        this.name = name;
        this.major = major;
        this.phoneNumber = phoneNumber;
        this.qq = qq;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }
}
