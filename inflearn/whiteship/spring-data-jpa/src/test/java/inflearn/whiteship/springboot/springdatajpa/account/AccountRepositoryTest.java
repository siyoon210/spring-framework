package inflearn.whiteship.springboot.springdatajpa.account;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void getConnectionInfo() throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            final DatabaseMetaData metaData = connection.getMetaData();
            System.out.println("metaData.getURL() = " + metaData.getURL());
            System.out.println("metaData.getUserName() = " + metaData.getUserName());
            System.out.println("metaData.getDriverName() = " + metaData.getDriverName());
        }
    }

    @Test
    public void di() {
        Account account1 = new Account();
        account1.setUsername("siyoon");
        account1.setPassword("1234");

        final Account account2 = accountRepository.save(account1);
        assertThat(account2).isNotNull();

        final Account account3 = accountRepository.findByUsername("siyoon");
        assertThat(account3).isNotNull();

        final Account account4 = accountRepository.findByUsername("puru");
        assertThat(account4).isNull();
    }

}