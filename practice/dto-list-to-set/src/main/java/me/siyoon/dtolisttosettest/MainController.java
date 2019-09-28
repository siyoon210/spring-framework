package me.siyoon.dtolisttosettest;

import me.siyoon.dtolisttosettest.dto.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller("/")
public class MainController {
    @GetMapping
    public String main() {
        return "main";
    }

    @PostMapping
    public String mainPost(Product product) {
        for (final String s : product.getName()) {
            System.out.println(s);
        }
        return "main";
    }
}
