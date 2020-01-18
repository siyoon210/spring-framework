package me.siyoon.practiceunittestingandjunit;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyService {
    private final MyRepository myRepository;

    public void myMethod() {

    }
}
