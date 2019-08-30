package com.example.demo.Repository;

import com.example.demo.domain.User;
import com.example.demo.result.Result;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserDaoImgl implements UserDao{
    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public void saveUser(User user) {
        mongoTemplate.save(user);
    }

    @Override
    public void romoveUser(String username) {
        User user = findbyname(username);
        mongoTemplate.remove(user);
    }

    @Override
    public User findbyname(String name) {
        Query query = new Query(Criteria.where("username").is(name));
        User user = mongoTemplate.findOne(query,User.class);
        return user;
    }

    @Override
    public User checklogin(String username,String password){
        Query query = new Query(Criteria.where("username").is(username));
        query.addCriteria(Criteria.where("password").is(password));
        User user = mongoTemplate.findOne(query,User.class);
        return user;
    }

    @Override
    public void update(User user){
        Query query = new Query(Criteria.where("username").is(user.getName()));
        Update update = new Update();
        update.set("realname",user.getRealname());
        update.set("email",user.getEmail());
        update.set("gender",user.getGender());
        update.set("birthday",user.getBirthday());
        update.set("location",user.getLocation());
        mongoTemplate.updateFirst(query,update,User.class);
    }

    @Override
    public void change_password(String username, String password){
        Query query = new Query(Criteria.where("username").is(username));
        Update update = new Update();
        update.set("password",password);
        mongoTemplate.updateFirst(query,update,User.class);
    }
}
