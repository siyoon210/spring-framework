package me.siyoon.rethinkingthejavadto.controller;

import me.siyoon.rethinkingthejavadto.dto.ProductDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class MyController {
    @PutMapping("/my-path")
    public ProductDTO.Response.Public create(@RequestBody ProductDTO.Request.Create createRequest) {
        return new ProductDTO.Response.Public(1L, "123", 1.0);
    }
}
