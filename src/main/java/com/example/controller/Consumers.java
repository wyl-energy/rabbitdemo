package com.example.controller;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumers {

    //默认交换机消费者
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

        Consumer consumer = new DefaultConsumer(channel) {

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [HelloworldRecv] Received '" + message + "'");
            }
        };
        channel.basicConsume("kk", true, consumer);
    }*/
    //扇形交换机消费者
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
        //声明交换机（当前交换机已存在，所以不会生成新的）
        channel.exchangeDeclare("shan", BuiltinExchangeType.FANOUT);
        //声明一个临时队列
        String queueName = channel.queueDeclare().getQueue();
        // 将临时队列绑定到交换机上
        channel.queueBind(queueName, "shan", "");
        Consumer consumer = new DefaultConsumer(channel) {

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [Subscribe-"+1+"] Received '" + message + "'");
            }
        };
        channel.basicConsume(queueName, true, consumer);
    }*/
    //直连
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
        //声明交换机（当前交换机已存在，所以不会生成新的）
        channel.exchangeDeclare("zhi", BuiltinExchangeType.DIRECT);
        //声明一个临时队列
        String queueName = channel.queueDeclare().getQueue();
        //绑定路由，同一个队列可以绑定多个值
        channel.queueBind(queueName, "zhi", "routingKey");

        Consumer consumer = new DefaultConsumer(channel) {

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [Subscribe-"+1+"] Received '" + message + "'");
            }
        };
        channel.basicConsume(queueName, true, consumer);
    }*/
    //topic 主题交换机
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
        //声明交换机（当前交换机已存在，所以不会生成新的）
        channel.exchangeDeclare("topic", BuiltinExchangeType.TOPIC);
        //声明一个临时队列
        String queueName = channel.queueDeclare().getQueue();
        //绑定路由，同一个队列可以绑定多个值
        channel.queueBind(queueName, "topic", "routingKey");

        Consumer consumer = new DefaultConsumer(channel) {

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [Subscribe-"+1+"] Received '" + message + "'");
            }
        };
        channel.basicConsume(queueName, true, consumer);
    }*/

}
