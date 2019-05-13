package com.yqy.smartpage.Controller;

import com.alibaba.fastjson.JSON;
import com.yqy.smartpage.Annotation.PassToken;
import com.yqy.smartpage.Entity.User;
import com.yqy.smartpage.Entity.Visit;
import com.yqy.smartpage.Mapper.VisitMapper;
import com.yqy.smartpage.Service.Interface.UserService;
import com.yqy.smartpage.SocketServer.WebSocketServer;
import com.yqy.smartpage.util.Utils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
    VisitMapper visitMapper;

    @Autowired
    UserService userService;
    @RequestMapping("login")
    public Map login(@RequestBody User user){
        String time=new SimpleDateFormat("YYYY:MM:dd HH:mm:ss").format(new Date());
        visitMapper.getNewVisit(new Visit(time,user.getUser_id()));
        Map map=userService.logincheck(user);
        return map;
    }

    /**
     * websocket主动下线
     * @param id
     * @return
     * @throws IOException
     */
    @RequestMapping("slogout")
    public String slogout(@RequestBody String id) throws IOException {
        WebSocketServer.slogout(JSON.parseObject(id).getString("id"));
        return "主动下线成功";
    }
}
