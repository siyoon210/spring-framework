package me.siyoon.springsecurity.account;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
public class Account {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
}