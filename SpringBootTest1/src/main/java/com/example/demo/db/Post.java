package com.example.demo.db;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Post {
    @Id
    private User postUser;
    private Date time;
    private String content;
    private Reply[] replies;

    public Post(User postUser, Date time, String content, Reply[] replies) {
        this.postUser = postUser;
        this.time = time;
        this.content = content;
        this.replies = replies;
    }

    public Date getTime() {
        return time;
    }

    public String getContent() {
        return content;
    }

    public User getPostUser() {
        return postUser;
    }

    public Reply[] getReplies() {
        return replies;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPostUser(User postUser) {
        this.postUser = postUser;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setReplies(Reply[] replies) {
        this.replies = replies;
    }

    @Override
    public String toString() {
        return postUser.getUsername() + " / " +
                time.toString() + " / " +
                content;
    }
}
