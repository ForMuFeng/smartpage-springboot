package com.yqy.smartpage.Service;

import com.yqy.smartpage.Entity.User;
import com.yqy.smartpage.Mapper.UserMapper;
import com.yqy.smartpage.Service.Interface.UserService;
import com.yqy.smartpage.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

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

    public HashMap logincheck(User user){
        User check=userMapper.logincheck(user);
        HashMap<String,String> result=new HashMap<>();
        if(check!=null){
            result.put("name",check.getUser_name());
            result.put("authority",check.getUser_authority());
            result.put("mdf", Utils.getMd5(String.valueOf(user.getUser_id())));
        }else {
            result.put("name",null);
        }
        return result;
    }
}
