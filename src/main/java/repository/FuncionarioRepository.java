/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.PreparedStatement;
import model.Funcionario;
import java.sql.*;

/**
 *
 * @author roberts
 */
public class FuncionarioRepository {
    
    public void criarFuncionario(Funcionario funcionario) {
        try {
            ConexaoBD conexao = new ConexaoBD();
            conexao.connectar();
            String sql = "INSERT INTO funcionario(NOME, CPF, SENHA, DATA_NASC, ENDERECO) values(?, ?, ?, ?, ?)";

            PreparedStatement pstmt = conexao.conn.prepareStatement(sql);
            pstmt.setString(1, funcionario.getNome());
            pstmt.setString(2, funcionario.getCpf());
            pstmt.setString(3, funcionario.getSenha());
            pstmt.setString(4, funcionario.getData_nasc());
            pstmt.setString(5, funcionario.getEndereco());
            pstmt.executeUpdate();

            pstmt.close();
            conexao.fecharConexao();
        }
        catch (SQLException e) {
            System.err.print(e);
        }

    }
        
}
    

