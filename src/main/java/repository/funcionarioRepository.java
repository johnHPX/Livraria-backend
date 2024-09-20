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
public class funcionarioRepository {
    
    public void criarFuncionario(Funcionario funcionario) {
    try {    
        ConexaoBD conexao = new ConexaoBD();
        conexao.connectar();
        String sql = "insert into FUNCIONARIO(nome, cpf, seSQnha, data_nasc, endereco) values(?, ?, ?, ?, ?)";
        
        
       PreparedStatement pstmt = conexao.conn.PrepareStatement(sql);
       pstmt.setString(1, funcionario.getNome());
       pstmt.setString(2, funcionario.getCpf());
       pstmt.setString(3, funcionario.getSenha());
       pstmt.setString(4, funcionario.getData_nasc());
       pstmt.setString(5, funcionario.getEndereco());
       pstmt.executeUpdate();
    }       
    catch (SQLException e) {
        System.out.print(e);
    }
    
    
          
         
    }
        
}
    

