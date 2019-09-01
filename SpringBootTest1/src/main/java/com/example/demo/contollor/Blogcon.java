package com.example.demo.contollor;

import com.example.demo.Repository.BlogDao;
import com.example.demo.Repository.UserDao;
import com.example.demo.domain.Post;
import com.example.demo.domain.Rookie;
import com.example.demo.domain.UploadFile;
import com.example.demo.domain.User;
import com.example.demo.result.Post_result;
import com.example.demo.result.Result;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


@RestController
public class Blogcon {
    @Autowired
    private BlogDao blogDao;

    @Autowired
    private UserDao userDao;


    @Resource
    private MongoTemplate mongoTemplate;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/api/blog")
    public Result post_blog( @RequestParam(value = "image1",required = false) MultipartFile image1,
                             @RequestParam(value = "image2",required = false) MultipartFile image2,
                             @RequestParam(value = "image3",required = false) MultipartFile image3,
                             @RequestParam(value = "image4",required = false) MultipartFile image4,
                             @RequestParam(value = "image5",required = false) MultipartFile image5,
                             @RequestParam(value = "image6",required = false) MultipartFile image6,
                             @RequestParam(value = "image7",required = false) MultipartFile image7,
                             @RequestParam(value = "image8",required = false) MultipartFile image8,
                             @RequestParam(value = "image9",required = false) MultipartFile image9,
                             @RequestParam("username") String username,
                            @RequestParam("title") String title, @RequestParam("type") String type,
                            @RequestParam("content") String content, @RequestParam("date") Date date, HttpServletRequest request) {
        if (blogDao.ifexists(username, title)) {
            return new Result(300);
        }
        //String[] imagename = {"image1", "image2", "image3", "image4", "image5", "image6", "image7", "image8", "image9"};
        ArrayList<MultipartFile> images = new ArrayList<>();
        images.add(image1);
        images.add(image2);
        images.add(image3);
        images.add(image4);
        images.add(image5);
        images.add(image6);
        images.add(image7);
        images.add(image8);
        images.add(image9);
        Post post = new Post();
        ArrayList<String> urls = new ArrayList<>();
        UploadFile uploadFile = new UploadFile();

            int i = 0;
            while (images.get(i) != null) {
                try {
                    String fileName = images.get(i).getOriginalFilename();
                    System.out.println(fileName);
                    uploadFile.setName(fileName);
                    uploadFile.setUsername("Blog");
                    uploadFile.setCreatedTime(new Date());
                    uploadFile.setContent(new Binary(images.get(i).getBytes()));
                    uploadFile.setContentType(images.get(i).getContentType());
                    uploadFile.setSize(images.get(i).getSize());
                    uploadFile.setId(fileName + uploadFile.getCreatedTime());
                    UploadFile savedFile = mongoTemplate.save(uploadFile);
                    String url = "http://114.115.237.78:8666/api/image/" + savedFile.getId();
                    urls.add(url);
                    i++;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            String date1 = getStringDate(date);
            User user = userDao.findbyname(username);
            post.setUrls(urls);
            post.setPost_owner(user);
            post.setTitle(title);
            post.setType(type);
            post.setDetail(content);
            post.setDate(date1);
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
        int num = (int) Math.ceil(totalnum / pagesize);
        if(num == 0){
            num = 1;
        }
        List<Post> list = blogDao.show_blogbyname((String)map.get("username"),pagenum,pagesize);
//        System.out.println(list);
//        System.out.println(num);
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
        int num = (int) Math.ceil(totalnum / pagesize);
        if(num == 0){
            num = 1;
        }
        List<Post> list = blogDao.show_blogbytype((String)map.get("type"),pagenum,pagesize);
//        System.out.println(list);
//        System.out.println(num);
        Result result = new Result(200,list,num);
        return result;

    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/api/likeBlog")
    public Result blog_like(@RequestBody Map map){
        String username = (String) map.get("blog_owner");
        String title = (String) map.get("blog_name");
        Query query = new Query(Criteria.where("post_owner.username").is(username));
        query.addCriteria(Criteria.where("title").is(title));
        Post post = mongoTemplate.findOne(query,Post.class);
        int temp = post.getLike();
        //System.out.println(temp);
        Update update = new Update();
        update.set("like",temp + 1);
        mongoTemplate.updateFirst(query,update,Post.class);
        Result result = new Result();
        result.setCode(200);
        result.setLike(temp + 1);
        System.out.println(result.getLike());
        return result;

    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/api/getRecentFive")
    public Result getRecentBlog(@RequestBody Map map){
        Query query = new Query().limit(5);
        Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC,"date"));
        query.with(sort);
        List<Post> list = mongoTemplate.find(query,Post.class);
        Result result = new Result();
        result.setList(list);
        result.setCode(200);
        return result;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/api/deleteBlog")
    public Result delete_blog(@RequestBody Map map){
        String username = (String) map.get("blog_owner");
        String title = (String) map.get("blog_name");
        Query query = new Query(Criteria.where("post_owner.username").is(username));
        query.addCriteria(Criteria.where("title").is(title));
        mongoTemplate.remove(query,Post.class);
        return new Result(200);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/api/uploadrookie")
    public Result uploadrookie(@RequestBody Map map){
        String content = (String) map.get("content");
        System.out.println(content);
        Query query = new Query();
        Update update = new Update();
        update.set("content",content);
        mongoTemplate.upsert(query,update, Rookie.class);
        return new Result(200);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/api/getRookie")
    public Result getRookie(@RequestBody Map map){
        Query query = new Query();
        Rookie rookie = mongoTemplate.findOne(query,Rookie.class);
        Result result = new Result();
        result.setCode(200);
        result.setContent(rookie.getContent());
        return result;
    }

    public static String getStringDate(Date currentTime) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }


}
