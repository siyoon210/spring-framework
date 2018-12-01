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
import project.prototype.pat.PatProtoType.domain.Publisher;

import static project.prototype.pat.PatProtoType.repository.PrintPage.printPage;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PublisherRepositoryTest {
    @Autowired
    private PublisherRepository publisherRepository;

    @Test
    public void 출판사_모든_목록_조회하기() throws Exception {
        Pageable pageable = PageRequest.of(0, 3);
        Page<Publisher> publishers = publisherRepository.findPublisher(pageable);
        printPage(publishers);
    }

    @Test
    public void name으로_검색하여_출판사_목록_조회하기() throws Exception {
        Pageable pageable = PageRequest.of(0, 3);
        Page<Publisher> publishers = publisherRepository.findPublisherByNameContaining("위포", pageable);
        printPage(publishers);
    }

    @Test
    public void id로_출판사_한건_조회하기() throws Exception {
        Publisher publisher = publisherRepository.findPublisherById(1L);
        System.out.println(publisher.toString());
    }
}
