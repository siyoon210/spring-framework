package me.siyoon.springsecurity;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    public void addViewControllers(final ViewControllerRegistry registry) {
        registry.addViewController("/hello-view-controller").setViewName("hello-view-controller");
    }
}
