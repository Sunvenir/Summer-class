package com.example.demo.contollor;

import com.example.demo.Repository.BlogDao;
import com.example.demo.Repository.UserDao;
import com.example.demo.domain.Post;
import com.example.demo.domain.UploadFile;
import com.example.demo.domain.User;
import com.example.demo.result.Post_result;
import com.example.demo.result.Result;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
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
    public Result post_blog(@RequestParam("image") MultipartFile[] images, @RequestParam("username") String username,
                            @RequestParam("title") String title, @RequestParam("type") String type,
                            @RequestParam("content") String content, @RequestParam("date") Date date){
        if(blogDao.ifexists(username,title)){
            return new Result(300);
        }
        Post post = new Post();
        System.out.println(images[1].getOriginalFilename());
        ArrayList<String> urls = new ArrayList<>();
        UploadFile uploadFile = new UploadFile();
        for(int i = 0;i < images.length;i++){
            try{
                String fileName = images[i].getOriginalFilename();
                uploadFile.setName(fileName);
                uploadFile.setUsername("Blog");
                uploadFile.setCreatedTime(new Date());
                uploadFile.setContent(new Binary(images[i].getBytes()));
                uploadFile.setContentType(images[i].getContentType());
                uploadFile.setSize(images[i].getSize());
                UploadFile savedFile = mongoTemplate.save(uploadFile);
                String url = "http://localhost:8443/api/image/"+ uploadFile.getId();
                urls.add(url);
            }
            catch (IOException e){
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
        int num = totalnum / pagesize + 1;
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
        int num = totalnum / pagesize + 1;
        List<Post> list = blogDao.show_blogbytype((String)map.get("type"),pagenum,pagesize);
//        System.out.println(list);
//        System.out.println(num);
        Result result = new Result(200,list,num);
        return result;

    }

    public static String getStringDate(Date currentTime) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }


}
