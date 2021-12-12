package com.example.springbootamqp.sender;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class Tut4Sender {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private DirectExchange direct;

    AtomicInteger index = new AtomicInteger(0);

    AtomicInteger count = new AtomicInteger(0);

    // 테스트 black 만 보냄
    public void sendWithKey(String color){
        StringBuilder builder = new StringBuilder("hello-");
        builder.append(color); // hello-black
        String message = builder.toString();
        template.convertAndSend(direct.getName(), color, message);
        System.out.println(" [x] Sent '" + message + "'");
    }
}
