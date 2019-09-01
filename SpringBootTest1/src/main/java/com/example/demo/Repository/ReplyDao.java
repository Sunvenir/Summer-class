package com.example.demo.Repository;

import com.example.demo.domain.Post;
import com.example.demo.domain.Reply;

import java.util.List;

public interface ReplyDao {
    List<Reply> getreply(String username, String blogname);
    void post_reply(Reply reply);
}
