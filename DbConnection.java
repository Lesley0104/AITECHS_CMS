
package aitechs_cms_copy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DbConnection {
    public static Connection getConnection() throws SQLException{
    String url = "jdbc:mysql://localhost:3306/aitechs_cms_db";
    String user = "root";
    String password = "";
    
    return DriverManager.getConnection(url, user, password);
    }

    static PreparedStatement prepareStatement(String query) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
