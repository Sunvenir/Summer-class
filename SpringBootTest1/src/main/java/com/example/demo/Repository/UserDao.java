package com.example.demo.Repository;

import com.example.demo.domain.User;

public interface UserDao {
    void saveUser(User user);
    void romoveUser(String username);
    User findbyname(String name);
    User checklogin(String username,String password);
    void update(User user);
    void change_password(String username,String password);
}
