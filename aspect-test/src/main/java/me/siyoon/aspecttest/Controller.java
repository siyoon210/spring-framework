package me.siyoon.aspecttest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Controller {
    @Autowired
    private Service service;

    @LogExecutionTime
    @GetMapping
    public String index() throws InterruptedException {
        System.out.println("Controller.index~~");
        service.serve();
        return "index";
    }
}
