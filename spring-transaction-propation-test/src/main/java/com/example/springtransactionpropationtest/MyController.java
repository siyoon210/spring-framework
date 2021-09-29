package com.example.springtransactionpropationtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 결론 : JPA로 NESTED는 설정불가능
 */
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
