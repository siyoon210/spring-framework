package exercise.studentms.dao;

import java.sql.*;

public class DbUtil {
    public static Connection connect(DbConfig dbConfig)
            throws RuntimeException {

        Connection conn = null;
        try {
            Class.forName(dbConfig.getDbDriver());
            conn = DriverManager.getConnection(dbConfig.getDbUrl(), dbConfig.getDbId(), dbConfig.getDbPassword());
        }catch (Exception ex) {
            throw new RuntimeException();
        }
        return conn;
    } // connect


    // insert, update, delete 사용시에 이 close() 사용.
    // select 만 ResultSet 이 필요하기 때문에. 다른 close() 사용.
    public static void close(Connection conn, PreparedStatement ps) {
        if(ps != null) {
            try {
                ps.close();
            }catch(SQLException e) {
            }
        }

        if(conn != null) {
            try {
                conn.close();
            }catch (SQLException e) {
            }
        }

    } // close

    public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        if(rs != null) {
            try {
                rs.close();
            }catch(SQLException e) {}
        }
        close(conn,ps);
    }
}