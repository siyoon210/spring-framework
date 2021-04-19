package me.siyoon.aspecttest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServiceTest {
    @Autowired
    private Service service;

    @Test
    public void test() throws InterruptedException {
        service.serve();
    }

}