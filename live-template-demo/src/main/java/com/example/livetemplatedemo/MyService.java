package com.example.livetemplatedemo;

import org.springframework.stereotype.Service;

@Service
public class MyService {
    private final MyComponent myComponent;
    private final MyRepository myRepository;
    private final MyApiClient myApiClient;

    public MyService(MyComponent myComponent, MyRepository myRepository, MyApiClient myApiClient) {
        this.myComponent = myComponent;
        this.myRepository = myRepository;
        this.myApiClient = myApiClient;
    }

    public MyDto process() {
        myComponent.doComponent();
        MyDto myDto = myRepository.findById(1L);
        myApiClient.request(myDto);
        return null;
    }
}
