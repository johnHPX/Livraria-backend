package repository;
import model.Livro;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LivroRepository {

    public void criarLivro(Livro livro){
        ConexaoBD conexaoBD = new ConexaoBD();
        try{
            conexaoBD.connectar();
            String sql = "INSERT INTO livro (NOME, GENERO, DESCRICAO) VALUES (?,?,?)";
            PreparedStatement pstmt = conexaoBD.conn.prepareStatement(sql);
            pstmt.setString(1, livro.getNome());
            pstmt.setString(2, livro.getGenero());
            pstmt.setString(3, livro.getDescricao());
            pstmt.executeUpdate();

            pstmt.close();
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }finally {
            conexaoBD.fecharConexao();
        }
    }

    public ArrayList<Livro> listarTodosLivros(){
        ConexaoBD conexaoBD = new ConexaoBD();
        ArrayList<Livro> livros = new ArrayList<Livro>();
        try{
            conexaoBD.connectar();
            String sql = "SELECT * FROM livro";
            Statement stmt = conexaoBD.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                Livro l = new Livro();
                l.setId(rs.getInt("ID"));
                l.setNome(rs.getString("NOME"));
                l.setGenero(rs.getString("GENERO"));
                l.setDescricao(rs.getString("DESCRICAO"));
                livros.add(l);
            }

            rs.close();
            stmt.close();

        }catch (SQLException e){
            System.err.println(e.getMessage());
        }finally {
            conexaoBD.fecharConexao();
        }

        return livros;
    }


    public void alterarLivro(Livro livro) {
        ConexaoBD conexaoBD = new ConexaoBD();
        try {
            conexaoBD.connectar();
            String sqlText = "UPDATE livro SET NOME = ?, GENERO = ?, DESCRICAO = ? WHERE ID = ?";
            PreparedStatement pstmt = conexaoBD.conn.prepareStatement(sqlText);
            pstmt.setString(1, livro.getNome());
            pstmt.setString(2, livro.getGenero());
            pstmt.setString(3, livro.getDescricao());
            pstmt.setInt(4, livro.getId());
            pstmt.executeUpdate();

            pstmt.close();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            conexaoBD.fecharConexao();
        }
    }

    public void removerLivro(int id){
        ConexaoBD conexaoDB = new ConexaoBD();
        try{
            conexaoDB.connectar();
            String sql = "DELETE FROM livro WHERE ID = ?";

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
