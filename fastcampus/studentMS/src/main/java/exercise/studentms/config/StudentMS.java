package exercise.studentms.config;

import exercise.studentms.MainController;
import exercise.studentms.UI;
import exercise.studentms.dao.DbConfig;
import exercise.studentms.dao.DbUtil;
import exercise.studentms.dao.StudentDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentMS {
    @Bean
    public DbConfig dbConfig() {
        return new DbConfig("jdbc:mariadb://localhost:3306/Test_db",
                "siyoon", "1234", "org.mariadb.jdbc.Driver");
    }

    @Bean
    public DbUtil dbUtil() {
        return new DbUtil();
    }

    @Bean
    public StudentDAO studentDAO() {
        return new StudentDAO(dbConfig());
    }

    @Bean
    public MainController mainController() {
        return new MainController(studentDAO(), ui());
    }

    @Bean
    public UI ui() {
        return new UI();
    }
}
