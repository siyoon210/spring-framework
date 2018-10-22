package examples.daoexam.main;

import examples.daoexam.config.ApplicationConfig;
import examples.daoexam.dao.BoardDao;
import examples.daoexam.dto.Board;
import examples.daoexam.service.BoardService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;
import java.util.List;

public class BoardServiceInsertTest {

    public static void main(String[] args) throws Exception {
        ApplicationContext ac =
                new AnnotationConfigApplicationContext(ApplicationConfig.class);

        BoardService boardService = ac.getBean(BoardService.class);

//        Board board = new Board();
//        board.setContent("hello content 2");
//        board.setName("siyoon");
//        board.setReadCount(0);
//        board.setRegdate(new Date()); // java.util.Date
//        board.setTitle("title 2");
//        Board result = boardService.addBoard(board);
//        System.out.println(result);

        List<Board> boards = boardService.getBoards(0, 5);
        for (Board board : boards) {
            System.out.println(board.toString());
        }
    }

}