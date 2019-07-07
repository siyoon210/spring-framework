package me.siyoon.jpaownertest.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString(of ="id")
public class EntityB {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToOne(mappedBy = "entityB")
    private EntityA entityA;
}
