package com.example.demo.Repository;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import com.example.demo.domain.User;
import org.springframework.stereotype.Repository;

@Repository//用于标识UserRepositoryimpl 类是一个可注入的bean 。
public class UserRepositoryImpl implements UserRepository {

    //用来生成一个递增的id ，作为用户的唯一编号。
    private  static AtomicInteger counterId = new AtomicInteger();

    //模拟数据的存储，
    private final ConcurrentMap<Integer,User> userConcurrentMap =new ConcurrentHashMap<Integer, User>();

    @Override
    public User saveOrUpdateUser(User user) {
        int  id =user.getId();
        if (id==0){
            id=counterId.incrementAndGet();
            user.setId(id);
        }
        this.userConcurrentMap.put(id,user);
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        this.userConcurrentMap.remove(id);

    }

    @Override
    public User getUserById(Long id) {
        return this.userConcurrentMap.get(id);
    }

    @Override
    public List<User> userList() {
        return new ArrayList<User>(this.userConcurrentMap.values());
    }
}
