package inflearn.whiteship.springboot.webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {

    @GetMapping("/hello-template")
    public String hello(Model model) {
        model.addAttribute("name", "siyoon");
        return "hello-templateEngine";
    }
}
