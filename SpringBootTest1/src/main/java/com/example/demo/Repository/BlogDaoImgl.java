package com.example.demo.Repository;

import com.example.demo.domain.Post;
import com.example.demo.domain.User;
import com.example.demo.result.Result;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class BlogDaoImgl implements BlogDao {
    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public boolean ifexists(String username, String title) {
        Query query = new Query(Criteria.where("post_owner.username").is(username));
        query.addCriteria(Criteria.where("title").is(title));
        Post post = mongoTemplate.findOne(query,Post.class);
        if(post == null){
            return false;
        }
        else return true;
    }

    @Override
    public void post_blog(Post post) {
        mongoTemplate.save(post);
    }

    @Override
    public List<Post> show_blogbyname(String username, int pagenum, int pagesize) {
        Query query = new Query(Criteria.where("post_owner.username").is(username)).
                skip((pagenum - 1) * pagesize).limit(pagesize);
        List<Post> list = mongoTemplate.find(query,Post.class);
        if(list.size() < pagesize){
            for(int i = list.size();i < pagesize;i++){
                list.add(null);
            }
        }
        return list;
    }

    @Override
    public int shownumbyname(String username) {
        Query query = new Query(Criteria.where("post_owner.username").is(username));
        int size = (int) mongoTemplate.count(query,Post.class);
        return size;
    }

    @Override
    public List<Post> show_blogbytype(String type, int pagenum, int pagesize) {
        Query query = new Query(Criteria.where("type").is(type)).
                skip((pagenum - 1) * pagesize).limit(pagesize);
        List<Post> list = mongoTemplate.find(query,Post.class);
        if(list.size() < pagesize){
            for(int i = list.size();i < pagesize;i++){
                list.add(null);
            }
        }
        return list;
    }

    @Override
    public int shownumbytype(String type) {
        Query query = new Query(Criteria.where("type").is(type));
        int size = (int) mongoTemplate.count(query,Post.class);
        return size;
    }

}
