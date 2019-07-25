package me.siyoon.howtohandlemockmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("name", "siyoon");
        return "index";
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
