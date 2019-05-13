package com.yqy.smartpage.Entity;

import java.io.Serializable;

/**
 * @program: smartpage-springboot
 * @description:
 * @author: Mr.Yqy
 * @create: 2019-05-13 19:34
 **/
public class Visit implements Serializable {
    private static final long serialVersionUID = 1L;
    private String visit_id;
    private String visit_time;
    private int visit_user_id;

    public Visit() {
    }

    public Visit(String visit_time, int visit_user_id) {
        this.visit_time = visit_time;
        this.visit_user_id = visit_user_id;
    }

    @Override
    public String toString() {
        return "Visit{" +
                "visit_id='" + visit_id + '\'' +
                ", visit_time='" + visit_time + '\'' +
                ", visit_user_id='" + visit_user_id + '\'' +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getVisit_id() {
        return visit_id;
    }

    public void setVisit_id(String visit_id) {
        this.visit_id = visit_id;
    }

    public String getVisit_time() {
        return visit_time;
    }

    public void setVisit_time(String visit_time) {
        this.visit_time = visit_time;
    }

    public int getVisit_user_id() {
        return visit_user_id;
    }

    public void setVisit_user_id(int visit_user_id) {
        this.visit_user_id = visit_user_id;
    }
}
