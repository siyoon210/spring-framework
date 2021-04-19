package me.siyoon.aspecttest;

public class MyService {
    @LogExecutionTime
    public void serve() throws InterruptedException {
        Thread.sleep(2000);
    }
}
