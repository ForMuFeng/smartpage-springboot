package com.yqy.smartpage.Service.Interface;

import com.yqy.smartpage.Entity.User;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public interface UserService {
    Map logincheck(User user);
    User findUserById(String id);
}
