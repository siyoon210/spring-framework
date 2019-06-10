package me.siyoon;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ArgumentChecker implements ApplicationRunner {
    @Override
    public void run(final ApplicationArguments args) throws Exception {
        System.out.println("args.getOptionNames().contains(\"foo\") = " + args.getOptionNames().contains("foo"));
        System.out.println("args.getOptionNames().contains(\"bar\") = " + args.getOptionNames().contains("bar"));
    }
}
