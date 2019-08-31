package com.example.demo.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
@Document(value = "Blog")
public class Post {
    protected User post_owner;
    protected String title;
    protected String date;
    protected int likes;
    protected String detail;
    protected String type;
    protected ArrayList<Reply> reply;
    protected ArrayList<UploadFile> files;
    protected ArrayList<String> urls;
    public Post(){}
    Post(User user,String title,String date,String details){
        this.post_owner = user;
        this.date = date;
        this.detail = details;
        this.likes = 0;
        this.reply = new ArrayList<Reply>();
        this.title = title;

    }

    public ArrayList<String> getUrls() {
        return urls;
    }

    public void setUrls(ArrayList<String> urls) {
        this.urls = urls;
    }

    public ArrayList<UploadFile> getFiles() {
        return files;
    }

    public void setFiles(ArrayList<UploadFile> files) {
        this.files = files;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setPost_owner(User post_owner) {
        this.post_owner = post_owner;
    }

    public void setReply(ArrayList<Reply> reply) {
        this.reply = reply;
    }

    public int getLikes() {
        return likes;
    }

    public String getDate() {
        return date;
    }

    public String getDetail() {
        return detail;
    }

    public User getPost_owner() {
        return post_owner;
    }

    public ArrayList<Reply> getReply() {
        return reply;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }
}
