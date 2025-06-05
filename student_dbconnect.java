package aitechs_cms_copy;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class student_dbconnect {

    static Connection connection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    static student getStudentByEmail(String userEmail) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private final Connection connection;

    public student_dbconnect() throws SQLException {
        connection = DbConnection.getConnection();
    }

    // Insert student
    public int insertStudent(student students) throws SQLException {
        String sql = "INSERT INTO students (email, password, student_num, student_name, year_lvl, block, mobile_num, address, clearances) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, students.getEmail());
            stmt.setString(2, students.getPassword());
            stmt.setString(3, students.getStudentNo());
             stmt.setString(4, students.getName());
              stmt.setString(5, students.getYearLevel());
               stmt.setString(6, students.getBlock());
                stmt.setString(7, students.getMobile());
                 stmt.setString(8, students.getAddress());
                  stmt.setString(9, students.getClearance());
             
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    // Check if email already exists
    public boolean emailExists(String email) throws SQLException {
        String sql = "SELECT COUNT(*) FROM students WHERE email = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false;
    }
}
