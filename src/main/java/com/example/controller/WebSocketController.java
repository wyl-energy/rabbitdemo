
package com.example.controller;

import com.example.websocket.RequestMessage;
import com.example.websocket.ResponseMessage;
import com.example.websocket.WebSocketSendAll;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.sound.sampled.Line;
import java.util.List;


/**
 * websocket发送订阅类
 */
@Controller
public class WebSocketController {
    @Autowired
    private WebSocketSendAll sendAll ;

/**
     * 订阅群发
     * 说明：此处有返回值可用@SendTo ，如果能没有返回值只能用messagingTemplate.convertAndSendTo
     * @param
     * @return
     */

    @MessageMapping("/pocketMessage")
    public void toTopic(RequestMessage msg) {
        System.out.println(msg.getMessage());
        ResponseMessage s =  new ResponseMessage();
        s.setMessage(msg.getMessage());
        sendAll.sendPocketMsg(msg.getSionId() +"_"+msg.getYaoId(),s);
    }
    /*@MessageMapping("/pocketMessage")
    @SendTo("/exchange/zhi/kkm")
    public ResponseMessage broadcast(RequestMessage requestMessage){
        System.out.println(requestMessage.getMessage());
        ResponseMessage s =  new ResponseMessage();
        s.setMessage(requestMessage.getMessage());
        return s;
    }*/

}

