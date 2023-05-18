package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {
    
    public static Connection getConexao(){
        
        final String URL = "jdbc:mysql://localhost:3306/bd_livraria2?verifyServerCertificate=false&useSSL=true";
        final String USER = "root";
        final String PASSWORD = "123456";

        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
