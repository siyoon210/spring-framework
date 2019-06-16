package inflearn.whiteship.springboot.springdata.mysql;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@Component
public class MySQLRunner implements ApplicationRunner {
    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    public MySQLRunner(final DataSource dataSource, final JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(final ApplicationArguments args) throws Exception {
        try (Connection connection = dataSource.getConnection()) {
            final String url = connection.getMetaData().getURL();
            final String driverName = connection.getMetaData().getDriverName();
            System.out.println("url = " + url);
            System.out.println("driverName = " + driverName);

            final Statement statement = connection.createStatement();
            final String sql = "CREATE TABLE USER (ID INTEGER NOT NULL, name VARCHAR(255), PRIMARY KEY (id))";
            statement.execute(sql);
        }

        jdbcTemplate.execute("INSERT INTO USER VALUES (1, 'siyoon')");
    }
}
