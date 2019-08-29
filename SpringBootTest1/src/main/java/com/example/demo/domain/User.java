package com.example.demo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "User")
public class User {


    private String username;
    private String password;
    private String avatar;
    private int identity;
    private int age;
    private int gender;
    private Date birthday;
    private String location;
    private String realname;


    public User() {//无参默认构造器
    }
    public User(String username, String password) {
        this.username = username;
        this.avatar = "default avatar";
        this.identity = 1;
        this.password = password;
        //this.identity = identity;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getAge() {
        return age;
    }

    public int getGender() {
        return gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getLocation() {
        return location;
    }

    public String getRealname() {
        return realname;
    }

    public String getName() {
        return username;
    }
    public void setName(String name) {
        this.username = name;
    }
    public int getIdentity() {
        return identity;
    }
    public void setIdentity(int identity) {
        this.identity = identity;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    @Override
    public String toString() {
        return "User{" +
                ", name='" + username + '\'' +
                ", age=" + identity +", password="+
                '}';
    }
}
