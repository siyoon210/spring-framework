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

@Service
@ConfigurationProperties(prefix = "spring.datasource")
public class ProductService {
//    @Autowired
    private ProductRepository productRepository;
    private static int pageSize = 3; //한페이지당 불러 올 상품 갯수

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public Page<Product> getProductList(int startPage) {
        Pageable pageable = PageRequest.of(startPage, pageSize);

        Page<Product> products = productRepository.findProducts(pageable);
        return products;
    }

    @Transactional
    public Page<Product> getProductListBySuperiorId(Long superiorId, int startPage) {
        Pageable pageable = PageRequest.of(startPage, pageSize);

        Page<Product> products = productRepository.findProductByCategorySuperiorId(superiorId, pageable);
        return products;
    }
}
