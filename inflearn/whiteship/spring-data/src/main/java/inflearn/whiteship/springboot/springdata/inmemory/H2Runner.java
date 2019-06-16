package inflearn.whiteship.springboot.springdata.inmemory;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@Component
public class H2Runner implements ApplicationRunner {
    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    public H2Runner(final DataSource dataSource, final JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(final ApplicationArguments args) throws Exception {
        try (Connection connection = dataSource.getConnection()) {
            String url = connection.getMetaData().getURL();
            String userName = connection.getMetaData().getUserName();
            String driverName = connection.getMetaData().getDriverName();

            System.out.println("url = " + url);
            System.out.println("userName = " + userName);
            System.out.println("driverName = " + driverName);


            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE USER (ID INTEGER NOT NULL, name VARCHAR(255), PRIMARY KEY (id))";
            statement.executeLargeUpdate(sql);
        }

        //jdbcTemplate을 사용하면 위의 코드를 아래와 같이 한줄로 표시하고 정확한 에러 메시지도 확인할 수 있다.
        jdbcTemplate.execute("INSERT INTO USER VALUES (1, 'siyoon')");
    }
}
