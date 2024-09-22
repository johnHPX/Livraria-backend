package repository;

import model.Editora;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EditoraRepository {

    public void criarEditora(Editora editora){
        ConexaoBD conexaoBD = new ConexaoBD();
        try{
            conexaoBD.connectar();
            String sql = "INSERT INTO editora (NOME, CNPJ) VALUES (?,?)";
            PreparedStatement pstmt = conexaoBD.conn.prepareStatement(sql);
            pstmt.setString(1, editora.getNome());
            pstmt.setString(2, editora.getCnpj());
            pstmt.executeUpdate();

            pstmt.close();
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }finally {
            conexaoBD.fecharConexao();
        }
    }

    public ArrayList<Editora> listarTodosEditora(){
        ConexaoBD conexaoBD = new ConexaoBD();
        ArrayList<Editora> editoras = new ArrayList<Editora>();
        try{
            conexaoBD.connectar();
            String sql = "SELECT * FROM editora";
            Statement stmt = conexaoBD.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                Editora e = new Editora();
                e.setId(rs.getInt("ID"));
                e.setNome(rs.getString("NOME"));
                e.setCnpj(rs.getString("CNPJ"));
                editoras.add(e);
            }

            rs.close();
            stmt.close();

        }catch (SQLException e){
            System.err.println(e.getMessage());
        }finally {
            conexaoBD.fecharConexao();
        }

        return editoras;
    }


    public void alterarEditora(Editora editora) {
        ConexaoBD conexaoBD = new ConexaoBD();
        try {
            conexaoBD.connectar();
            String sqlText = "UPDATE editora SET NOME = ?, CNPJ = ?  WHERE ID = ?";
            PreparedStatement pstmt = conexaoBD.conn.prepareStatement(sqlText);
            pstmt.setString(1, editora.getNome());
            pstmt.setString(2, editora.getCnpj());
            pstmt.setInt(3, editora.getId());
            pstmt.executeUpdate();

            pstmt.close();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            conexaoBD.fecharConexao();
        }
    }

    public void removerEditora(int id){
        ConexaoBD conexaoDB = new ConexaoBD();
        try{
            conexaoDB.connectar();
            String sql = "DELETE FROM editora WHERE ID = ?";

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
