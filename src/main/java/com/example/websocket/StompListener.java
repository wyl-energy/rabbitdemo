package com.example.websocket;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 监听器，监听socket连接和断开连接
 */
@Component

public class StompListener {
    /*@Autowired
    private RedisPool redisPool;*/

    @EventListener
    public void handleWebSocketConnectListener(SessionConnectEvent event) {
        /*StompHeaderAccessor sha = StompHeaderAccessor.wrap(event.getMessage());  //获取消息头
        if(sha.getNativeHeader("userId") == null ||sha.getNativeHeader("userId").get(0) == null ){
            return;
        }
        if(sha.getNativeHeader("yaoId") == null|| sha.getNativeHeader("yaoId").get(0) == null ){
            return;
        }
        if(sha.getNativeHeader("sionId") == null|| sha.getNativeHeader("sionId").get(0) == null ){
            return;
        }
        //用户id
        String userId = sha.getNativeHeader("userId").get(0);
        //回话id,同以前meetingId
        String sionId = sha.getNativeHeader("sionId").get(0);
        //游戏id
        String yaoId = sha.getNativeHeader("yaoId").get(0);
        //长连接通道，用户服务端和客户端进行通信
        String sessionId = sha.getSessionId();
        sha.getSessionAttributes().put("userId",userId);
        sha.getSessionAttributes().put("sionId",sionId);
        sha.getSessionAttributes().put("yaoId",yaoId);
        String key = "webscoket_" + sionId + "_" + yaoId;

        Map<String, Object> getMap = redisPool.getMap(key);


        if(getMap == null){
            getMap = new HashMap<String,Object>();
        }
        if (getMap.get(userId) == null){
            String str = redisPool.getStr(key);
            if(str == null){
                str = "0";
            }
            AtomicInteger number = new AtomicInteger(Integer.parseInt(str));
            int num = number.incrementAndGet();
            redisPool.setStr(key, num  + "");
            getMap.put(userId,sessionId);
            System.out.println("当前加入人数" + num);
            redisPool.setMap(key,getMap);
        }*/
    }
    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        /*StompHeaderAccessor sha = StompHeaderAccessor.wrap(event.getMessage());
        String sionId = (String)sha.getSessionAttributes().get("sionId");
        String userId = (String)sha.getSessionAttributes().get("userId");
        String yaoId = (String)sha.getSessionAttributes().get("yaoId");

        String key = "webscoket_" + sionId + "_" + yaoId;
        System.out.println(key + "  ||usreId:" + userId);
        //长连接通道，用户服务端和客户端进行通信
        String sessionId = sha.getSessionId();
        Map<String, Object> getMap = redisPool.getMap(key);
        if(!getMap.isEmpty()){
            redisPool.delMap(key ,userId);
        }
        String str = redisPool.getStr(key);
        if(str != null && Integer.parseInt(str) > 0){
            AtomicInteger number = new AtomicInteger(Integer.parseInt(str));
            int num = number.decrementAndGet();
            redisPool.setStr(key, + num + "");
            System.out.println("当前加入人数" + num);
        }*/
    }
}
