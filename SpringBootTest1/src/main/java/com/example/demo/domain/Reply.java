package com.example.demo.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "Reply")
public class Reply extends Post {
    public  Reply(User user, String date, String details){
        this.post_owner = user;
        this.date = date;
        this.detail = details;
        this.reply = null;
        this.title = null;
        likes = 0;
    }


}
