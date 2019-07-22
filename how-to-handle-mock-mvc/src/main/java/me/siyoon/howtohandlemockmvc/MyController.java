package me.siyoon.howtohandlemockmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
    @GetMapping("/hello")
    public @ResponseBody String hello() {
        return "hello";
    }

    @GetMapping("/hello/{name}")
    public @ResponseBody
    String helloId(@PathVariable String name) {
        return "hello " + name;
    }
}
