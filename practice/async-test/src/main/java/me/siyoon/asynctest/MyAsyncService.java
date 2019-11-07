package me.siyoon.asynctest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MyAsyncService {
    @Async(value = "myTaskExecutor")
    public void myAsyncMethod() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
            log.info("Async! '{}', Thread Name : {}", i, Thread.currentThread().getName());
        }
    }

    public void mySyncMethod() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
            log.info("Sync! '{}', Thread Name : {}", i, Thread.currentThread().getName());
        }
    }
}
