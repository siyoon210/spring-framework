package project.ffboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import project.ffboard.service.ArticleService;

@Controller
public class MainController {
    ArticleService articleService;

    public MainController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @RequestMapping("/")
    public String main(Model model) {
        getCategoryList(model); //게시판 네비게이션 목록을 위한 카테고리 목록 가져오기

        model.addAttribute("articleListNew",articleService.getArticleList("regdate", 0));
        model.addAttribute("articleListHit",articleService.getArticleList("hit", 0));
        return "index";
    }

    //게시판 네비게이션 카테고리 목록 자겨오기
    public void getCategoryList(Model model) {
        model.addAttribute("categoryList", articleService.getCategoryList());
    }
}

