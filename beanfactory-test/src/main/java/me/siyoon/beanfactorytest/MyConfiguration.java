package me.siyoon.beanfactorytest;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;

@Configuration
public class MyConfiguration {
    @Bean
    public MyComponent2 myComponent2() {
        return new MyComponent2();
    }

    public MyConfiguration(GenericApplicationContext applicationContext) {
        MyComponent3 myComponent3 = new MyComponent3();
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        beanFactory.registerSingleton("myComponent3", myComponent3);
        beanFactory.initializeBean(myComponent3, "myComponent3");
    }
}
