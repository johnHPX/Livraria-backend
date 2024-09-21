package repository;

import model.Autor;
import util.DatasFormatadas;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class AutorRepository {

    DatasFormatadas dataUSA = DatasFormatadas.PADRAO_USA;

    public void criarAutor(Autor autor) {
        ConexaoBD conexao = new ConexaoBD();
        try {
            conexao.connectar();
            String sql = "INSERT INTO autor(NOME, BIO, ANO_NASC) values(?, ?, ?)";

            PreparedStatement pstmt = conexao.conn.prepareStatement(sql);
            pstmt.setString(1,autor.getNome());
            pstmt.setString(2, autor.getBio());
            pstmt.setInt(3, autor.getAno_nasc());
            pstmt.executeUpdate();

            pstmt.close();
        }
        catch (SQLException e) {
            System.err.print(e.getMessage());
        }finally {
            conexao.fecharConexao();
        }

    }

    public ArrayList<Autor> listarTodosAutor(){
        ConexaoBD conexaoBD = new ConexaoBD();
        ArrayList<Autor> autores = new ArrayList<Autor>();
        try{
            conexaoBD.connectar();
            String sql = "SELECT * FROM autor";
            Statement stmt = conexaoBD.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Autor a = new Autor();
                a.setId(rs.getInt("ID"));
                a.setNome(rs.getString("NOME"));
                a.setBio(rs.getString("BIO"));
                a.setAno_nasc(rs.getInt("ANO_NASC"));
                autores.add(a);
            }

            rs.close();
            stmt.close();

        }catch (SQLException e){
            System.err.println(e.getMessage());
        }finally {
            conexaoBD.fecharConexao();
        }
        return autores;
    }

//    public void alterarFuncionario(Funcionario funcionario) {
//        ConexaoBD conexaoBD = new ConexaoBD();
//        try {
//            String sqlText = "UPDATE funcionario SET NOME = ?, CPF = ?, SENHA = ?, ENDERECO = ?, DATA_NASC = ? WHERE ID = ?";
//            conexaoBD.connectar();
//            PreparedStatement pstmt = conexaoBD.conn.prepareStatement(sqlText);
//            pstmt.setInt(6, funcionario.getId());
//            pstmt.setString(1, funcionario.getNome());
//            pstmt.setString(2, funcionario.getCpf());
//            pstmt.setString(3, funcionario.getSenha());
//            pstmt.setString(4, funcionario.getEndereco());
//
//            // Conveting string to Date
//            LocalDate localDate = LocalDate.parse(funcionario.getData_nasc(), DateTimeFormatter.ofPattern(dataUSA.getValor()));
//            Date sqlDate = Date.valueOf(localDate);
//
//            pstmt.setDate(5, sqlDate);
//            pstmt.executeUpdate();
//
//            pstmt.close();
//
//        } catch (SQLException e) {
//            System.err.println(e.getMessage());
//        } finally {
//            conexaoBD.fecharConexao();
//        }
//    }
//
//    public void removerFuncionario(int id){
//        ConexaoBD conexaoDB = new ConexaoBD();
//        try{
//            String sql = "DELETE FROM funcionario WHERE ID = ?";
//            conexaoDB.connectar();
//
//            PreparedStatement pstmt = conexaoDB.conn.prepareStatement(sql);
//            pstmt.setInt(1, id);
//            pstmt.executeUpdate();
//
//            pstmt.close();
//        }catch (SQLException e){
//            System.err.println(e.getMessage());
//        }finally {
//            conexaoDB.fecharConexao();
//        }
//    }

}
