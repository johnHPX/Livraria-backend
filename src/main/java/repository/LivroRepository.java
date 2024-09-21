package repository;

import model.Livro;

import java.sql.PreparedStatement;
import java.sql.SQLException;

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

}
