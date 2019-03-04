package com.example.controller;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {

    //默认交换机
    /*public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("47.99.247.131");
        factory.setUsername("wyl");
        factory.setPassword("123456");
        Connection connection = null;
        Channel channel = null;
        // 建立TCP连接
        connection = factory.newConnection();
        // 在TCP连接的基础上创建通道
        channel = connection.createChannel();
        //创建队列
        channel.queueDeclare("kk", false, false, false, null);
        //发送消息
        channel.basicPublish("", "kk", null, "你好".getBytes("UTF-8"));
    }*/
    /*扇形交换机*/
    /*public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("47.99.247.131");
        factory.setUsername("wyl");
        factory.setPassword("123456");
        Connection connection = null;
        Channel channel = null;
        // 建立TCP连接
        connection = factory.newConnection();
        // 在TCP连接的基础上创建通道
        channel = connection.createChannel();
        channel.exchangeDeclare("shan", BuiltinExchangeType.FANOUT, false, false, null);
        channel.basicPublish("shan", "", null, "你好扇形".getBytes("UTF-8"));
    }*/
    //直连交换机
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("47.99.247.131");
        factory.setUsername("wyl");
        factory.setPassword("123456");
        Connection connection = null;
        Channel channel = null;
        // 建立TCP连接
        connection = factory.newConnection();
        // 在TCP连接的基础上创建通道
        channel = connection.createChannel();
        channel.exchangeDeclare("/exchange", BuiltinExchangeType.DIRECT);
        channel.basicPublish("/exchange", "routingKey", null, "你好直连".getBytes("UTF-8"));
    }
    //topic（主题） 交换机
   /* public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("47.99.247.131");
        factory.setUsername("wyl");
        factory.setPassword("123456");
        Connection connection = null;
        Channel channel = null;
        // 建立TCP连接
        connection = factory.newConnection();
        // 在TCP连接的基础上创建通道
        channel = connection.createChannel();
        channel.exchangeDeclare("topic", BuiltinExchangeType.TOPIC);
        channel.basicPublish("topic", "routingKey", null, "你好主题".getBytes("UTF-8"));
    }*/
}
