package project.shoppingmall.clonekrone.repository;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import project.shoppingmall.clonekrone.domain.Product;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class ProductRepositoryTests {
    @Autowired
    ProductRepository productRepository;

    @Test
    public void JPQL을_이용하여_모든_Product조회하기() throws Exception {
        Pageable pageable = PageRequest.of(0, 3);

        Page<Product> products = productRepository.findProducts(pageable);
        printPage(products);
    }

    @Test
    public void 이름으로_검색한_Product조회하기() throws Exception {
        Pageable pageable = PageRequest.of(0, 3); //시작페이지0 3개씩 가져오기

        Page<Product> products = productRepository.findByNameContaining("호밀", pageable);
        printPage(products);
    }

    @Test
    public void id로_Product_한건_조회하기() throws Exception {
        Product product = productRepository.findProductById(2L);
        System.out.println(product.toString());
    }

    @Test
    public void 카테고리Id로_검색한_Product조회하기() throws Exception {
        Pageable pageable = PageRequest.of(0,3);

        Page<Product> products = productRepository.findProductByCategoryId(2L, pageable);
        printPage(products);
    }

    @Test
    public void 상위카테고리ID로_검색한_Product조회하기() throws Exception {
        Pageable pageable = PageRequest.of(0,3);

        Page<Product> products = productRepository.findProductByCategorySuperiorId(1L,pageable);
        printPage(products);
    }

    private void printPage(Page<?> page) {
        System.out.println("totalElements: " + page.getTotalElements());
        System.out.println("totalPages: " + page.getTotalPages());
        for(Object element : page){
            System.out.println(element.toString());
        }
    }

//    @Test
//    public void 상위카테고리ID로_Product조회하기() throws Exception {
//        Pageable pageable = PageRequest.of(0, 5); //시작페이지0 5개씩 가져오기
//        Page<Product> products = productRepository.findProductBySuperiorId(1L, pageable);
//
//        System.out.println("totalElements: " + products.getTotalElements());
//        System.out.println("totalPages: " + products.getTotalPages());
//        for(Product product : products){
//            System.out.println(product.toString());
//        }
//    }

}
