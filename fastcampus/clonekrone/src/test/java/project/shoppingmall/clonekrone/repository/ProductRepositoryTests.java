package project.shoppingmall.clonekrone.repository;

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

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class ProductRepositoryTests {
    @Autowired
    ProductRepository productRepository;
    @PersistenceContext// EntityManagerFactory가 DI 할 수 있도록 어노테이션 설정
    EntityManager em;

    @Test
    public void findBy를이용한조회해보기테스트() throws Exception {
        List<Product> products = productRepository.findByName("100% 호밀빵");
        System.out.println(products.size());
        for (Product product : products) {
            System.out.println(product.getName());
        }
    }
    @Test
    public void 이름이포함된Product구하기() throws Exception {
        Pageable pageable = PageRequest.of(0, 3); //시작페이지0 3개씩 가져오기

        Page<Product> products = productRepository.findByNameContaining("호밀", pageable);
        System.out.println("totalElements: " + products.getTotalElements());
        System.out.println("totalPages: " + products.getTotalPages());
        for(Product product : products){
            System.out.println(product.toString());
        }
    }

    @Test
    public void 이름이포함된Product구하기테스트2() throws Exception{
        Pageable pageable = PageRequest.of(1, 3);
        Page<Product> products = productRepository.findByNameContaining2("호밀빵", pageable);

        System.out.println(products.getTotalElements());
        System.out.println(products.getTotalPages());

        for(Product product : products){
            System.out.println(product.toString());
//            System.out.println(product.getId());
//            System.out.println(product.getName());
//            Set<ArticleInfo> articleInfos = articleGroup.getArticleInfos();
//            for(ArticleInfo articleInfo : articleInfos){
//                System.out.println(articleInfo.getName());
//                System.out.println("--------");
//            }
            System.out.println("=============");
        }
    }

//    @Test
//    public void save() {
////        10,"35% 크랜베리 호밀 베이글(5개묶음)", 13000, 2, "100g 당 열량 : 226kcal", false, new Date(),3
//        Product product = new Product();
//        product.setId(10L);
//        product.setName("35% 크랜베리 호밀 베이글(5개묶음)");
//        product.setPrice(13000);
//        product.setPointRate(2);
//        product.setNutrient("100g당 열량 : 226kcal");
//        product.setCutting(false);
//        Category category = new Category();
//        category.setId(3L);
//        product.setCategory(category);
//        product.setRegdate(new Date());
//        em.persist(product);
//    }


}
