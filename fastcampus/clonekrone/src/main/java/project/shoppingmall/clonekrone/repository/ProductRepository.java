package project.shoppingmall.clonekrone.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import project.shoppingmall.clonekrone.domain.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

// https://en.wikibooks.org/wiki/Java_Persistence?fbclid=IwAR13Gvni_MncOQ2hoOsns9vaS9ODSfHbMOx0Spm_UjPl7NBXznLh-t4NF_c
// JpaRepository : 저장, id에 해당하는 자료를 조회, 모든 데이터 조회, 삭제, 페이지단위로 읽어오는 기능.
// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
public interface ProductRepository extends CrudRepository<Product, Long> {
//public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByName(String name);

    // Spring Data JPA method query
    // select * from article_group where name like ? limit ?
    Page<Product> findByNameContaining(String name, Pageable pageable);


    // JPQL을 이용한 조회
    @Query(value = "select pr from Product pr where pr.name like CONCAT('%',:name,'%')")
    Page<Product> findByNameContaining2(@Param("name")String name, Pageable pageable);


}
