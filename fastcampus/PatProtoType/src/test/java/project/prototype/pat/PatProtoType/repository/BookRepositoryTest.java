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
import project.prototype.pat.PatProtoType.domain.Book;

import static project.prototype.pat.PatProtoType.repository.Print.printPage;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @Test
    public void 책_모든_목록_조회하기() throws Exception {
        Pageable pageable = PageRequest.of(0, 3);

        Page<Book> books = bookRepository.findBook(pageable);
        printPage(books);
    }

    @Test
    public void name으로_책_검색하여_조회하기() throws Exception {
        Pageable pageable = PageRequest.of(0, 3);

        Page<Book> books = bookRepository.findBookByNameContaining("마스터", pageable);
        printPage(books);
    }

    @Test
    public void id로_책_한건_조회하기() throws Exception {
        Book book = bookRepository.findBookById(1L);
        System.out.println(book.toString());
    }
}
