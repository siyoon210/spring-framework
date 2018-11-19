package project.shoppingmall.clonekrone.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import project.shoppingmall.clonekrone.domain.Product;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ProductServiceTest {
    @Autowired
    private ProductService productService;

    @Test
    public void 모든_품목_불러오기() {
        System.out.println("모든 품목 불러오기 시작");
        Page<Product> products = productService.getProductList(0);//0번페이지
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }

    @Test
    public void 상위카테고리id로_품목_목록_불러오기() {
        System.out.println("상위카테고리id로_품목_목록_불러오기 시작");
        Page<Product> products = productService.getProductListBySuperiorId(1L, 0);//카테고리 아이디5인것만
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }
}
