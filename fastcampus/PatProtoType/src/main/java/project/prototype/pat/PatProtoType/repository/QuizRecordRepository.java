package project.prototype.pat.PatProtoType.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import project.prototype.pat.PatProtoType.domain.QuizRecord;
import project.prototype.pat.PatProtoType.domain.Result;

public interface QuizRecordRepository extends JpaRepository<QuizRecord, Long> {
    //QuizRecord id로 QuizRecord 조회하기
    QuizRecord findQuizRecordById(Long id);


}
