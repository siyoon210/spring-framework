package com.example.springtransactionpropationtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @Autowired
    private MyService myService;

    @GetMapping("/test")
    public void test() {
        myService.run();
    }

    @GetMapping("/init")
    public void init() {
        myService.init();
    }
}
