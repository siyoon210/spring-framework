package project.ffboard.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class DBConfig {
    private String driverClassName = "org.mariadb.jdbc.Driver";
    private String url = "jdbc:mariadb://localhost:3306/Test_db";
    private String username = "siyoon";
    private String password = "1234";

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }


    @Bean
    public PlatformTransactionManager transactionManger(DataSource ds) {
        return new DataSourceTransactionManager(ds);
    }
}
