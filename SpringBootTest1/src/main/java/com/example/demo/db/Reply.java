package com.example.demo.db;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Reply {
    @Id
    private User replyUser;
    private Date time;
    private String replyContent;

    public Reply(User replyUser, Date time, String replyContent) {
        this.replyContent = replyContent;
        this.time = time;
        this.replyUser = replyUser;
    }

    public Date getTime() {
        return time;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public User getReplyUser() {
        return replyUser;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public void setReplyUser(User replyUser) {
        this.replyUser = replyUser;
    }

    @Override
    public String toString() {
        return replyUser.getUsername() + " / " +
                time.toString() + " / " +
                replyContent;
    }
}
