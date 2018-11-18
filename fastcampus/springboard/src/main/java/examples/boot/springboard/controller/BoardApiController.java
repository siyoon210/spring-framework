package examples.boot.springboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/boards")
public class BoardApiController {
    @GetMapping
    public String test() {
        return "Hello board api";
    }
}
