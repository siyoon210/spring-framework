package me.siyoon.rethinkingthejavadto.controller;

import me.siyoon.rethinkingthejavadto.dto.ProductDTO;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @PutMapping("/my-path")
    public ProductDTO.Response.Public create(@RequestBody ProductDTO.Request.Create createRequest) {
        System.out.println("createRequest.toString() = " + createRequest.toString());
        return new ProductDTO.Response.Public(1L, "123", 1.0);
    }
}
