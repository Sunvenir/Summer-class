package com.example.demo.Repository;

import com.example.demo.domain.Reply;

import java.util.List;

public interface ReplyDao {
    List<Reply> getreply(String username, String blogname);
}
