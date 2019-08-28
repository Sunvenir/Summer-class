package com.example.demo.domain;

public class User {
    private static int id = 0;//唯一标识
    private String username;
    private String password;
    private String avatar;
    private int identity;
    private int age;

    public User() {//无参默认构造器
    }
    public User(String username, String password) {
        this.id = ++id;
        this.username = username;
        this.avatar = "default avatar";
        this.identity = 1;
        this.password = password;
        //this.identity = identity;
    }
    public int  getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
                "id=" +  id+
                ", name='" + username + '\'' +
                ", age=" + identity +", password="+
                '}';
    }
}
