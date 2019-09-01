package com.example.demo.contollor;

import com.example.demo.Repository.UserDao;
import com.example.demo.domain.User;
import com.example.demo.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@RestController
public class updateusercon {
    @Autowired
    private UserDao userDao;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/api/personalInfo")
    public Result update(@RequestBody Map map){
        User user = new User();
        user.setName((String)map.get("username"));
        user.setRealname((String)map.get("name"));
        user.setEmail( (String)map.get("email"));
        user.setBirthday(StrToDate((String) map.get("birthday")) );
        user.setGender((String) map.get("gender"));
        user.setLocation((String)map.get("location"));
        userDao.update(user);
        return new Result(200);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/api/editpassword")
    public Result changepass(@RequestBody Map map){
        if(userDao.checklogin((String) map.get("username"),(String) map.get("password")) == null){
            return new Result(300);
        }
        userDao.change_password((String) map.get("username"),(String) map.get("newpassword"));
        return new Result(200);
    }


    public static Date StrToDate(String str) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T16:00:00.000Z'");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
