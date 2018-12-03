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
import project.prototype.pat.PatProtoType.domain.Question;
import project.prototype.pat.PatProtoType.domain.Result;

import static project.prototype.pat.PatProtoType.repository.Print.printPage;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ResultRepositoryTest {
    @Autowired
    private ResultRepository resultRepository;

    @Test
    public void id로_result_한건_조회하기() throws Exception {
        Result result = resultRepository.findResultById(1L);
        System.out.println(result);
    }

    @Test
    public void resultid로_해당Category_조회하기() throws Exception {
        System.out.println(resultRepository.findResultById(1L).getQuestion().getCategory());
    }

    @Test
    public void resultid로_해당_BookContent_조회하기() throws Exception {
        System.out.println(resultRepository.findResultById(1L).getQuestion().getBookContent());
    }

    @Test
    public void resultid로_해당_Book_조회하기() throws Exception {
        System.out.println(resultRepository.findResultById(1L).getQuestion().getBookContent().getBook());
    }

    @Test
    public void resultid로_해당_Publisher_조회하기() throws Exception {
        System.out.println(resultRepository.findResultById(1L).getQuestion().getBookContent().getBook().getPublisher());
    }

    @Test
    public void QuizRecordId로_Result_목록_조회하기() throws Exception {
        Pageable pageable = PageRequest.of(0, 5);
        Page<Result> resultByQuizRecordId = resultRepository.findResultByQuizRecordId(1L, pageable);
        printPage(resultByQuizRecordId);
    }

    @Test
    public void categoryId와quizRecordId로_Result_목록_조회하기() throws Exception {
        Pageable pageable = PageRequest.of(0, 5);
        Page<Result> resultByCategoryIdAndQuizRecordId = resultRepository.findResultByQuizRecordIdAndCategoryId(1L, 4L, pageable);
        printPage(resultByCategoryIdAndQuizRecordId);
    }

}
