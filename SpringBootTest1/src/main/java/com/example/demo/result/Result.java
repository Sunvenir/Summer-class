package com.example.demo.result;

import com.example.demo.domain.Post;
import com.example.demo.domain.Reply;
import com.example.demo.domain.User;

import java.util.List;

public class Result {
    //响应码
    private int code;
    private boolean banned;
    private List<Post> list;
    private int pagenum;
    private String message;
    private List<Reply> replies;
    private int like;
    private List<User> userList;
    private User user;
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isBanned() {
        return banned;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }

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

