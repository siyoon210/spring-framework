package me.siyoon.howtohandlemockmvc;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

import java.util.regex.Matcher;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
//@WebMvcTest //밑에 두개를 포함하고 있는 슬라이스 테스트 선언용 애노테이션
@SpringBootTest
@AutoConfigureMockMvc //목mvc객체를 넣어주는 애노테이션
//@AutoConfigureWebMvc //기타 웹mvc설정을 넣어주는 애노테이션
public class MyControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void befoe() {
        final MockMvc build = MockMvcBuilders.standaloneSetup(MyController.class).alwaysExpect(MockMvcResultMatchers.status().isOk()).build();
    }

@Test
public void helloTest() throws Exception {
//        mockMvc.perform(get("/hello").accept(MediaType.TEXT_HTML))
//                .andExpect(status().isOk())
//                .andDo(print());

    //파라머티로 뭐가 들어가는지 알기가 어려운데 실제 객체를 넣으면 어떤 메소드가 있는지 IDE로 쉽게 알 수 있다 개꿀팁
    mockMvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.TEXT_HTML))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andDo(MockMvcResultHandlers.print());

    System.out.println("mockMvc = " + mockMvc.getDispatcherServlet().getEnvironment().toString());
}

    @Test
    public void helloNameTest() throws Exception {
        String name = "siyoon";

        mockMvc.perform(get("/hello/{name}", name).accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void helloNameTest2() throws Exception {
        String name1 = "siyoon";
        String name2 = "puru";

        mockMvc.perform(get("/hello/{name1}/{name2}", name1, name2).accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andDo(print());
    }

@Test
public void helloModelTest() throws Exception {
    mockMvc.perform(get("/hello").accept(MediaType.TEXT_HTML))
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.model().attribute("name", "siyoon"))
            .andDo(print());
}
}

