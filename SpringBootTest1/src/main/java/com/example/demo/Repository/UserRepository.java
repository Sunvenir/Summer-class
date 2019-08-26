package com.example.demo.Repository;
import com.example.demo.domain.User;
import java.util.*;
public interface UserRepository {

    User saveOrUpdateUser(User user); //新增或者修改用户

    void deleteUser(Long id); //删除用户

    User getUserById(Long id); //根据用户id获取用户

    List<User> userList (); //获取所有用户的列表

}
