package me.siyoon.springsecurityconfigtest.controller;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class MyController {
    @GetMapping(path = "/")
    public String main() {
        return "index";
    }

    @GetMapping(path = "/edit")
    public String edit() throws IOException {
        return "edit";
    }

    @GetMapping(path = "/user/login")
    public String login() {
        return "login";
    }

    @GetMapping(path = "/user/logout")
    public String logout() {
        return "logout";
    }

    @GetMapping(path = "/user/forbidden")
    public String forbidden() {
        return "forbidden";
    }
}
