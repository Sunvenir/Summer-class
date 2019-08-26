package com.example.demo.domain;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Post {
    @Id
    private User postUser;
    private Date time;
    private String content;
    private Reply[] replies;
    private int like;

    public Post() {};
    public Post(User postUser, Date time, String content, Reply[] replies, int like) {
        this.postUser = postUser;
        this.time = time;
        this.content = content;
        this.replies = replies;
        this.like = like;
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

    public int getLike() {
        return like;
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

    public void setLike(int like) {
        this.like = like;
    }

    public void iLikeIt() {
        /*
        这是点赞
         */
        like ++;
    }

    @Override
    public String toString() {
        return postUser.getName() + " / " +
                time.toString() + " / " +
                content;
    }
}
