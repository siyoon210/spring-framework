package project.prototype.pat.PatProtoType.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import project.prototype.pat.PatProtoType.domain.BookContent;
import project.prototype.pat.PatProtoType.domain.QuizRecord;
import project.prototype.pat.PatProtoType.domain.Result;

import static project.prototype.pat.PatProtoType.repository.Print.printPage;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class QuizRecordRepositoryTest {
    @Autowired
    private QuizRecordRepository quizRecordRepository;

    @Test
    public void id로_QuizRecord_한건_조회하기() throws Exception {
        QuizRecord quizRecordById = quizRecordRepository.findQuizRecordById(1L);
        System.out.println(quizRecordById);
    }


}
