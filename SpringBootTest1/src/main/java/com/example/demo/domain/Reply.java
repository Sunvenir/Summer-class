package com.example.demo.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "Reply")
public class Reply  {

    private String blogname;
    private String username;
    private String content;
    private String replyname;
    private String date;
    private String avatar;
    private int like;

    public Reply(){
        like = 0;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getBlogname() {
        return blogname;
    }

    public void setBlogname(String blogname) {
        this.blogname = blogname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReplyname() {
        return replyname;
    }

    public void setReplyname(String replyto) {
        this.replyname = replyto;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
