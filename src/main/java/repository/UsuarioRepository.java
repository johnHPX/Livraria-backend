package repository;

import model.Usuario;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.sql.Date;


public class UsuarioRepository {

    public void criarUsuario(Usuario novoUsuario){
        try {
            String sql = "INSERT INTO usuario (NOME, CPF, ENDERECO, DATA_NASC, QTD_LIVROS, ESTA_DEVENDO) VALUES (?,?,?,?,?,?)";
            ConexaoBD conexao = new ConexaoBD();

            conexao.connectar();

            PreparedStatement pstmt = conexao.conn.prepareStatement(sql);
            pstmt.setString(1, novoUsuario.getNome());
            pstmt.setString(2, novoUsuario.getCpf());
            pstmt.setString(3, novoUsuario.getEndereço());

            // Conveting string to Date
            LocalDate localDate = LocalDate.parse(novoUsuario.getDataNasc(), DateTimeFormatter.ofPattern("yyyy/MM/dd"));
            Date sqlDate = Date.valueOf(localDate);

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


}
