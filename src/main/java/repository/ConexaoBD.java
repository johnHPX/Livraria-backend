package repository;

import util.TratamentoException;
import util.TratarErros;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoBD {

    public Connection conn;

    public void connectar() throws TratamentoException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/biblioteca";
            conn = DriverManager.getConnection(url, "root", "123456");
        } catch (ClassNotFoundException | SQLException e) {
            TratarErros.tratamentoDeErroBancoDeDados(e);
        }
    }

    public void fecharConexao() throws TratamentoException {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }

        } catch (SQLException e) {
            TratarErros.tratamentoDeErroBancoDeDados(e);
        }
    }

}