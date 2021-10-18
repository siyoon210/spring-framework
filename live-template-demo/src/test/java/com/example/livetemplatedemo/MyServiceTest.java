package com.example.livetemplatedemo;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
class MyServiceTest {
    @InjectMocks
    private MyService dut;

    @Mock
    private MyComponent myComponent;
    @Mock
    private MyRepository myRepository;
    @Mock
    private MyApiClient myApiClient;
}