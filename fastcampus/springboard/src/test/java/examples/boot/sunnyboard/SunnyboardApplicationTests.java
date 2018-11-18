package examples.boot.sunnyboard;

import examples.boot.sunnyboard.domain.Board;
import examples.boot.sunnyboard.domain.Member;
import examples.boot.sunnyboard.repository.BoardRepository;
import examples.boot.sunnyboard.repository.MemberRepository;
import examples.boot.sunnyboard.service.BoardService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class SunnyboardApplicationTests {
	@Autowired
	MemberRepository memberRepository;

	@Test
	public void contextLoads() {
		// 해당 메소드가 실행될 때 문제가 없다는 것은 모든 설정이 잘되어 있다.
	}


	@Test
	public void getMember()throws Exception{
		Member member = memberRepository.getOne(1L);
		System.out.println(member.getClass().getName());
		System.out.println(member.getName());
		List<Board> boards = member.getBoards();
		System.out.println(boards.getClass().getName());
		System.out.println("------");
		for(Board board : boards){

		}
	}

}
