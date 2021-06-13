package me.siyoon.springnativebetatest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @PostMapping("/hello")
    public String hello(@RequestBody String name) {
        return "HELLO~! " + name;
    }
}
