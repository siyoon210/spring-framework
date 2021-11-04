package me.siyoon.beanfactorytest;

import org.springframework.beans.factory.InitializingBean;

public class MyComponent3 implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("MyComponent3.afterPropertiesSet");
    }
}
