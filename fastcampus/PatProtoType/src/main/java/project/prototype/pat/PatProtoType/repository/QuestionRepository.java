package project.prototype.pat.PatProtoType.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.prototype.pat.PatProtoType.domain.Passage;
import project.prototype.pat.PatProtoType.domain.Question;

import java.util.Set;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    //책 목차 id로 문제 조회하기
    Page<Question> findQuestionByBookContentId(Long bookContentId, Pageable pageable);

    //책 id로 문제 조회하기
    //@Query(value = "SELECT * FROM question q JOIN book_content bc ON q.book_content_id = bc.id WHERE bc.book_id =:bookId", nativeQuery = true)
    @Query(value = "SELECT q FROM Question q INNER JOIN q.bookContent bc WHERE book_id =:bookId")
    Page<Question> findQuestionByBookId(@Param("bookId") Long bookId, Pageable pageable);

    //문제 id로 문제 조회하기
    Question findQuestionById(Long id);
}
