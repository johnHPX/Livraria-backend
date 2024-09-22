/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.PreparedStatement;
import model.Funcionario;
import util.Util;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author roberts
 */
public class FuncionarioRepository {

    
    public void criarFuncionario(Funcionario funcionario) {
        Util util = new Util();
        try {
            ConexaoBD conexao = new ConexaoBD();
            conexao.connectar();
            String sql = "INSERT INTO funcionario(NOME, CPF, SENHA, DATA_NASC, ENDERECO) values(?, ?, ?, ?, ?)";

            PreparedStatement pstmt = conexao.conn.prepareStatement(sql);
            pstmt.setString(1, funcionario.getNome());
            pstmt.setString(2, funcionario.getCpf());
            pstmt.setString(3, funcionario.getSenha());

            Date sqlDate = util.ConverterStrintParaDate(funcionario.getDataNasc());

            pstmt.setDate(4, sqlDate);
            pstmt.setString(5, funcionario.getEndereco());
            pstmt.executeUpdate();

            pstmt.close();
            conexao.fecharConexao();
        }
        catch (SQLException e) {
            System.err.print(e.getMessage());
        }

    }

    public ArrayList<Funcionario> listarTodosFuncionarios(){
        ConexaoBD conexaoBD = new ConexaoBD();
        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
        Util util = new Util();
        try{
            conexaoBD.connectar();
            String sql = "SELECT * FROM funcionario";
            Statement stmt = conexaoBD.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Funcionario f = new Funcionario();
                f.setId(rs.getInt("ID"));
                f.setNome(rs.getString("NOME"));
                f.setCpf(rs.getString("CPF"));
                f.setSenha(rs.getString("SENHA"));

                String dataNasc = util.ConverterDateParaString(rs.getDate("DATA_NASC"));

                f.setDataNasc(dataNasc);
                f.setEndereco(rs.getString("ENDERECO"));
                funcionarios.add(f);
            }

            rs.close();
            stmt.close();

        }catch (SQLException e){
            System.err.println(e.getMessage());
        }finally {
            conexaoBD.fecharConexao();
        }
        return funcionarios;
    }

    public void alterarFuncionario(Funcionario funcionario) {
        ConexaoBD conexaoBD = new ConexaoBD();
        Util util = new Util();
        try {
            String sqlText = "UPDATE funcionario SET NOME = ?, CPF = ?, SENHA = ?, ENDERECO = ?, DATA_NASC = ? WHERE ID = ?";
            conexaoBD.connectar();
            PreparedStatement pstmt = conexaoBD.conn.prepareStatement(sqlText);
            pstmt.setInt(6, funcionario.getId());
            pstmt.setString(1, funcionario.getNome());
            pstmt.setString(2, funcionario.getCpf());
            pstmt.setString(3, funcionario.getSenha());
            pstmt.setString(4, funcionario.getEndereco());

            Date sqlDate = util.ConverterStrintParaDate(funcionario.getDataNasc());

            pstmt.setDate(5, sqlDate);
            pstmt.executeUpdate();

            pstmt.close();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            conexaoBD.fecharConexao();
        }
    }

    public void removerFuncionario(int id){
        ConexaoBD conexaoDB = new ConexaoBD();
        try{
            String sql = "DELETE FROM funcionario WHERE ID = ?";
            conexaoDB.connectar();

            PreparedStatement pstmt = conexaoDB.conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

            pstmt.close();
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }finally {
            conexaoDB.fecharConexao();
        }
    }
        
}
    

