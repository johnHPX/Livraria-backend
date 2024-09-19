import model.Usuario;
import repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestUsuario {

    private Usuario usuario;    

    @BeforeEach
    public void setUp(){
        // exemplo
        usuario = new Usuario("teste", "1234672811", "Centro Juazeiro", "2004/02/10", 0, false);
    }

    @Test
    public void testInsertInto(){
        UsuarioRepository userRepository = new UsuarioRepository();
        userRepository.criarUsuario(usuario);
        System.out.println("Sucesso!");
    }

}
