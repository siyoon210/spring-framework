package me.siyoon.flywaydemo.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class Account extends AbstractPersistable<Long> {
    @Column(unique = true)
    private String email;
    private String name;
    private String desc;
}
