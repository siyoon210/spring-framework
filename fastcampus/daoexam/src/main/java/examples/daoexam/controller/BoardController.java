package examples.daoexam.controller;

import examples.daoexam.dto.Board;
import examples.daoexam.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class BoardController {
    private BoardService boardService;

    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    @GetMapping("/boards")
    public String list(ModelMap modelMap){
        List<Board> boards = boardService.getBoards(0, 10);
        modelMap.addAttribute("boards", boards);
        return "list";
    }

    @GetMapping("/boards/writeform")
    public String writeform(){
        return "writeform";
    }

    @PostMapping("/boards")
    public String write(@RequestParam(name = "name")String name,
                        @RequestParam(name = "title")String title,
                        @RequestParam(name = "content")String content){
        Board board = new Board();
        board.setName(name);
        board.setTitle(title);
        board.setContent(content);
        board.setRegdate(new Date());
        board.setReadCount(0);

        boardService.addBoard(board);

        return "redirect:/boards";
    }
}
