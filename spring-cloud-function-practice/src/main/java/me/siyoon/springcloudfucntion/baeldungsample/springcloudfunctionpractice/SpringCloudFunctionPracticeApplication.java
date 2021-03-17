package me.siyoon.springcloudfucntion.baeldungsample.springcloudfunctionpractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

/**
 * 예제
 * https://www.baeldung.com/spring-cloud-function
 */
@SpringBootApplication
public class SpringCloudFunctionPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudFunctionPracticeApplication.class, args);
    }

    @Bean
    public Function<String, String> reverseString() {
        return value -> new StringBuilder(value).reverse().toString();
    }
}
