package me.siyoon.asynctest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MyController {
    private final MyAsyncService myAsyncService;

    @GetMapping("/async")
    public String async() throws InterruptedException, ExecutionException {
        log.info("Controller Thread Name: '{}'", Thread.currentThread().getName());
        final Future<String> stringFuture1 = myAsyncService.myAsyncMethod();
        final Future<String> stringFuture2 = myAsyncService.myAsyncMethod();
        final Future<String> stringFuture3 = myAsyncService.myAsyncMethod();


        System.out.println("------------------" + stringFuture1.get() + stringFuture2.get() + stringFuture3.get());
        return "done";
    }

    @GetMapping("/sync")
    public String sync() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            log.info("Controller Thread Name: '{}'", Thread.currentThread().getName());
            myAsyncService.mySyncMethod();
        }

        System.out.println("------------------");
        return "done";
    }
}
