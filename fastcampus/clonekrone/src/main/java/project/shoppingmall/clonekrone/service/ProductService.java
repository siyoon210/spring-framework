package project.shoppingmall.clonekrone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.shoppingmall.clonekrone.domain.Product;
import project.shoppingmall.clonekrone.repository.ProductRepository;

import java.util.List;

@Service
@ConfigurationProperties(prefix = "spring.datasource")
public class ProductService {
//    @Autowired
    private ProductRepository productRepository;
    private static int pageSize = 3; //한페이지당 불러 올 상품 갯수

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //모든 품목 리스트 가져오기
    @Transactional
    public Page<Product> getProductList(int startPage) {
        Pageable pageable = PageRequest.of(startPage, pageSize);

        Page<Product> products = productRepository.findProducts(pageable);
        return products;
    }

    //상위 카테고리 기준으로 품목 리스트 가져오기
    @Transactional
    public Page<Product> getProductList(Long superiorId, int start) {
        Pageable pageable = PageRequest.of(start, pageSize);

        Page<Product> products = productRepository.findProductByCategorySuperiorId(superiorId, pageable);
        return products;
    }

    //이름으로 검색한 목록 리스트 가져오기
    @Transactional
    public Page<Product> getProductList(String searchWord, int start) {
        Pageable pageable = PageRequest.of(start, pageSize);
        Page<Product> products = productRepository.findByNameContaining(searchWord, pageable);
        return products;
    }
}
