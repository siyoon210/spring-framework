package com.example.springtransactionpropationtest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
class MyTest {
    @Autowired
    private MyService myService;

    @Autowired
    private MyEntityRepository myEntityRepository;

    @BeforeEach
    void setUp() {
        myEntityRepository.deleteAll();
        for (int i = 0; i < 10; i++) {
            myEntityRepository.save(new MyEntity("SAVE"));
        }
    }

    @Test
    void test() {
        myService.run();
    }
}

