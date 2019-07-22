package me.siyoon.howtohandlemockmvc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MyControllerTest {
    @Autowired
    private MockMvc mockMvc;


    @Test
    public void helloTest() throws Exception {
        mockMvc.perform(get("/hello").accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void helloNameTest() throws Exception{
        String name = "siyoon";

        mockMvc.perform(get("/hello/{name}", name).accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void helloNameTest2() throws Exception{
        String name1 = "siyoon";
        String name2 = "puru";

        mockMvc.perform(get("/hello/{name1}/{name2}", name1, name2).accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andDo(print());
    }
}

