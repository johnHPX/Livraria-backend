import model.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.FuncionarioRepository;

import java.util.ArrayList;

class TestFuncionario {

    private Funcionario funcionario;

    @BeforeEach
    public void setUp(){
        funcionario = new Funcionario("teste1", "12345678910", "1234", "1997/05/12", "Crato Batedeira");
    }

    @Test
    public void testInsertInto(){
        try{
            FuncionarioRepository funcionarioRepository = new FuncionarioRepository();
            funcionarioRepository.criarFuncionario(funcionario);
            System.out.println("Sucesso!");
        }catch (Exception e){
            System.err.println("Error: "+e.getMessage()+"\nErro Especifico: "+e.getCause());
        }
    }

    @Test
    public void testSelectALL(){
        try{
            FuncionarioRepository funcionarioRepository = new FuncionarioRepository();
            ArrayList<Funcionario> funcionarios = funcionarioRepository.listarTodosFuncionarios();
            for(Funcionario funcionario: funcionarios){
                System.out.println(funcionario.getId());
                System.out.println(funcionario.getNome());
                System.out.println(funcionario.getCpf());
                System.out.println(funcionario.getSenha());
                System.out.println(funcionario.getDataNasc());
                System.out.println(funcionario.getEndereco());
            }
            System.out.println("Sucesso!");
        }catch (Exception e){
            System.err.println("Error: "+e.getMessage()+"\nErro Especifico: "+e.getCause());
        }
    }

    @Test
    public void testUpdate(){
        try{
            FuncionarioRepository funcionarioRepository = new FuncionarioRepository();
            funcionario.setId(1);
            funcionario.setNome("Jonatas");
            funcionario.setCpf("123123");
            funcionario.setSenha("123456");
            funcionario.setEndereco("Jardim");
            funcionario.setDataNasc("2000/02/11");
            funcionarioRepository.alterarFuncionario(funcionario);
            System.out.println("Sucesso!");
        }catch (Exception e){
            System.err.println("Error: "+e.getMessage()+"\nErro Especifico: "+e.getCause());
        }
    }

    @Test
    public void testDelete(){
        try{
            FuncionarioRepository funcionarioRepository = new FuncionarioRepository();
            funcionarioRepository.removerFuncionario(1);
            System.out.println("Sucesso!");
        }catch (Exception e){
            System.err.println("Error: "+e.getMessage()+"\nErro Especifico: "+e.getCause());
        }
    }

}
