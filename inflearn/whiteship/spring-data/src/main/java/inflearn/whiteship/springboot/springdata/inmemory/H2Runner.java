package inflearn.whiteship.springboot.springdata.inmemory;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

@Component
public class H2Runner implements ApplicationRunner {
    private DataSource dataSource;


    public H2Runner(final DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void run(final ApplicationArguments args) throws Exception {
        Connection connection = dataSource.getConnection();
        String url = connection.getMetaData().getURL();
        String userName = connection.getMetaData().getUserName();
        String driverName = connection.getMetaData().getDriverName();

        System.out.println("url = " + url);
        System.out.println("userName = " + userName);
        System.out.println("driverName = " + driverName);
    }
}
