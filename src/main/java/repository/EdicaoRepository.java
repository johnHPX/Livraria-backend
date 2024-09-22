package repository;

import model.Edicao;
import util.Util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EdicaoRepository {

    public void criarEdicao(Edicao edicao){
        ConexaoBD conexaoBD = new ConexaoBD();
        Util util = new Util();
        try{
            conexaoBD.connectar();
            String sql = "INSERT INTO edicao (COD, NOME, EDITORA_FK, LIVRO_FK, ANO, QUANTIDADE, IDIOMA, TOTAL_PAG) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conexaoBD.conn.prepareStatement(sql);
            pstmt.setInt(1, util.GerarNumeroAleatorio());
            pstmt.setString(2, edicao.getNome_edicao());
            pstmt.setInt(3, edicao.getEditora_id());
            pstmt.setInt(4, edicao.getLivro_id());
            pstmt.setInt(5, edicao.getAno());
            pstmt.setInt(6, edicao.getQuantidade());
            pstmt.setString(7, edicao.getIdioma());
            pstmt.setInt(8, edicao.getTotal_paginas());
            pstmt.executeUpdate();

            pstmt.close();

        }catch (SQLException e){
            System.err.println(e.getMessage());
        }finally {
            conexaoBD.fecharConexao();
        }
    }

    public ArrayList<Edicao> listarTodasEdicao(){
        ConexaoBD conexaoBD = new ConexaoBD();
        ArrayList<Edicao> edicoes = new ArrayList<Edicao>();
        try{
            conexaoBD.connectar();
            String sql = "SELECT * FROM edicao";
            Statement stmt = conexaoBD.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                Edicao edicao = new Edicao();
                edicao.setCod(rs.getInt("COD"));
                edicao.setNome_edicao(rs.getString("NOME"));
                edicao.setEditora_id(rs.getInt("EDITORA_FK"));
                edicao.setLivro_id(rs.getInt("LIVRO_FK"));
                edicao.setAno(rs.getInt("ANO"));
                edicao.setQuantidade(rs.getInt("QUANTIDADE"));
                edicao.setIdioma(rs.getString("IDIOMA"));
                edicao.setTotal_paginas(rs.getInt("TOTAL_PAG"));
                edicoes.add(edicao);
            }

            rs.close();
            stmt.close();
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }finally {
            conexaoBD.fecharConexao();
        }

        return edicoes;
    }

    public void atualizarEdicao(Edicao edicao){
        ConexaoBD conexaoBD = new ConexaoBD();
        try{
            conexaoBD.connectar();
            String sql = "UPDATE edicao SET NOME = ?, EDITORA_FK = ?, LIVRO_FK = ?, ANO = ?, QUANTIDADE = ?, IDIOMA = ?, TOTAL_PAG = ? WHERE COD = ?";
            PreparedStatement pstmt = conexaoBD.conn.prepareStatement(sql);
            pstmt.setString(1, edicao.getNome_edicao());
            pstmt.setInt(2, edicao.getEditora_id());
            pstmt.setInt(3, edicao.getLivro_id());
            pstmt.setInt(4, edicao.getAno());
            pstmt.setInt(5, edicao.getQuantidade());
            pstmt.setString(6, edicao.getIdioma());
            pstmt.setInt(7, edicao.getTotal_paginas());
            pstmt.setInt(8, edicao.getCod());
            pstmt.executeUpdate();

            pstmt.close();

        }catch (SQLException e){
            System.err.println(e.getMessage());
        }finally {
            conexaoBD.fecharConexao();
        }
    }

    public void removerEdicao(int cod){
        ConexaoBD conexaoBD = new ConexaoBD();
        try{
            conexaoBD.connectar();
            String sql = "DELETE FROM edicao WHERE COD = ?";
            PreparedStatement pstmt = conexaoBD.conn.prepareStatement(sql);
            pstmt.setInt(1, cod);
            pstmt.executeUpdate();

            pstmt.close();

        }catch (SQLException e){
            System.err.println(e.getMessage());
        }finally {
            conexaoBD.fecharConexao();
        }
    }

}
