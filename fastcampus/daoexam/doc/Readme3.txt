Spring JUnit Test

1. pom.xml 파일에 다음을 추가

		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-test</artifactId>
			<version>${spring.version}</version>
		</dependency>

        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>

2. DataSource부분을 다음과 같이 수정

DataSource객체가 만들어지고 자동으로 schema.sql 을 실행한다.

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        DatabasePopulatorUtils.execute(createDatabasePopulator(), dataSource);
        return dataSource;
    }

    private DatabasePopulator createDatabasePopulator() {
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
        databasePopulator.setContinueOnError(true);
        databasePopulator.addScript(new ClassPathResource("schema.sql"));
        return databasePopulator;
    }

3. Test 클래스를 작성

Controller --> Service --> Dao

Service의 메소드를 테스트.

* 단위 테스트가 무엇이지?
* 통합 테스트가 무엇인지?
* JUnit 이 무엇이지?
* Mock 이 무엇이지?
* 값의 검증은 어떻게 할까?

test/java/ 패키지명 / 클래스를 작성


@RunWith 는 JUnit 이 제공하는 애노테이션인데, 확장점을 제공한다.

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
위의 2줄은 스프링이 JUnit의 기능을 확장하여 ApplicationConfig.class를
읽어들여 내부적으로 ApplicationContext를 생성한다.


package examples.daoexam.dao;

import examples.daoexam.config.ApplicationConfig;
import examples.daoexam.config.DBConfig;
import examples.daoexam.dto.Board;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class BoardDaoTest {

    @Test
    public void init(){

    }

}
