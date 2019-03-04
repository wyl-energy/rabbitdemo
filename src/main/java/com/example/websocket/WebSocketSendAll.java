package com.example.websocket;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompBrokerRelayMessageHandler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

import javax.annotation.Resource;
import java.util.List;

/**
 * 服务端主动给客户端发送消息，用于游戏
 */
@Component
public class WebSocketSendAll {

    @Resource
    private SimpMessagingTemplate messagingTemplate ;
    /**
     * 发给所有订阅用户
     * @param msg
     */
    public void sendPocketMsg(String key,ResponseMessage msg) {
        messagingTemplate.convertAndSend("/topic/"+ key, msg);
    }

    /**
     * 发送给指定用户
     * @param key
     * @param msg
     */
    public void sendPocketMsgUser(String key,String msg) {
        //通过rabbitmq 具体还不知道怎么一对一发送，只能是通过userId订阅到不同的队列上实现一对一
        //messagingTemplate.convertAndSendToUser(key,"/aloneMessage", msg);
        messagingTemplate.convertAndSend("/topic/"+ key, msg);
    }

}
