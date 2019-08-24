package com.example.demo.Mongo_jdbc;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.db.User;
import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;


public interface Dao {
    public void register(User user);
    public User login(String name,String password);
}