package me.siyoon.howtohandlemockmvc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.client.response.MockRestResponseCreators;

@RunWith(SpringRunner.class)
@RestClientTest(MyService.class)
public class MyRestControllerTest {
    @Autowired
    private MockRestServiceServer mockServer;

    @Autowired
    private MyService myService;

    @Test
    public void hello() {
        mockServer.expect(MockRestRequestMatchers.requestTo("/rest/hello"))
                .andRespond(MockRestResponseCreators.withSuccess(
                        new ClassPathResource("/test.json", getClass()), MediaType.APPLICATION_JSON));


    }
}