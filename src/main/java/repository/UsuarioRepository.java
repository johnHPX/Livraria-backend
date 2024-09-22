package repository;

import model.Usuario;
import util.DatasFormatadas;
import util.Util;

import java.rmi.server.UID;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class UsuarioRepository {

    public void criarUsuario(Usuario novoUsuario){
        Util util = new Util();
        try {
            String sql = "INSERT INTO usuario (NOME, CPF, ENDERECO, DATA_NASC, QTD_LIVROS, ESTA_DEVENDO) VALUES (?,?,?,?,?,?)";
            ConexaoBD conexao = new ConexaoBD();

            conexao.connectar();

            PreparedStatement pstmt = conexao.conn.prepareStatement(sql);
            pstmt.setString(1, novoUsuario.getNome());
            pstmt.setString(2, novoUsuario.getCpf());
            pstmt.setString(3, novoUsuario.getEndereco());

            Date sqlDate = util.ConverterStrintParaDate(novoUsuario.getDataNasc());

            pstmt.setDate(4, sqlDate);
            pstmt.setInt(5, novoUsuario.getQtdLivros());
            pstmt.setBoolean(6, novoUsuario.isDevendo());
            pstmt.executeUpdate();

            pstmt.close();
            conexao.fecharConexao();

        } catch (SQLException e) {
            System.out.println(e);
        } 
    }

    public void criarVariosUsuarios(ArrayList<Usuario> usuarios){
        for (Usuario usuario : usuarios){
            this.criarUsuario(usuario);
        }
    }

    public void alterarUsuario(Usuario usuario) {
        ConexaoBD conexaoBD = new ConexaoBD();
        Util util = new Util();
        try {
            String sqlText = "UPDATE usuario SET NOME = ?, CPF = ?, ENDERECO = ?, DATA_NASC = ?, QTD_LIVROS= ?, ESTA_DEVENDO = ? WHERE ID = ?";
            conexaoBD.connectar();
            PreparedStatement pstmt = conexaoBD.conn.prepareStatement(sqlText);
            pstmt.setInt(7, usuario.getId());
            pstmt.setString(1, usuario.getNome());
            pstmt.setString(2, usuario.getCpf());
            pstmt.setString(3, usuario.getEndereco());

            Date sqlDate = util.ConverterStrintParaDate(usuario.getDataNasc());

            pstmt.setDate(4, sqlDate);
            pstmt.setInt(5, usuario.getQtdLivros());
            pstmt.setBoolean(6, usuario.isDevendo());
            pstmt.executeUpdate();

            pstmt.close();

        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            conexaoBD.fecharConexao();
        }

    }

    public void removerUsuario(int id){
        ConexaoBD conexaoDB = new ConexaoBD();
        try{
            String sql = "DELETE FROM usuario WHERE ID = ?";
            conexaoDB.connectar();

            PreparedStatement pstmt = conexaoDB.conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

            pstmt.close();
        }catch (SQLException e){
            System.err.println(e);
        }finally {
            conexaoDB.fecharConexao();
        }
    }

    public ArrayList<Usuario> listarTodosUsuario(){
        ConexaoBD conexaoBD = new ConexaoBD();
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        Util util = new Util();
        try {
            String sql = "SELECT * FROM usuario";
            conexaoBD.connectar();

            Statement stmt =  conexaoBD.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("ID"));
                u.setNome(rs.getString("NOME"));
                u.setCpf(rs.getString("CPF"));
                u.setEndereco(rs.getString("ENDERECO"));

                String dataNasc = util.ConverterDateParaString(rs.getDate("DATA_NASC"));

                u.setDataNasc(dataNasc);
                u.setQtdLivros(rs.getInt("QTD_LIVROS"));
                u.setDevendo(rs.getBoolean("ESTA_DEVENDO"));
                usuarios.add(u);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.err.println(e);
        }finally {
            conexaoBD.fecharConexao();
        }
        return usuarios;
    }

}
