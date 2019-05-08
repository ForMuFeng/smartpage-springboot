package com.yqy.smartpage.Entity;

import java.io.Serializable;

/**
 * @program: smartpage-springboot
 * @description:
 * @author: Mr.Yqy
 * @create: 2019-05-08 18:48
 **/
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private int user_id;
    private String user_name;
    private String user_password;
    private String user_authority;
    private String user_mdf;//id的md5值

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_authority() {
        return user_authority;
    }

    public void setUser_authority(String user_authority) {
        this.user_authority = user_authority;
    }

    public String getUser_mdf() {
        return user_mdf;
    }

    public void setUser_mdf(String user_mdf) {
        this.user_mdf = user_mdf;
    }
}
