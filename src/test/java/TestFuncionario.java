import model.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.FuncionarioRepository;

public class TestFuncionario {

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

}
