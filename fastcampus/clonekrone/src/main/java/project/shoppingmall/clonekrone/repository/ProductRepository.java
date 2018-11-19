package project.shoppingmall.clonekrone.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.shoppingmall.clonekrone.domain.Product;

// https://en.wikibooks.org/wiki/Java_Persistence?fbclid=IwAR13Gvni_MncOQ2hoOsns9vaS9ODSfHbMOx0Spm_UjPl7NBXznLh-t4NF_c
// JpaRepository : 저장, id에 해당하는 자료를 조회, 모든 데이터 조회, 삭제, 페이지단위로 읽어오는 기능.
// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
public interface ProductRepository extends JpaRepository<Product, Long> {
    // JPQL을 이용한 조회
    // 모든 품목 목록 조회하기
    @Query(value = "SELECT pr FROM Product AS pr")
    Page<Product> findProducts(Pageable pageable);

    // 품목 이름으로 검색하고 목록 구하기
    Page<Product> findByNameContaining(String name, Pageable pageable);

    // 품목 한건 자세히보기
    Product findProductById(Long id);

    //카테고리로 검색하기
    //카테고리 id로 검색하기
    Page<Product> findProductByCategoryId(Long categoryId, Pageable pageable);

    //상위 카테고리 id native sql로 해보기
    @Query(value = "SELECT pr FROM Product pr INNER JOIN pr.category c WHERE c.superior_id = :superiorId")
    Page<Product> findProductByCategorySuperiorId(@Param("superiorId")Long superiorId, Pageable pageable);
}
