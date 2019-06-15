package inflearn.whiteship.springboot.webmvc.exceptionhandler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleExceptionController {

    @GetMapping("/exception-sample")
    public String exceptionSample() {
        throw new SampleException();
    }

    @ExceptionHandler(SampleException.class)
    public @ResponseBody String handleSampleException() {
        return "sample exception~!";
    }
}
