package me.siyoon.beanfactorytest;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class MyComponent1 implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("MyComponent.afterPropertiesSet");
    }
}
