package com.example.springbootamqp.config;

import com.example.springbootamqp.receiver.Tut2Receiver;
import com.example.springbootamqp.sender.Tut2Sender;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({"tut2", "hello-world"})
//@Configuration
public class AMQPConfig {

    // 큐를 정의
    @Bean
    public Queue Hello(){
        return new Queue("hello");
    }

    @Profile("receiver")
    private static class ReceiverConfig{

        @Bean
        public Tut2Receiver receiver1(){
            return new Tut2Receiver(1);
        }

//        @Bean
//        public Tut2Receiver receiver2(){
//            return new Tut2Receiver(2);
//        }
////        // 센터 빈 등록
//        @Profile("sender")
//        @Bean
//        public Tut2Sender sender(){
//            return new Tut2Sender();
//        }
    }
}
