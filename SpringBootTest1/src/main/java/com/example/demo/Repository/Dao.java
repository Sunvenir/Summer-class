package com.example.demo.Repository;

import com.example.demo.domain.User;


public interface Dao {
    public void register(User user);
    public User login(String name,String password);
}