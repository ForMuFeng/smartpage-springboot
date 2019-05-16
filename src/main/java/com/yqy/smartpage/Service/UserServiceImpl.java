package com.yqy.smartpage.Service;

import com.yqy.smartpage.Entity.User;
import com.yqy.smartpage.Entity.Visit;
import com.yqy.smartpage.Mapper.UserMapper;
import com.yqy.smartpage.Mapper.VisitMapper;
import com.yqy.smartpage.Service.Interface.UserService;
import com.yqy.smartpage.util.Utils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

    @Autowired
    VisitMapper visitMapper;
    public Map logincheck(User user){
        String time=new SimpleDateFormat("YYYY:MM:dd HH:mm:ss").format(new Date());

        Map<String,String> map=new HashMap<>();
        User check=userMapper.logincheck(user);
        if(check==null){
            map.put("message","fail");
        }else {
            visitMapper.getNewVisit(new Visit(time,check.getUser_id()));
            String token= Utils.getToken(check);
            map.put("message","success");
            map.put("userid",String.valueOf(check.getUser_id()));
            map.put("username",check.getUser_name());
            map.put("admintoken",token);
        }
        return map;
    }

    public User findUserById(String id){
        return userMapper.findUserById(id);
    }
}
