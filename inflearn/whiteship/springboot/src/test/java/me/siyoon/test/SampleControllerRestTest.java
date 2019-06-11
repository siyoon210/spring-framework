package me.siyoon.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)//사용가능한 랜덤 포트에서 실제로 서블릿을 띄운다.
public class SampleControllerRestTest {
    @Autowired
    TestRestTemplate testRestTemplate; //실제 서블릿이 띄어져 있어야 사용가능
    @MockBean
    SampleService mockSampleService; //실제 서비스가 아니라 목으로 만들 수 있다!

    @Test
    public void restHello() {
        when(mockSampleService.getName()).thenReturn("puru");
        //getName()이 호출될때 어떤 값을 리턴할지 미리 정해둠

        String forObject = testRestTemplate.getForObject("/hello", String.class);
        assertThat(forObject).isEqualTo("puru");
    }
}
