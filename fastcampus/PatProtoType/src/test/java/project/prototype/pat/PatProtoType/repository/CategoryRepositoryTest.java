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
import project.prototype.pat.PatProtoType.domain.Category;

import java.util.Set;

import static project.prototype.pat.PatProtoType.repository.Print.printPage;
import static project.prototype.pat.PatProtoType.repository.Print.printSet;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CategoryRepositoryTest {
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void id로_카테고리_한건_조회하기() throws Exception {
        Category category = categoryRepository.findCategoryById(4L);
        System.out.println(category.toString());
    }

    @Test
    public void superiorId로_하위_카테고리_목록_조회하기() throws Exception {
        Set<Category> categorys = categoryRepository.findCategoryBySuperiorId(1L);
        printSet(categorys);
    }
}
