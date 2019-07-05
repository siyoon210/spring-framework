package me.siyoon.springsecurity;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Component
public class MainController {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/my")
    public String my() {
        return "my";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }
}
