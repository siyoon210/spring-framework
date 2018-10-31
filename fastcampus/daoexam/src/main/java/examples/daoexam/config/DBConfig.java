package examples.daoexam.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@EnableTransactionManagement
public class DBConfig {
    private String driverClassName = "org.mariadb.jdbc.Driver";
    private String url = "jdbc:mariadb://localhost:3306/Test_db";
    private String username = "siyoon";
    private String password = "1234";

//    @Bean
//    public DataSource dataSource() {
//        BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setDriverClassName(driverClassName);
//        dataSource.setUrl(url);
//        dataSource.setUsername(username);
//        dataSource.setPassword(password);
//        DatabasePopulatorUtils.execute(createDatabasePopulator(), dataSource);
//        return dataSource;
//    }
//
//    private DatabasePopulator createDatabasePopulator() {
//        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
//        databasePopulator.setContinueOnError(true);
//        databasePopulator.addScript(new ClassPathResource("schema.sql"));
//        return databasePopulator;
//    }
//
    
//    @Bean
//    public PlatformTransactionManager transactionManger(DataSource ds) {
//        return new DataSourceTransactionManager(ds);
//    }
}