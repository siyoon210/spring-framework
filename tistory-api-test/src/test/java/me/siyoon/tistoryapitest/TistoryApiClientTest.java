package me.siyoon.tistoryapitest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class TistoryApiClientTest {
    @Autowired
    private TistoryApiClient apiClient;

    @Test
    public void getAuthCode() {
        apiClient.getAuthCode();
    }
}