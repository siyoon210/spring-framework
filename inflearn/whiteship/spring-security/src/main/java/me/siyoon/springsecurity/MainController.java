package me.siyoon.springsecurity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/my")
    public String my() {
        return "my";
    }
}
