package repository;

import model.Edicao;
import model.Locacao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;

import util.Util;

public class LocacaoRepository {

    public void criarLocacao(Locacao locacao){
        ConexaoBD conexaoBD = new ConexaoBD();
        try{
            conexaoBD.connectar();
            String sql = "INSERT INTO locacao (USUARIO_FK, FUNCIONARIO_FK, EDICAO_COD, PRAZO, DATA_LOCACAO, ANO, ABERTA) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conexaoBD.conn.prepareStatement(sql);
            pstmt.setInt(1, locacao.getUsuario_id());
            pstmt.setInt(2, locacao.getFuncionario_id());
            pstmt.setInt(3, locacao.getEdicao_cod());

            Date prazo = Util.ConverterStrintParaDate(locacao.getPrazo());
            pstmt.setDate(4, prazo);

            Date dataLocacao = Util.ConverterStrintParaDate(locacao.getData_locacao());
            pstmt.setDate(5, dataLocacao);


            pstmt.setInt(6, locacao.getAno());
            pstmt.setBoolean(7, locacao.isAberta());
            pstmt.executeUpdate();

            pstmt.close();

        }catch (SQLException e){
            System.err.println(e.getMessage());
        }finally {
            conexaoBD.fecharConexao();
        }
    }

    public ArrayList<Locacao> listarTodasLocacoes(){
        ConexaoBD conexaoBD = new ConexaoBD();
        ArrayList<Locacao> locacoes = new ArrayList<Locacao>();
        try{
            conexaoBD.connectar();
            String sql = "SELECT * FROM locacao";
            Statement stmt = conexaoBD.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                Locacao locacao = new Locacao();
                locacao.setId(rs.getInt("ID"));
                locacao.setUsuario_id(rs.getInt("USUARIO_FK"));
                locacao.setFuncionario_id(rs.getInt("FUNCIONARIO_FK"));
                locacao.setEdicao_cod(rs.getInt("EDICAO_COD"));

                String prazo = Util.ConverterDateParaString(rs.getDate("PRAZO"));
                locacao.setPrazo(prazo);

                String dataLocacao = Util.ConverterDateParaString(rs.getDate("DATA_LOCACAO"));
                locacao.setData_locacao(dataLocacao);

                locacao.setAno(rs.getInt("ANO"));
                locacao.setAberta(rs.getBoolean("ABERTA"));
                locacoes.add(locacao);
            }

            rs.close();
            stmt.close();
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }finally {
            conexaoBD.fecharConexao();
        }

        return locacoes;
    }

    public void atualizarLocacao(Locacao locacao){
        ConexaoBD conexaoBD = new ConexaoBD();
        try{
            conexaoBD.connectar();
            String sql = "UPDATE locacao SET USUARIO_FK = ?, FUNCIONARIO_FK = ?, EDICAO_COD = ?, PRAZO = ?, DATA_LOCACAO = ?, ANO = ?, ABERTA = ? WHERE ID = ?";
            PreparedStatement pstmt = conexaoBD.conn.prepareStatement(sql);
            pstmt.setInt(1, locacao.getUsuario_id());
            pstmt.setInt(2, locacao.getFuncionario_id());
            pstmt.setInt(3, locacao.getEdicao_cod());

            Date prazo = Util.ConverterStrintParaDate(locacao.getPrazo());
            pstmt.setDate(4, prazo);

            Date dataLocacao = Util.ConverterStrintParaDate(locacao.getData_locacao());
            pstmt.setDate(5, dataLocacao);


            pstmt.setInt(6, locacao.getAno());
            pstmt.setBoolean(7, locacao.isAberta());
            pstmt.setInt(8, locacao.getId());
            pstmt.executeUpdate();

            pstmt.close();

        }catch (SQLException e){
            System.err.println(e.getMessage());
        }finally {
            conexaoBD.fecharConexao();
        }
    }

    public void removerLocacao(int id){
        ConexaoBD conexaoBD = new ConexaoBD();
        try{
            conexaoBD.connectar();
            String sql = "DELETE FROM locacao WHERE ID = ?";
            PreparedStatement pstmt = conexaoBD.conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

            pstmt.close();

        }catch (SQLException e){
            System.err.println(e.getMessage());
        }finally {
            conexaoBD.fecharConexao();
        }
    }

}
