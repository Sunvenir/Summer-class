package com.example.demo.contollor;

import com.example.demo.Repository.Dao;
import com.example.demo.Repository.DaoImgl;
import com.example.demo.Repository.UserDao;
import com.example.demo.domain.User;
import com.example.demo.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;


@RestController
public class logincon {

    @Autowired
    private UserDao userDao;

    @Resource
    private MongoTemplate mongoTemplate;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/api/login")
    //@ResponseBody
    public Result login( @RequestBody Map map){
//        User user = new User((String) map.get("username"),(String)map.get("password"));
//        System.out.println("登录 ： "+user.getName() + " 密码　："+user.getPassword());
//        Dao dao = DaoImgl.getInstance();
//        User user1 = dao.login(user.getName(),user.getPassword());
        User user1 = userDao.checklogin((String) map.get("username"),(String)map.get("password"));
        Result result = new Result();
        if(user1 != null){
            result.setUser(user1);
            result.setBanned(user1.isBanned());
            result.setCode(200);
            return result;
        }
        else {
            result.setCode(400);
            return result;
        }
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/api/register")
    //@ResponseBody
    public Result register(@RequestBody  Map map){
        User user2 = userDao.findbyname((String) map.get("username"));
        if(user2 != null){
            return new Result(300);
        }
        User user = new User((String) map.get("username"),(String)map.get("password"));
//        Dao dao = DaoImgl.getInstance();
//        dao.register(user);
        userDao.saveUser(user);
        return new Result(200);

    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/api/getUserList")
    public Result getuserList(){
        Query query = new Query();
        List<User> userList = mongoTemplate.find(query,User.class);
        Result result = new Result();
        result.setUserList(userList);
        result.setCode(200);
        return result;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/api/BanUser")
    public Result banuser(@RequestBody Map map){
        String username = (String)map.get("username");
        Query query = new Query(Criteria.where("username").is(username));
        Update update = new Update();
        update.set("banned",true);
        update.set("status","被封禁");
        mongoTemplate.updateFirst(query,update,User.class);
        return new Result(200);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/api/UnbanUser")
    public Result unbanuser(@RequestBody Map map){
        String username = (String)map.get("username");
        Query query = new Query(Criteria.where("username").is(username));
        Update update = new Update();
        update.set("banned",false);
        update.set("status","未被封禁");
        mongoTemplate.updateFirst(query,update,User.class);
        return new Result(200);
    }
}
