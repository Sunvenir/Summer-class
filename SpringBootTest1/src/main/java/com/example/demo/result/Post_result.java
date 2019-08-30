package com.example.demo.result;

import com.example.demo.domain.Post;

import java.util.List;

public class Post_result  {
    private int code;
    private List<Post> list;
    private int pagenum;
    public Post_result(int code){
        this.code = code;
    }
    public Post_result(int code,List<Post> list,int pagenum){
        this.code = code;
        this.list = list;
        this.pagenum = pagenum;
    }
}
