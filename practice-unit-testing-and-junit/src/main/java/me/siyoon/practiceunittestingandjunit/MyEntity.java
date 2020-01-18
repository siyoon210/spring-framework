package me.siyoon.practiceunittestingandjunit;

import javax.persistence.Entity;

@Entity
public class MyEntity {
    public String myEntityMethod() {
        return "From Real Entity Method";
    }
}
