package com.yqy.smartpage.Entity;

import java.io.Serializable;

/**
 * @program: smartpage-springboot
 * @description:
 * @author: Mr.Yqy
 * @create: 2019-05-08 18:52
 **/
public class Log implements Serializable {
    private static final long serialVersionUID = 1L;

    private int log_id;
    private int log_port_id;
    private String log_time;
    private int log_user_id;



    public int getLog_id() {
        return log_id;
    }

    public void setLog_id(int log_id) {
        this.log_id = log_id;
    }

    public int getLog_port_id() {
        return log_port_id;
    }

    public void setLog_port_id(int log_port_id) {
        this.log_port_id = log_port_id;
    }

    public String getLog_time() {
        return log_time;
    }

    public void setLog_time(String log_time) {
        this.log_time = log_time;
    }

    public int getLog_user_id() {
        return log_user_id;
    }

    public void setLog_user_id(int log_user_id) {
        this.log_user_id = log_user_id;
    }
}
