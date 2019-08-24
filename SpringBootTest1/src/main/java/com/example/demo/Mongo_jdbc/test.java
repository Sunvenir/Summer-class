package com.example.demo.Mongo_jdbc;

import com.example.demo.db.User;

public class test {
    public static void main(String[] args) {
        Dao dao = DaoImgl.getInstance();
        User user = dao.login("sun","1234");
        System.out.println(user.toString());
    }

}
