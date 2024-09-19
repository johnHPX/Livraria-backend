/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.PreparedStatement;
import model.Funcionario;


/**
 *
 * @author roberts
 */
public class funcionarioRepository {
    
    public void criarFuncionario(Funcionario funcionario) {
        
    
    //ConexaoBD.conn.connect();
    String sql = "insert into FUNCIONARIO(nome, cpf, senha, data_nasc, endereco) values(?, ?, ?, ?, ?)";
    boolean ok = true;
    
    
            //PreparedStatement psmt = PreparedStatement(sql);
            //psmt.setString(1, funcionario.getNome());
         
    }
        
}
    

