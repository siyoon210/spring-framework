package com.example.springtransactionpropationtest;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@EnableTransactionManagement
@Configuration
public class Config {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public HikariConfig hikariConfig() {
        return new HikariConfig();
    }

    @Bean
    public DataSource dataSource() {
        return new HikariDataSource(hikariConfig());
    }

    @Bean
    public JpaTransactionManager transactionManager() {
//        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(dataSource());
//        dataSourceTransactionManager.setGlobalRollbackOnParticipationFailure(false);
//        dataSourceTransactionManager.setNestedTransactionAllowed(true);
//        return dataSourceTransactionManager;
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setNestedTransactionAllowed(true);
        return jpaTransactionManager;
    }
}
