package com.example.springbootamqp.runnner.tut4;

import com.example.springbootamqp.sender.Tut4Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.Arrays;

// direct exchange send program
public class RabbitAmqpDirectSenderRunner implements CommandLineRunner {

//    private Tut4Sender tut4Sender;
//
//    public RabbitAmqpDirectSenderRunner(
//            Tut4Sender tut4Sender
//    ){
//        this.tut4Sender = tut4Sender;
//    }
    @Autowired
    private Tut4Sender tut4Sender;

    @Override
    public void run(String[] args) throws Exception {
        //customArgument=custom
//        String colorArg = args[0];
        System.out.println("sender program start - to key");
        for (int i = 0; i < 1000; i++) {
            tut4Sender.sendWithKey("orange");
            Thread.sleep(1000);
        }
    }
}
