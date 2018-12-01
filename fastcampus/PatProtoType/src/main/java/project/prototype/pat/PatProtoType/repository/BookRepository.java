package project.prototype.pat.PatProtoType.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.prototype.pat.PatProtoType.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    // 모든 책 목록 조회하기
    @Query(value = "SELECT b FROM Book b")
    Page<Book> findBook(Pageable pageable);

    //책 이름으로 검색하여 책 목록 조회하기
    Page<Book> findBookByNameContaining(String name, Pageable pageable);

    //책 id로 책 조회하기
    Book findBookById(Long id);
}
