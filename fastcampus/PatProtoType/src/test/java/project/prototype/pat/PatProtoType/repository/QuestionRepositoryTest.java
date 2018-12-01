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
import project.prototype.pat.PatProtoType.domain.Category;
import project.prototype.pat.PatProtoType.domain.Choice;
import project.prototype.pat.PatProtoType.domain.Passage;
import project.prototype.pat.PatProtoType.domain.Question;

import java.util.Set;

import static project.prototype.pat.PatProtoType.repository.Print.printPage;
import static project.prototype.pat.PatProtoType.repository.Print.printSet;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class QuestionRepositoryTest {
    @Autowired
    private QuestionRepository questionRepository;

    @Test
    public void bookContentId로_문제_조회하기() throws Exception {
        Pageable pageable = PageRequest.of(0, 5);
        Page<Question> questions = questionRepository.findQuestionByBookContentId(6L, pageable);
        printPage(questions);
    }

    @Test
    public void bookId로_문제_조회하기() throws Exception {
        Pageable pageable = PageRequest.of(0, 5);
        Page<Question> questions = questionRepository.findQuestionByBookId(1L, pageable);
        printPage(questions);
    }

    @Test
    public void id로_문제_한건_조회하기() throws Exception {
        Question question = questionRepository.findQuestionById(2L);
        System.out.println(question.toString());
    }

    @Test
    public void questionId로_passage_조회하기() throws Exception {
        Set<Passage> passages = questionRepository.findQuestionById(2L).getPassages();
        printSet(passages);
    }

    @Test
    public void questionId로_choice_조회하기() throws Exception {
        Set<Choice> choices = questionRepository.findQuestionById(3L).getChoices();
        printSet(choices);
    }

    @Test
    public void questionId로_catehory_조회하기() throws Exception {
        System.out.println(questionRepository.findQuestionById(2L).getCategory());
    }
}
