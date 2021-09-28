package com.example.springtransactionpropationtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MyService {
    @Autowired
    private MyEntityRepository myEntityRepository;

    @Autowired
    private MyComponent myComponent;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void run() {
        List<MyEntity> all = myEntityRepository.findAll();
        myComponent.run(all);
    }

    @Transactional
    public void init() {
        for (int i = 0; i < 10; i++) {
            myEntityRepository.save(new MyEntity("SAVE"));
        }
    }
}
