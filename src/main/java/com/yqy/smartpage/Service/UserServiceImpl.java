package com.yqy.smartpage.Service;

import com.yqy.smartpage.Entity.User;
import com.yqy.smartpage.Mapper.UserMapper;
import com.yqy.smartpage.Service.Interface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: smartpage-springboot
 * @description:
 * @author: Mr.Yqy
 * @create: 2019-05-08 21:20
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    public User logincheck(User user){
        return userMapper.logincheck(user);
    }
}
