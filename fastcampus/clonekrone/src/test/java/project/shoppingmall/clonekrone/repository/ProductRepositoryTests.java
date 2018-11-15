package project.shoppingmall.clonekrone.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import project.shoppingmall.clonekrone.domain.Product;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class ProductRepositoryTests {
    @Autowired
    ProductRepository productRepository;

    @Test
    public void findBy를이용한조회해보기테스트() throws Exception {
        List<Product> products = productRepository.findByName("단팥빵");
        for (Product product : products) {
            System.out.println(product.getName());
        }
    }
//    @Test
//    public void 이름이포함된Product구하기() throws Exception {
//        Pageable pageable = PageRequest.of(0, 2);
//
//        Page<Product> products = productRepository.findByNameContaining("빵", pageable);
//        System.out.println(products.getTotalElements());
//        System.out.println(products.getTotalPages());
//        for(Product product : products){
//            System.out.println(product.getId());
//            System.out.println(product.getName());
//        }
//    }

}
