package project.ffboard.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import project.ffboard.config.DBConfig;

@Configuration
//@ComponentScan(basePackages = { "project.ffboard.dao", "project.ffboard.service"})
@Import({ DBConfig.class})
public class ApplicationConfig {

}