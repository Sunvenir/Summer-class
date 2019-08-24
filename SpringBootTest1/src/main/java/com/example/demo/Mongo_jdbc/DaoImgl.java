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
import org.bson.conversions.Bson;

public class DaoImgl implements Dao {
    //单例模式
    private DaoImgl(){};
    private static DaoImgl dao = new DaoImgl();
    public static DaoImgl getInstance(){
        if(dao == null){
            dao = new DaoImgl();
        }
        return dao;
    }
    private void getConnection(){
        try{
            MongoClient mongoClient = new MongoClient("114.115.237.78",27017);
            MongoDatabase db = mongoClient.getDatabase("Summer-class");
            System.out.println("connected successfully");
        }catch (Exception e){
            System.out.println("数据库连接错误"+e.getStackTrace());
        }
    }
    //用户注册
    public void register(User user){
        try{
            MongoClient mongoClient = new MongoClient("114.115.237.78",27017);
            MongoDatabase db = mongoClient.getDatabase("Summer-class");
            System.out.println("connected successfully");
            MongoCollection<Document> collection = db.getCollection("User");
            Document document = new Document("name",user.getUsername()).
                    append("password",user.getPassword()).
                    append("user_id",user.getId());
            List<Document> documents = new ArrayList<Document>();
            documents.add(document);
            collection.insertMany(documents);
            System.out.println("register successfully");
        }catch (Exception e){
            System.out.println("register failed" + e.getMessage());
        }
    }
    //用户登录
    public User login(String name,String password){
        try {
            MongoClient mongoClient = new MongoClient("114.115.237.78",27017);
            MongoDatabase db = mongoClient.getDatabase("Summer-class");
            System.out.println("connected successfully");
            MongoCollection<Document> collection = db.getCollection("User");
            Bson fliter = Filters.and(Filters.eq("name",name),Filters.eq("password",password));
            Document document = collection.find(fliter).first();
            User user = new User((Integer) document.get("user_id"),(String) document.get("name"),(String) document.get("password"));
            return user;
        }catch (Exception e){
            System.out.println("登录失败" + e.getMessage());
            return null;
        }
    }

}

