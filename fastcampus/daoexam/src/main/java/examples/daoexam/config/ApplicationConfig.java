package examples.daoexam.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = { "examples.daoexam.dao",
        "examples.daoexam.service"})
@Import({ DBConfig.class})
public class ApplicationConfig {

}