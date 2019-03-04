package com.example.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.HandshakeInterceptor;

/**
 * websocket配置类
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * addEndpoint：添加STOMP协议的端点。提供WebSocket或SockJS客户端访问的地址
     * withSockJS：使用SockJS协议
     * @param registry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/api/hui/socket")
               .setAllowedOrigins("*") // 添加允许跨域访问
                .withSockJS()
        ;
    }

    /**
     * 配置消息代理
     * 这个方法的作用是定义消息代理，通俗一点讲就是设置消息连接请求的各种规范信息。
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry  registry) {
        //使用默认的交换机同topic
        registry.enableStompBrokerRelay("/exchange","/queue","/amq/queue","/topic")
                .setRelayHost("47.99.247.131")          //连接地址
                .setClientLogin("wyl")
                .setClientPasscode("123456")
                .setSystemLogin("wyl")
                .setSystemPasscode("123456")
                .setSystemHeartbeatReceiveInterval(500000)   //设置系统心跳接收间隔
                .setSystemHeartbeatReceiveInterval(400000)  //设置系统心跳发送间隔
                ;

        registry.setApplicationDestinationPrefixes("/api");//应用请求前缀（路径里必须有api,要不访问不到）
        registry.setUserDestinationPrefix("/user");//推送用户前缀
    }

}
