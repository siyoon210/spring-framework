package me.siyoon;

import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
public class ArgumentChecker {
    //빈의 생성자가 한개이고, 매개변수로 되어있는 것이 빈이라면 자동으로 주입해준다.
    public ArgumentChecker(ApplicationArguments arguments) {
        System.out.println("arguments.containsOption(\"foo\") = " + arguments.containsOption("foo"));
        System.out.println("arguments.containsOption(\"bar\") = " + arguments.containsOption("bar"));
    }
}
