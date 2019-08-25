package com.example.demo.contollor;

import com.example.demo.Mongo_jdbc.Dao;
import com.example.demo.Mongo_jdbc.DaoImgl;
import com.example.demo.db.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class logincon {
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                      @RequestParam("password") String password,
                      Map<String,Object> map, HttpSession session){
        Dao dao = DaoImgl.getInstance();
        User user = dao.login(username,password);
        if(user != null){
            return "login_test";
        }
        else {
            return "login";
        }
    }
}
