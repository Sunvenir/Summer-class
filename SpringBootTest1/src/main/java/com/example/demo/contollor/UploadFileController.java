package com.example.demo.contollor;

import com.example.demo.domain.UploadFile;
import com.example.demo.domain.User;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@RestController
public class UploadFileController {

    @Resource
    private MongoTemplate mongoTemplate;

    private Map<String,Object> params = new HashMap<String,Object>();

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/api/uploadImage")
    public Object uploadImage(@RequestParam(value = "image") MultipartFile file,
                              @RequestParam(value = "username") String username){
        if(file.isEmpty()) {
            params.clear();
            params.put("code", 300);
            return params;
        }
        String fileName = file.getOriginalFilename();
        try {
            String url = new String();
            UploadFile uploadFile = new UploadFile();
            Query query = new Query(Criteria.where("Username").is(username));
            UploadFile uploadFile1 = mongoTemplate.findOne(query,UploadFile.class);
            if(uploadFile1 != null){
                Update update = new Update();
                update.set("name",fileName);
                update.set("CreatedTime",new Date());
                update.set("Content",new Binary(file.getBytes()));
                update.set("ContentType",file.getContentType());
                update.set("Size",file.getSize());
                mongoTemplate.updateFirst(query,update,UploadFile.class);
                url = "http://114.115.237.78:8666/api/image/"+ uploadFile1.getId();
            }
            else {
                uploadFile.setName(fileName);
                uploadFile.setUsername(username);
                uploadFile.setCreatedTime(new Date());
                uploadFile.setContent(new Binary(file.getBytes()));
                uploadFile.setContentType(file.getContentType());
                uploadFile.setSize(file.getSize());
                uploadFile.setId(fileName + uploadFile.getCreatedTime());
                UploadFile savedFile = mongoTemplate.save(uploadFile);
                url = "http://114.115.237.78:8666/api/image/"+ savedFile.getId();//访问地址
            }
            Query query1 = new Query(Criteria.where("username").is(username));
            Update update = new Update();
            update.set("avatar",url);
            mongoTemplate.updateFirst(query,update, User.class);
            params.clear();
            System.out.println(url);
            params.put("code", 200);
            params.put("url",url);
        } catch (IOException e) {
            e.printStackTrace();
            params.clear();
            params.put("code", 400);
        }
        return params;
    }

    @CrossOrigin
    @GetMapping(value = "/api/image/{id}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    public byte[] image(@PathVariable String id){
        byte[] data = null;
        UploadFile file = mongoTemplate.findById(id, UploadFile.class);

        if(file != null){
            data = file.getContent().getData();
        }
        return data;
    }
}