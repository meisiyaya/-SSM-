package com.edusoft.dto;

import java.sql.Date;

public class Seller {
    String id;//商家编号，数据库自动生成
    String realname;//商家实名
    String username;//商家账号，必填
    String password;//商家密码
    String address;//商家地址
    String postcode;//商家邮编
    String email;//商家邮箱
    String url;//商家网址
    String phone;//商家电话
    String logo;//商标
    Date regdate;//商家注册日期,数据库自动生成
    String state;//商家状态，'0'
    String grade;//商家等级，'0'

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "id='" + id + '\'' +
                ", realname='" + realname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", postcode='" + postcode + '\'' +
                ", email='" + email + '\'' +
                ", url='" + url + '\'' +
                ", phone='" + phone + '\'' +
                ", logo='" + logo + '\'' +
                ", regdate=" + regdate +
                ", state='" + state + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
