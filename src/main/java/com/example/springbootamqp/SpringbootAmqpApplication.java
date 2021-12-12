package com.example.springbootamqp;

import com.example.springbootamqp.receiver.Tut4Receiver;
import com.example.springbootamqp.runnner.tut4.RabbitAmqpDirectRecvRunner;
import com.example.springbootamqp.runnner.tut4.RabbitAmqpDirectSenderRunner;
import com.example.springbootamqp.sender.Tut4Sender;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class SpringbootAmqpApplication {

    @Profile("usage_message")
    @Bean
    public CommandLineRunner usage() {
        return args -> {
            System.out.println("This app uses Spring Profiles to control its behavior.\n");
                    System.out.println("Sample usage: java -jar rabbit-tutorials.jar --spring.profiles.active=hello-world,sender");
        };
    }

    @Profile("receiver")
    @Bean
    public CommandLineRunner directTutorialReceiver(){
        return new RabbitAmqpDirectRecvRunner();
    }

    @Profile("sender")
    @Bean
    public CommandLineRunner directTutorialSender(){
        return new RabbitAmqpDirectSenderRunner();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAmqpApplication.class, args);
    }

}
