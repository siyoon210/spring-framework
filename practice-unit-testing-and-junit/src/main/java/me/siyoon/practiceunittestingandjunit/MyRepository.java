package me.siyoon.practiceunittestingandjunit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class MyRepository {
    public String myRepoMethod() {
        return "From Real Repo Method";
    }
}
