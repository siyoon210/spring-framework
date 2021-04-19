package me.siyoon.aspecttest;

import org.springframework.stereotype.Component;

@Component
public class Service {

    @LogExecutionTime
    public void serve() throws InterruptedException {
        System.out.println("Service.serve");
        Thread.sleep(2000);
    }
}
