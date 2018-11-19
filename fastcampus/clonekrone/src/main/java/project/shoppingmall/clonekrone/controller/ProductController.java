package project.shoppingmall.clonekrone.controller;

import org.springframework.stereotype.Controller;
import project.shoppingmall.clonekrone.service.ProductService;

@Controller
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

}
