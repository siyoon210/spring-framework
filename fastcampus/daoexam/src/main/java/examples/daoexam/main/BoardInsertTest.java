package examples.daoexam.main;

import examples.daoexam.config.ApplicationConfig;
import examples.daoexam.dao.BoardDao;
import examples.daoexam.dao.RoleDao;
import examples.daoexam.dto.Board;
import examples.daoexam.dto.Role;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

public class BoardInsertTest {

	public static void main(String[] args) throws Exception {
		ApplicationContext ac =
				new AnnotationConfigApplicationContext(ApplicationConfig.class);

		BoardDao boardDao
				=ac.getBean(BoardDao.class);

//		Board board = new Board();
//		board.setName("kim");
//		board.setTitle("spring......");
//		board.setContent("java..... spring.........");
//		board.setRegdate(new Date());
//		board.setReadCount(0);
//
//		Long id = boardDao.addBoard(board);
//		System.out.println(id + " 저장.");
//
//		int count = boardDao.deleteBoard(1L);
//		System.out.println(count + " 건 삭제.");
//
//		Board board = new Board();
//		board.setId(2L);
//		board.setName("kang");
//		board.setTitle("kang's android......");
//		board.setContent("andorid");
//		int count = boardDao.updateBoard(board);
//		System.out.println(count + "건 수정");

		Board board = boardDao.getBoard(2L);
		System.out.println(board);
	}

}
