package com.example.demo.contollor;

import com.example.demo.Repository.BlogDao;
import com.example.demo.Repository.UserDao;
import com.example.demo.domain.Post;
import com.example.demo.domain.User;
import com.example.demo.result.Post_result;
import com.example.demo.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class Blogcon {
    @Autowired
    private BlogDao blogDao;

    @Autowired
    private UserDao userDao;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/api/blog")
    public Result post_blog(@RequestBody Map map){
        if(blogDao.ifexists((String)map.get("username"),(String)map.get("title")) == true){
            return new Result(300);
        }
        Post post = new Post();
        User user = userDao.findbyname((String)map.get("username"));
        post.setPost_owner(user);
        post.setTitle((String)map.get("title"));
        post.setType((String)map.get("type"));
        post.setDetail((String)map.get("content"));
        post.setDate((String)map.get("date"));
        blogDao.post_blog(post);
        return new Result(200);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/api/getUserBlog")
    @ResponseBody
    public Result show_blogbyname(@RequestBody Map map){
        int totalnum = blogDao.shownumbyname((String)map.get("username"));
        int pagesize = (Integer) map.get("step");
        int pagenum = (Integer) map.get("page");
        int num = totalnum / pagesize + 1;
        List<Post> list = blogDao.show_blogbyname((String)map.get("username"),pagenum,pagesize);
        System.out.println(list);
        System.out.println(num);
        Result result = new Result(200,list,num);
        return result;

    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/api/getTypeBlog")
    @ResponseBody
    public Result show_blogbytype(@RequestBody Map map){
        int totalnum = blogDao.shownumbytype((String)map.get("type"));
        int pagesize = (Integer) map.get("step");
        int pagenum = (Integer) map.get("page");
        int num = totalnum / pagesize + 1;
        List<Post> list = blogDao.show_blogbytype((String)map.get("type"),pagenum,pagesize);
        System.out.println(list);
        System.out.println(num);
        Result result = new Result(200,list,num);
        return result;

    }

}
