package examples.daoexam.service;

import examples.daoexam.dao.BoardDao;
import examples.daoexam.dto.Board;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
    private BoardDao boardDao;

    public BoardServiceImpl(BoardDao boardDao){
        this.boardDao = boardDao;
    }

    @Override
    @Transactional
    public Board addBoard(Board board) {
        // board정보를 저장. id값은 저장시 자동으로 생성된다.
        Long id = boardDao.addBoard(board);
        board.setId(id);
        return board;
    }

    @Override
    @Transactional
    public Board getBoard(Long id) {
        // readCount 를 수정.
        boardDao.updateCount(id);
        // 1건 읽어오고
        Board board = boardDao.getBoard(id);

        return board;
    }

    // 읽기 전용 메소드
    // start : 시작 id
    // limit : 읽어올 수
    @Override
    @Transactional(readOnly = true)
    public List<Board> getBoards(int start, int limit) {
        return boardDao.getBoards();
    }
}

/*

create table board (
    id bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    title varchar(255) not null,
    name varchar(255) NOT NULL,
    content text,
    regdate datetime,
    read_count int,
    primary key(id)
);
 */