package repository;
import model.LivroAutor;
import util.TratamentoException;
import util.TratarErros;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LivroAutorRepository {

    public void criarLivroAutor(LivroAutor livroAutor) throws TratamentoException {
        ConexaoBD conexaoBD = new ConexaoBD();
        try{
            conexaoBD.connectar();
            String sql = "INSERT INTO livro_autor (LIVRO_FK, AUTOR_FK) VALUES (?,?)";
            PreparedStatement pstmt = conexaoBD.conn.prepareStatement(sql);
            pstmt.setInt(1, livroAutor.getLivro_id());
            pstmt.setInt(2, livroAutor.getAutor_id());
            pstmt.executeUpdate();

            pstmt.close();
        }catch (SQLException e){
            TratarErros.tratamentoDeErroBancoDeDados(e);
        }finally {
            conexaoBD.fecharConexao();
        }
    }

    public ArrayList<LivroAutor> listarTodosLivroAutor() throws TratamentoException {
        ConexaoBD conexaoBD = new ConexaoBD();
        ArrayList<LivroAutor> array = new ArrayList<LivroAutor>();
        try{
            conexaoBD.connectar();
            String sql = "SELECT * FROM livro_autor";
            Statement stmt = conexaoBD.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                LivroAutor la = new LivroAutor();
                la.setId(rs.getInt("ID"));
                la.setLivro_id(rs.getInt("LIVRO_FK"));
                la.setAutor_id((rs.getInt("AUTOR_FK")));
                array.add(la);
            }

            rs.close();
            stmt.close();

        }catch (SQLException e){
            TratarErros.tratamentoDeErroBancoDeDados(e);
        }finally {
            conexaoBD.fecharConexao();
        }

        return array;
    }


    public void alterarLivroAutor(LivroAutor livroAutor) throws TratamentoException {
        ConexaoBD conexaoBD = new ConexaoBD();
        try {
            conexaoBD.connectar();
            String sqlText = "UPDATE livro_autor SET LIVRO_FK = ?, AUTOR_FK = ? WHERE ID = ?";
            PreparedStatement pstmt = conexaoBD.conn.prepareStatement(sqlText);
            pstmt.setInt(1, livroAutor.getLivro_id());
            pstmt.setInt(2, livroAutor.getAutor_id());
            pstmt.setInt(3, livroAutor.getId());
            pstmt.executeUpdate();

            pstmt.close();

        } catch (SQLException e) {
            TratarErros.tratamentoDeErroBancoDeDados(e);
        } finally {
            conexaoBD.fecharConexao();
        }
    }

    public void removerLivroAutor(int id) throws TratamentoException {
        ConexaoBD conexaoDB = new ConexaoBD();
        try{
            conexaoDB.connectar();
            String sql = "DELETE FROM livro_autor WHERE ID = ?";

            PreparedStatement pstmt = conexaoDB.conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

            pstmt.close();
        }catch (SQLException e){
            TratarErros.tratamentoDeErroBancoDeDados(e);
        }finally {
            conexaoDB.fecharConexao();
        }
    }

}
