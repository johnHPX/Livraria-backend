package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoBD {

    public static Connection conn;

    public static void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/biblioteca";
            conn = DriverManager.getConnection(url, "root", "Roberts2004@");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC não encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco de dados: " + e.getMessage());
        }
        finally {
        System.out.println("SUCESSO                ");
    }
    }

    public static boolean closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                return true;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao fechar a conexão: " + e.getMessage());
        }

        return false;
    }

}