package com.example.springbootamqp.config;

import com.example.springbootamqp.receiver.Tut1Receiver;
import com.example.springbootamqp.sender.Tut1Sender;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@Profile({"tut1", "hello-world"})
public class AMQPConfig {

    // 큐를 정의
    @Bean
    public Queue Hello(){
        return new Queue("hello");
    }

    // 리시버 빈 등록
    @Profile("receiver")
    @Bean
    public Tut1Receiver receiver(){
        return new Tut1Receiver();
    }

    // 센터 빈 등록
    @Profile("sender")
    @Bean
    public Tut1Sender sender(){
        return new Tut1Sender();
    }
}
