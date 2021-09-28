package com.example.springtransactionpropationtest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class MyComponent {
    @Autowired
    private MyComponent2 myComponent2;

    @Autowired
    private MyEntityRepository myEntityRepository;

//    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void run(List<MyEntity> myEntities) {
        for (MyEntity myEntity : myEntities) {
            try {
                myComponent2.run(myEntity);
            } catch (Exception e) {
                log.info("exeption ocuured. {} / {}", myEntity.getId(), e.getMessage());
            }
        }
//        for (long i = 1; i < 10; i++) {
//            try {
//                myComponent2.run(i);
//            } catch (Exception e) {
//                log.info("예외 id {}", i);
//            }
//        }

//        for (MyEntity myEntity : myEntities) {
//            try {
//                myComponent2.run(myEntity.getId());
//            } catch (Exception e) {
//                log.info("exeption ocuured. {} / {}", myEntity.getId(), e.getMessage());
//            }
//        }
    }
}
