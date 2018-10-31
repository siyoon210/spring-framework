package examples.daoexam.dao;

import examples.daoexam.config.ApplicationConfig;
import examples.daoexam.config.DBConfig;
import examples.daoexam.dto.Board;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class BoardDaoTest {
    @Autowired
    BoardDao boardDao; // 테스트할 대상.

    @Test
    public void init(){
        System.out.println("init");
    }

    @Test
    public void getBoards() throws Exception{
        List<Board> boards = boardDao.getBoards();
        Assert.assertEquals(boards.size(), 5);
        for(Board board : boards){
            Assert.assertNotNull(board);
        }
    }
}
