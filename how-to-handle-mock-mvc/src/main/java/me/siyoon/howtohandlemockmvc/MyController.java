package me.siyoon.howtohandlemockmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;

@Controller
public class MyController {
    @GetMapping("/hello")
    public @ResponseBody
    String hello() {
        return "hello";
    }

    @GetMapping("/hello/{name}")
    public @ResponseBody
    String helloName(@PathVariable String name) {
        return "hello " + name;
    }

    @GetMapping("/hello/{name1}/{name2}")
    public @ResponseBody
    String helloName(@PathVariable(name = "name1") String name1, @PathVariable(name = "name2") String name2) {
        return "hello " + name1 + ", " + name2;
    }
}
