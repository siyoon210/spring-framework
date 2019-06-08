package me.siyoon;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(SingleManProperties.class)
public class SingleManConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public SingleMan singleMan(SingleManProperties properties) {
        SingleMan singleMan = new SingleMan();
        singleMan.setName(properties.getName());
        singleMan.setHowLongDays(properties.getHowLongDays());
        return singleMan;
    }
}
