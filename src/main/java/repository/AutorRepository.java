//package repository;
//
//import model.Autor;
//import model.Funcionario;
//import util.DatasFormatadas;
//
//import java.sql.*;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//
//public class AutorRepository {
//
//    DatasFormatadas dataUSA = DatasFormatadas.PADRAO_USA;
//
//    public void criarAutor(Autor autor) {
//        try {
//            ConexaoBD conexao = new ConexaoBD();
//            conexao.connectar();
//            String sql = "INSERT INTO autor(NOME, CPF, SENHA, DATA_NASC, ENDERECO) values(?, ?, ?, ?, ?)";
//
//            PreparedStatement pstmt = conexao.conn.prepareStatement(sql);
//            pstmt.setString(1, funcionario.getNome());
//            pstmt.setString(2, funcionario.getCpf());
//            pstmt.setString(3, funcionario.getSenha());
//            pstmt.setString(4, funcionario.getData_nasc());
//            pstmt.setString(5, funcionario.getEndereco());
//            pstmt.executeUpdate();
//
//            pstmt.close();
//            conexao.fecharConexao();
//        }
//        catch (SQLException e) {
//            System.err.print(e.getMessage());
//        }
//
//    }
//
//    public ArrayList<Funcionario> listarTodosFuncionarios(){
//        ConexaoBD conexaoBD = new ConexaoBD();
//        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
//        try{
//            conexaoBD.connectar();
//            String sql = "SELECT * FROM funcionario";
//            Statement stmt = conexaoBD.conn.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//            while(rs.next()){
//                Funcionario f = new Funcionario();
//                f.setId(rs.getInt("ID"));
//                f.setNome(rs.getString("NOME"));
//                f.setCpf(rs.getString("CPF"));
//                f.setSenha(rs.getString("SENHA"));
//                f.setData_nasc(rs.getString("DATA_NASC"));
//                f.setEndereco(rs.getString("ENDERECO"));
//                funcionarios.add(f);
//            }
//
//            rs.close();
//            stmt.close();
//
//        }catch (SQLException e){
//            System.err.println(e.getMessage());
//        }finally {
//            conexaoBD.fecharConexao();
//        }
//        return funcionarios;
//    }
//
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
//
//}
