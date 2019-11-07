package me.siyoon.asynctest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MyController {
    private final MyAsyncService myAsyncService;

    @GetMapping("/async")
    public String async() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            log.info("Controller Thread Name: '{}'", Thread.currentThread().getId());
            myAsyncService.myAsyncMethod();
        }

        System.out.println("------------------");
        return "done";
    }

    @GetMapping("/sync")
    public String sync() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            log.info("Controller Thread Name: '{}'", Thread.currentThread().getId());
            myAsyncService.mySyncMethod();
        }

        System.out.println("------------------");
        return "done";
    }
}
