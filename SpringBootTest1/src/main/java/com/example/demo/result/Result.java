package com.example.demo.result;

import com.example.demo.domain.User;

public class Result {
    //响应码
    private int code;
    private User user;

    public  Result(User user,int code){
        this.user = user;
        this.code = code;
    }

    public Result(int code) {
        this.code = code;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}

