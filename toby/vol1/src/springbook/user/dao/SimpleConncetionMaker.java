package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleConncetionMaker {
    public Connection makeNewConnection() throws ClassNotFoundException, SQLException{
        Class.forName("org.mariadb.jdbc.Driver");
        Connection c = DriverManager.getConnection(
                "jdbc:mysql//localhost/springbook", "spring", "book"
        );
        return c;
    }
}
