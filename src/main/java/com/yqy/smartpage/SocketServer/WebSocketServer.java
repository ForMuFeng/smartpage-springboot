package com.yqy.smartpage.SocketServer;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @program: smartpage-springboot
 * @description:参考了　https://blog.csdn.net/moshowgame/article/details/80275084
 * @author: Mr.Yqy
 * @create: 2019-05-11 11:56
 **/
@Component
@ServerEndpoint("/websocket/{sid}")
public class WebSocketServer {
    //服务器在线人数
     private static int onlineCount=0;
    //使用线程安全的set集合记录用户在线状态
    public static ConcurrentMap<String,Session> users=new ConcurrentHashMap<>();
    //与某个客户端会话的Session
    private Session session;
    //服务器状态记录线程
    private Thread stateThread;
    @OnOpen
    public void onOpen(Session session, @PathParam("sid")String sid) throws IOException {
        if(stateThread==null){
            stateThread= new Thread(() -> {
                try {
                    while(true){
                        SystemState.sendSystemStatment(users);
                        //每五秒进行一次服务器内存使用百分比上报
                        Thread.sleep(5000);
                    }
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        if(!stateThread.isAlive()){
            stateThread.start();
        }
        this.session=session;
        users.put(sid,session);
        sendUserCount();
        addUser();
    }

    @OnClose
    public void onClose(@PathParam("sid")String sid){
        System.out.println("有一链接关闭，sid："+sid);
        users.remove(sid);
        removeUser();
    }

    @OnError
    public void onError(Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }

    //群发
    public static void sendInfo(String message,ConcurrentMap<String,Session> users) throws IOException {
            for (Map.Entry<String, Session> entry : users.entrySet()) {
                entry.getValue().getBasicRemote().sendText(message);
            }

    }

    //单发
    public static void sendInfo(String message,String sid) throws IOException {
        //这里可以设定只推送给这个sid的，为null则全部推送
        if(sid!=null) {
            users.get(sid).getBasicRemote().sendText(message);
        }
    }




    private synchronized void addUser(){
        System.out.println("新用户建立连接："+session.getId());
        onlineCount++;
    }

    private synchronized void removeUser(){
        System.out.println("用户下线："+session);
        onlineCount--;
    }
    private synchronized int getUserCount(){
        return onlineCount;
    }
    private synchronized void sendUserCount() throws IOException {
        this.session.getBasicRemote().sendText(String.valueOf(getUserCount()));
    }
}
