package me.siyoon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.setBanner((environment, sourceClass, out) -> System.out.println("뚜비두밤~"));
        springApplication.run(args);
    }
}
