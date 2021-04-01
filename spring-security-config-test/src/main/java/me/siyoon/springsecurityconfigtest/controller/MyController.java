package me.siyoon.springsecurityconfigtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @GetMapping(path = "/")
    public String main() {
        return "index";
    }

    @GetMapping(path = "/edit")
    public String edit() {
        return "edit";
    }

    @GetMapping(path = "/user/login")
    public String login() {
        return "login";
    }

    @GetMapping(path = "/user/logout")
    public String logout() {
        return "logout";
    }

    @GetMapping(path = "/user/forbidden")
    public String forbidden() {
        return "forbidden";
    }
}
