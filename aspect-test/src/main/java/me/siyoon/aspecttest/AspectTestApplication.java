package me.siyoon.aspecttest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
public class AspectTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(AspectTestApplication.class, args);
    }

}
