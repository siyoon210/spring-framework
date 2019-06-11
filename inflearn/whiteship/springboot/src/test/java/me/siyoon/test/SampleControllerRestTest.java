package me.siyoon.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)//사용가능한 랜덤 포트에서 실제로 서블릿을 띄운다.
public class SampleControllerRestTest {
    @Autowired
    TestRestTemplate testRestTemplate; //실제 서블릿이 띄어져 있어야 사용가능

    @Test
    public void restHello() {
        String forObject = testRestTemplate.getForObject("/hello", String.class);
        assertThat(forObject).isEqualTo("siyoon");
    }
}
