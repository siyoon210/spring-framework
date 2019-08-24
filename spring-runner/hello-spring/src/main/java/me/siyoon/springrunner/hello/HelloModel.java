package me.siyoon.springrunner.hello;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.StringUtils;

public class HelloModel {
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date currentDatetime;

    public HelloModel(String name) {
        if (!StringUtils.hasText(name)) {
            name = "스프링 웹 애플리케이션";
        }
        this.name = name;
        this.currentDatetime = new Date();
    }

    public String getName() {
        return name;
    }

    public Date getCurrentDatetime() {
        return currentDatetime;
    }
}

