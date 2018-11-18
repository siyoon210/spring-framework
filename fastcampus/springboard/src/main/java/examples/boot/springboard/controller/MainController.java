package examples.boot.springboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {

    public MainController() {
    }

    @RequestMapping("/")
    public String main() {
        return "index";
    }
}

