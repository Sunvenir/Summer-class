package com.example.demo.result;

import com.example.demo.domain.Post;
import com.example.demo.domain.User;

import java.util.List;

public class Result {
    //响应码
    private int code;

    private List<Post> list;
    private int pagenum;
    private String message;

    public Result(){

    }

    public Result(int code,String message){
        this.code = code;
        this.message = message;
    }

    public Result(int code,List<Post> list,int pagenum){
        this.code = code;
        this.list = list;
        this.pagenum = pagenum;
    }

    public Result(int code) {
        this.code = code;
    }

    public int getPagenum() {
        return pagenum;
    }

    public List<Post> getList() {
        return list;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setList(List<Post> list) {
        this.list = list;
    }

    public void setPagenum(int pagenum) {
        this.pagenum = pagenum;
    }
}

