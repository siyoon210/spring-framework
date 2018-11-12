package examples.daoexam.controller;

import examples.daoexam.dto.Board;
import examples.daoexam.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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

    @GetMapping("/boards/download/{id}")
    @ResponseBody
    public void download(@PathVariable("id") Long id,
                         HttpServletResponse response){
        // id에 해당하는 파일정보를 읽는다.
        String contentType = "image/gif";
        long size = 13898L;
        String originalFileName = "github.gif";
        String savePath = "/tmp/2018/10/31/90b51b95-4d5a-4cb0-829e-c29947a9dab5";

        response.setContentLengthLong(size);
//        response.setContentType("application/x-msdownload");
        response.setContentType(contentType);
        try {
            originalFileName = URLDecoder.decode(originalFileName, "ISO8859_1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
//        response.setHeader("Content-disposition", "attachment; filename="+ originalFileName);

        InputStream in = null;
        OutputStream out = null;
        try{
            in = new FileInputStream(savePath);
            out = response.getOutputStream();
            byte[] buffer = new byte[1024];
            int readCount = 0;
            while((readCount = in.read(buffer)) != -1){
                out.write(buffer,0,readCount);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            if(in != null){
                try{ in.close(); } catch(Exception e){}
            }
            if(out != null){
                try{ out.close(); } catch(Exception e){}
            }
        }
    }

    @GetMapping("/boards/writeform")
    public String writeform(){
        return "writeform";
    }

    @PostMapping("/boards")
    public String write(@RequestParam(name = "name")String name,
                        @RequestParam(name = "title")String title,
                        @RequestParam(name = "content")String content,
                        @RequestParam("file") MultipartFile file){
        Board board = new Board();
        board.setName(name);
        board.setTitle(title);
        board.setContent(content);
        board.setRegdate(new Date());
        board.setReadCount(0);

        System.out.println("------file info start ----");
        System.out.println(file.getContentType());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getName());
        System.out.println(file.getSize());

        UUID uuid = UUID.randomUUID();
        String uuidStr = uuid.toString();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String dateStr = simpleDateFormat.format(new Date());
        System.out.println(uuidStr);
        System.out.println(dateStr);

        String baseDir = "/tmp"; // 이미 있어야 한다.
        String saveDir = baseDir + "/" + dateStr;
        String saveFile = saveDir + "/" + uuidStr;

        File fileObj = new File(saveDir);
        fileObj.mkdirs();

        try (InputStream in = file.getInputStream();
             OutputStream out = new FileOutputStream(saveFile)){
            byte[] buffer = new byte[1024];
            int readCount = 0;
            while ((readCount = in.read(buffer)) != -1) {
                out.write(buffer,0,readCount);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("------file info end ----");

        boardService.addBoard(board);

        return "redirect:/boards";
    }
}
