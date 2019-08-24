package com.example.demo;

import com.example.demo.db.User;
import com.example.demo.db.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DbController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/db")
    public String DbTest() {
        //userRepository.save(new User(1,"admin","123456"));
        return "!!";
    }
}
