package examples.boot.sunnyboard.service;

import examples.boot.sunnyboard.domain.Board;
import examples.boot.sunnyboard.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    BoardRepository boardRepository;

    @Override
    @Transactional
    public void test() {
        Board result = boardRepository.getOne(1L);
//        Board result2 = boardRepository.getOne(1L);
//        String str = result.getTitle();
//        result.setTitle("hello java");
//        result.setTitle(str);
        System.out.println(result.getId());
        System.out.println(result.getTitle());
        System.out.println(result.getMember().getName());
    }
}
