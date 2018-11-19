package project.shoppingmall.clonekrone.controller;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.shoppingmall.clonekrone.domain.Product;
import project.shoppingmall.clonekrone.service.ProductService;

@Controller
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    //상품 목록 가져오기
    @GetMapping("/product/list")
    public String list(@RequestParam(value = "start", defaultValue = "0") int start,
                       @RequestParam(value = "superiorid", defaultValue = "") Long superiorId,
                       @RequestParam(value = "searchWord", defaultValue = "") String searchWord,
                       Model model) {
        Page<Product> productPage = null;
        if (superiorId == null && searchWord.length() > 0) {
            productPage = productService.getProductList(searchWord, start);
            model.addAttribute("searchWord", searchWord);
        } else if (superiorId != null && searchWord.length() <= 0) {
            productPage = productService.getProductList(superiorId, start);
            model.addAttribute("superiorId", superiorId);
        } else {
            productPage = productService.getProductList(start);
        }
        model.addAttribute("productList", productPage.getContent());
        model.addAttribute("totalPage", productPage.getTotalPages());
        return "/product/list";
    }

}
