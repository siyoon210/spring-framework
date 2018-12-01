package project.prototype.pat.PatProtoType.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.prototype.pat.PatProtoType.domain.BookContent;

public interface BookContentRepository extends JpaRepository<BookContent, Long> {
    // 모든 책 목차 조회하기
    @Query(value = "SELECT bc FROM BookContent bc")
    Page<BookContent> findBookContent(Pageable pageable);

    //책 id로 검색하여 책 목차 조회하기
    Page<BookContent> findBookContentByBookId(Long bookId, Pageable pageable);

    //책 목차 id로 조회하기
    BookContent findBookContentById(Long id);
}
