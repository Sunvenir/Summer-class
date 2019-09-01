package com.example.demo.Repository;

import com.example.demo.domain.Reply;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class ReplyDaoImgl implements ReplyDao {

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public List<Reply> getreply(String username, String blogname) {
        Query query = new Query(Criteria.where("username").is(username));
        query.addCriteria(Criteria.where("blogname").is(blogname));
        List<Reply> replies = mongoTemplate.find(query,Reply.class);
        return replies;
    }

    @Override
    public void post_reply(Reply reply) {
        mongoTemplate.save(reply);
    }


}
