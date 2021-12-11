package com.example.springbootamqp.runnner;

import com.example.springbootamqp.sender.Tut3Sender;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;

public class RabbitAmqpTutorialFanoutRunner implements CommandLineRunner {
    @Autowired
    private ConfigurableApplicationContext ctx;

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private FanoutExchange fanout;

    @Autowired
    private Tut3Sender tut3Sender;

    @Override
    public void run(String... args) throws Exception {
        String message = "Hello!!";;

        for (int i = 0; i < 100; i++) {
            tut3Sender.send();
            Thread.sleep(1000);
        }
    }
}
