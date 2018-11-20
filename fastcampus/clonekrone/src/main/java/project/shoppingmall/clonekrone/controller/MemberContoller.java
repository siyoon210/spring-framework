package project.shoppingmall.clonekrone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/members")
public class MemberContoller {
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
