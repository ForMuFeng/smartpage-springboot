package com.yqy.smartpage.Mapper;

import com.yqy.smartpage.Entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @program: smartpage-springboot
 * @description:
 * @author: Mr.Yqy
 * @create: 2019-05-08 21:33
 **/
@Component
public interface UserMapper{

    @Select("select user_name,user_id,user_authority from user where user_name=#{user_name} and user_password=#{user_password}")
    User logincheck(User user);
}
