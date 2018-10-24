package examples.daoexam.main;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import examples.daoexam.config.ApplicationConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DataSourceTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		DataSource ds = ac.getBean(DataSource.class);
		Connection conn = null;
		try {
			conn = ds.getConnection();
			if(conn != null)
				System.out.println("db 접속 성공!");
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(conn != null) {
				try {
					conn.close(); // 커넥션을 되돌려준다.
				} catch (SQLException e) {
				}
			}
		} // finally
		
	}
}
// end
