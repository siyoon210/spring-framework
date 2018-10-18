package exercise.studentms.dao;

import exercise.studentms.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private DbConfig dbConfig;

    public StudentDAO(DbConfig dbConfig) {
        this.dbConfig = dbConfig;
    }

    public int addStudent(Student student) {
        int count=0;
        Connection conn = DbUtil.connect(dbConfig);
        String sql = "INSERT INTO student(name, math, english, language) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, student.getName());
            ps.setInt(2, student.getMath());
            ps.setInt(3, student.getEng());
            ps.setInt(4, student.getLang());

            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(conn, ps);
        }
        return count;
    }

    public List<Student> getStudentList() {
        List<Student> studentList = new ArrayList<>();
        Connection conn = DbUtil.connect(dbConfig);
        String sql = "SELECT name,math,english,language FROM student";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString(1);
                int math = rs.getInt(2);
                int eng = rs.getInt(3);
                int lang = rs.getInt(4);

                Student student = new Student(name,math,eng,lang);
                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(conn,ps,rs);
        }

        return studentList;
    }
}
