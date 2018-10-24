package examples.daoexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
public class MainController {

    public MainController(){
        System.out.println("MainController()!");
    }

    // http://localhost:8080
    @RequestMapping("/")
    public String main(){
        return "index"; // view name을 리턴, /WEB-INF/views/index.jsp로 forward
    }
}
