package com.example.demo.contollor;

import com.example.demo.Repository.Dao;
import com.example.demo.Repository.DaoImgl;
import com.example.demo.domain.User;
import com.example.demo.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;


@Controller
public class logincon {
    @CrossOrigin
    @RequestMapping(value = "/login")
    public Result login( @RequestBody User requestUser){
        Dao dao = DaoImgl.getInstance();
        User user = dao.login(requestUser.getName(),requestUser.getPassword());
        if(user != null){
            return new Result(400);
        }
        else {
            return new Result(200);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/user/register")
    public Result register(@RequestBody User requestUser){
        Dao dao = DaoImgl.getInstance();
        dao.register(requestUser);
        return new Result(400);

    }
}
