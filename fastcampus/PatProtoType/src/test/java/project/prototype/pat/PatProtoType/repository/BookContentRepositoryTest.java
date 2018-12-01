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

import static project.prototype.pat.PatProtoType.repository.PrintPage.printPage;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookContentRepositoryTest {
    @Autowired
    private BookContentRepository bookContentRepository;

    @Test
    public void 모든_책목차_조회하기() throws Exception {
        Pageable pageable = PageRequest.of(0, 5);

        Page<BookContent> bookContents = bookContentRepository.findBookContent(pageable);
        printPage(bookContents);
    }

    @Test
    public void bookId로_책목차_조회하기() throws Exception {
        Pageable pageable = PageRequest.of(0, 5);

        Page<BookContent> bookContents = bookContentRepository.findBookContentByBookId(1L, pageable);
        printPage(bookContents);
    }

    @Test
    public void id로_책목차_한건_조회하기() throws Exception {
        BookContent bookContent = bookContentRepository.findBookContentById(3L);
        System.out.println(bookContent.toString());
    }
}
