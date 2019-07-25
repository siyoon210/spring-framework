package me.siyoon.howtohandlemockmvc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class MyRestController {
    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        String data = "myData";
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

}
