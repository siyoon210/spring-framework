package me.siyoon.springbootawslambdatest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

/**
 * 예제 참고 : https://www.baeldung.com/spring-cloud-function
 */
@SpringBootApplication
public class SpringbootAwsLambdaTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAwsLambdaTestApplication.class, args);
    }

    @Bean
    public Function<String, String> reverseString() {
        return value -> new StringBuilder(value).reverse().toString();
    }

}
