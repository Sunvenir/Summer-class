package com.example.demo.Repository;

import com.example.demo.domain.Post;
import com.example.demo.result.Result;

import java.util.List;

public interface BlogDao {
    boolean ifexists(String username,String title);
    void post_blog(Post post);
    List<Post> show_blogbyname(String username,int pagenum,int pagesize);
    int shownumbyname(String username);
    List<Post> show_blogbytype(String type,int pagenum,int pagesize);
    int shownumbytype(String type);
}
