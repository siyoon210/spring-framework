package examples.daoexam.service;

import examples.daoexam.dto.Board;

import java.util.List;

// 비지니스 메소드를 선언.
public interface BoardService {
    public Board addBoard(Board board);
    public Board getBoard(Long id);
    public List<Board> getBoards(int start, int limit);
}
