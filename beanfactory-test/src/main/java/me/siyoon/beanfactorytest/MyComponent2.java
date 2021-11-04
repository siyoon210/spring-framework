package me.siyoon.beanfactorytest;

import org.springframework.beans.factory.InitializingBean;

public class MyComponent2 implements InitializingBean{
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("MyComponent2.afterPropertiesSet");
    }
}
