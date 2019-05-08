package com.yqy.smartpage.Controller;

import com.yqy.smartpage.Entity.User;
import com.yqy.smartpage.Service.Interface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: smartpage-springboot
 * @description:
 * @author: Mr.Yqy
 * @create: 2019-05-08 20:26
 **/
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;
    @RequestMapping("login")
    public String show(User user){
        System.out.println("收到请求");
        System.out.println(user.getUser_name()+" "+user.getUser_password());
        System.out.println(userService.logincheck(user));
        return "success";
    }
}
