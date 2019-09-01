package com.example.demo.contollor;

import com.example.demo.Repository.ReplyDao;
import com.example.demo.Repository.UserDao;
import com.example.demo.domain.Post;
import com.example.demo.domain.Reply;
import com.example.demo.domain.User;
import com.example.demo.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class Replycon {
    @Autowired
    ReplyDao replyDao;

    @Autowired
    UserDao userDao;

    @Resource
    private MongoTemplate mongoTemplate;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/api/postReply")
    public Result post_reply(@RequestBody Map map){
        String blog_name = (String) map.get("blog_name");
        String content = (String) map.get("content");
        String blog_owner = (String) map.get("blog_owner");
        String username = (String) map.get("username");
        User user = userDao.findbyname(username);
        String avatar = new String();
        if (user == null){
            avatar = null;
        }
        else {
            avatar = user.getAvatar();
        }
        Reply reply = new Reply();
        reply.setBlogname(blog_name);
        reply.setContent(content);
        reply.setReplyname(blog_owner);
        reply.setUsername(username);
        reply.setDate(getStringDate(new Date()));
        reply.setAvatar(avatar);
        replyDao.post_reply(reply);
        Query query = new Query(Criteria.where("blogname").is(blog_name));
        query.addCriteria(Criteria.where("replyname").is(blog_owner));
        Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC,"date"));
        query.with(sort);
        List<Reply> replies = mongoTemplate.find(query,Reply.class);
        Result result = new Result();
        result.setReplies(replies);
        result.setCode(200);
        return result;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/api/findReply")
    public Result get_reply(@RequestBody Map map){
        String blog_owner = (String) map.get("blog_owner");
        String blog_name = (String) map.get("blog_name");

        Query query = new Query(Criteria.where("blogname").is(blog_name));
        query.addCriteria(Criteria.where("replyname").is(blog_owner));
        Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC,"date"));
        query.with(sort);
        List<Reply> replies = mongoTemplate.find(query,Reply.class);
        Result result = new Result();
        result.setReplies(replies);
        result.setCode(200);
        return result;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/api/likeReply")
    public Result like_reply(@RequestBody Map map){
        String blog_name = (String) map.get("blog_name");
        String date = (String) map.get("date");
        String blog_owner = (String) map.get("blog_owner");
        String username = (String) map.get("username");
        Query query = new Query(Criteria.where("blogname").is(blog_name));
        query.addCriteria(Criteria.where("date").is(date));
        query.addCriteria(Criteria.where("replyname").is(blog_owner));
        query.addCriteria(Criteria.where("username").is(username));
        Reply reply = mongoTemplate.findOne(query,Reply.class);
        int temp = reply.getLike();
        Update update = new Update();
        update.set("like",temp + 1);
        mongoTemplate.updateFirst(query,update,Reply.class);

        Query query1 = new Query(Criteria.where("blogname").is(blog_name));
        query1.addCriteria(Criteria.where("replyname").is(blog_owner));
        Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC,"date"));
        query1.with(sort);
        List<Reply> replies = mongoTemplate.find(query1,Reply.class);
        Result result = new Result();
        result.setReplies(replies);
        result.setCode(200);
        return result;
    }
    public static String getStringDate(Date currentTime) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }
}
