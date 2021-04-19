package me.siyoon.springsecurityconfigtest.controller;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MyControllerTest {
    @Test
    void test() throws IOException {
        MultipartFile multipartFile = new MockMultipartFile("스크린샷 2021-03-01 오후 8.31.21.png", "Hello World".getBytes());

        File file = new File("스크린샷 2021-03-01 오후 8.31.21.png");

        multipartFile.transferTo(file);

//        assertThat(FileUtils.readFileToString(new File("src/main/resources/targetFile.tmp"), "UTF-8"))
//                .isEqualTo("Hello World");

    }

}