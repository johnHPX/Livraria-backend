import model.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.FuncionarioRepository;
import repository.UsuarioRepository;

import java.util.ArrayList;

class TestFuncionario {

    private Funcionario funcionario;

    @BeforeEach
    public void setUp(){
        funcionario = new Funcionario("teste1", "12345678910", "1234", "1997/05/12", "Crato Batedeira");
    }

    @Test
    public void testInsertInto(){
        FuncionarioRepository funcionarioRepository = new FuncionarioRepository();
        funcionarioRepository.criarFuncionario(funcionario);
        System.out.println("Sucesso!");
    }

    @Test
    public void testSelectALL(){
        FuncionarioRepository funcionarioRepository = new FuncionarioRepository();
        ArrayList<Funcionario> funcionarios = funcionarioRepository.listarTodosFuncionarios();
        for(Funcionario funcionario: funcionarios){
            System.out.println(funcionario.getId());
            System.out.println(funcionario.getNome());
            System.out.println(funcionario.getCpf());
            System.out.println(funcionario.getSenha());
            System.out.println(funcionario.getData_nasc());
            System.out.println(funcionario.getEndereco());
        }
        System.out.println("Sucesso!");
    }

    @Test
    public void testUpdate(){
        FuncionarioRepository funcionarioRepository = new FuncionarioRepository();
        funcionario.setId(1);
        funcionario.setNome("Jonatas");
        funcionario.setCpf("61868307301");
        funcionario.setSenha("123456");
        funcionario.setEndereco("Rua senador pompeu 315 Centro Crato");
        funcionario.setData_nasc("2004/03/08");
        funcionarioRepository.alterarFuncionario(funcionario);
        System.out.println("Sucesso!");
    }

    @Test
    public void testDelete(){
        FuncionarioRepository funcionarioRepository = new FuncionarioRepository();
        funcionarioRepository.removerFuncionario(1);
        System.out.println("Sucesso!");
    }

}
