package com.example.springtransactionpropationtest;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class MyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String status;

    public MyEntity(String status) {
        this.status = status;
    }

    public MyEntity() {
    }
}
