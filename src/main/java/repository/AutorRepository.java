package repository;

import model.Autor;
import util.TratamentoException;
import util.TratarErros;

import java.sql.*;
import java.util.ArrayList;

public class AutorRepository {

    public void criarAutor(Autor autor) throws TratamentoException {
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
            TratarErros.tratamentoDeErroBancoDeDados(e);
        }finally {
            conexao.fecharConexao();
        }

    }

    public ArrayList<Autor> listarTodosAutor() throws TratamentoException {
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
            TratarErros.tratamentoDeErroBancoDeDados(e);
        }finally {
            conexaoBD.fecharConexao();
        }
        return autores;
    }

    public void alterarAutor(Autor autor) throws TratamentoException {
        ConexaoBD conexaoBD = new ConexaoBD();
        try {
            String sqlText = "UPDATE autor SET NOME = ?, BIO = ?, ANO_NASC = ? WHERE ID = ?";
            conexaoBD.connectar();
            PreparedStatement pstmt = conexaoBD.conn.prepareStatement(sqlText);
            pstmt.setInt(4, autor.getId());
            pstmt.setString(1, autor.getNome());
            pstmt.setString(2, autor.getBio());
            pstmt.setInt(3, autor.getAno_nasc());
            pstmt.executeUpdate();

            pstmt.close();

        } catch (SQLException e) {
            TratarErros.tratamentoDeErroBancoDeDados(e);
        } finally {
            conexaoBD.fecharConexao();
        }
    }

    public void removerAutor(int id) throws TratamentoException {
        ConexaoBD conexaoDB = new ConexaoBD();
        try{
            String sql = "DELETE FROM autor WHERE ID = ?";
            conexaoDB.connectar();

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
