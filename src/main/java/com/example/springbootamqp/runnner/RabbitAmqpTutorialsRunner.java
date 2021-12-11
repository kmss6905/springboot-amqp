package com.example.springbootamqp.runnner;

import com.example.springbootamqp.receiver.Tut2Receiver;
import com.example.springbootamqp.sender.Tut1Sender;
import com.example.springbootamqp.sender.Tut2Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;

// 스프링부트가 시작할 때 실행하도록 함
public class RabbitAmqpTutorialsRunner implements CommandLineRunner {
    @Value("${tutorial.client.duration}")
    private int duration;

    // sender
//    @Autowired
//    private Tut2Sender tut2Sender;

    // receiver
    @Autowired
    private Tut2Receiver receiver;

    @Autowired
    private ConfigurableApplicationContext ctx;

    // spring boot 실행 시 먼저 실행됨
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Ready ... running for " + duration + "ms");
        for (int i = 0; i < 1000; i++) {
            Thread.sleep(duration);
        }
        ctx.close();
    }
}
