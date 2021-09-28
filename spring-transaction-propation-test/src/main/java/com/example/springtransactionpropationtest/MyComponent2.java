package com.example.springtransactionpropationtest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.transaction.support.AbstractPlatformTransactionManager;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class MyComponent2 {
    @Autowired
    private MyEntityRepository myEntityRepository;

    @Autowired
    private JpaTransactionManager transactionManager;

    @Transactional(rollbackFor = {RuntimeException.class, Exception.class, Error.class}, propagation = Propagation.REQUIRES_NEW)
    public void run(long id) {
        Optional<MyEntity> byId = myEntityRepository.findById(id);
        MyEntity myEntity = byId.get();
        myEntity.setStatus("CHANGE");
        if (myEntity.getId() % 2 == 0) {
            throw new RuntimeException();
        }
    }

    @Transactional(rollbackFor = {RuntimeException.class, Exception.class, Error.class}, propagation = Propagation.REQUIRES_NEW)
    public void run(MyEntity myEntity) {
//        TransactionStatus transactionStatus = TransactionAspectSupport.currentTransactionStatus();
//        System.out.println("transactionStatus.isNewTransaction() = " + transactionStatus.isNewTransaction());

//        transactionStatus.setRollbackOnly();
//        Object savepoint = transactionStatus.createSavepoint();
//        TransactionStatus transaction = transactionManager.getTransaction(TransactionDefinition.withDefaults());
//        Object savepoint = transaction.createSavepoint();
        myEntity.setStatus("CHANGE");
        if (myEntity.getId() % 2 == 0) {
//            transaction.rollbackToSavepoint(savepoint);
//            transactionManager.rollback(transactionStatus);
            throw new RuntimeException();
        }
//        transactionManager.commit(transactionStatus);
//        transactionStatus.releaseSavepoint(savepoint);
//        transaction.releaseSavepoint(savepoint);


    }
}
