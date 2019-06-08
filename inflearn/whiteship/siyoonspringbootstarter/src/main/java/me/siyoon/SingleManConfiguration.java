package me.siyoon;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SingleManConfiguration {
    @Bean
    public SingleMan singleMan() {
        SingleMan singleMan = new SingleMan();
        singleMan.setName("siyoon");
        singleMan.setHowLongDays(70);
        return singleMan;
    }
}
