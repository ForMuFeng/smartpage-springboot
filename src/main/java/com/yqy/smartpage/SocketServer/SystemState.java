package com.yqy.smartpage.SocketServer;

import com.sun.management.OperatingSystemMXBean;

import javax.websocket.Session;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @program: smartpage-springboot
 * @description: 获取服务器系统状态
 * @author: Mr.Yqy
 * @create: 2019-05-11 13:06
 **/
public class SystemState{
    private String time;
    private String state;
    //使用队列记录最近的7次服务器内存占用状态
    public static Queue<SystemState> systemStates=new LinkedBlockingQueue<>();//记录一个最近7个单位时长的服务器工作状态

    public SystemState(String time, String state) {
        this.time = time;
        this.state = state;
    }

    //将toString重写为符合Json格式化的ToString方法
    @Override
    public String toString() {
        return "{" +
                "\"time\":" +"\""+ time +"\""+
                ", \"state\":" + "\""+state +"\"" +
                '}';
    }

    public static  Queue<SystemState> getMemInfo() {
        OperatingSystemMXBean mem = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        float total= mem.getTotalPhysicalMemorySize() / 1024 / 1024;
        float available=total- mem.getFreePhysicalMemorySize() / 1024 / 1024;
        String state= new DecimalFormat("0.0").format((available*100)/total);
        String time=new SimpleDateFormat("HH:mm:ss").format(new Date());
        systemStates.add(new SystemState(time,state));
        if(systemStates.size()>7){
            systemStates.poll();
        }
        return systemStates;
    }

    public static void sendSystemStatment(ConcurrentMap<String,Session> users) throws IOException {
        System.out.println("数量："+users.size());
        for (Map.Entry<String, Session> entry : users.entrySet()) {
            String data="{\"states\":"+getMemInfo().toString()+"}";
            System.out.println(data);
            entry.getValue().getBasicRemote().sendText(data);
        }
    }

}