package project.prototype.pat.PatProtoType.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.prototype.pat.PatProtoType.domain.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    // 모든 출판사 목록 조회하기
    @Query(value = "SELECT pb FROM Publisher pb")
    Page<Publisher> findPublisher(Pageable pageable);

    //출판사 이름으로 검색하여 출판사 조회하기
    Page<Publisher> findPublisherByNameContaining(String name, Pageable pageable);

    //출판사 id로 출판사 조회하기
    Publisher findPublisherById(Long id);
}
