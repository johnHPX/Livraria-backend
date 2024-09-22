import model.Usuario;
import repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

class TestUsuario {

    private Usuario usuario;

    @BeforeEach
    public void setUp(){
        // execute before test start
        usuario = new Usuario("teste", "1234672811", "Centro Juazeiro", "2004/02/10", 0, false);
    }

    @Test
    public void testInsertInto(){
        UsuarioRepository userRepository = new UsuarioRepository();
        userRepository.criarUsuario(usuario);
        System.out.println("Sucesso!");
    }

    @Test
    public void testUpdate(){
        UsuarioRepository userRepository = new UsuarioRepository();
        usuario.setId(1);
        usuario.setNome("Jonatas");
        usuario.setCpf("1223234");
        usuario.setEndereco("Jardim");
        usuario.setDataNasc("2000/08/12");
        usuario.setQtdLivros(3);
        usuario.setDevendo(true);
        userRepository.alterarUsuario(usuario);
        System.out.println("Sucesso!");
    }

    @Test
    public void testDelete(){
        UsuarioRepository userRepository = new UsuarioRepository();
        userRepository.removerUsuario(2);
        System.out.println("Sucesso!");
    }

    @Test
    public void testSelect(){
        UsuarioRepository userRepository = new UsuarioRepository();
        ArrayList<Usuario> us =  userRepository.listarTodosUsuario();
        System.out.println("=======================================");
        for(Usuario u: us){
            System.out.println(u.getId());
            System.out.println(u.getNome());
            System.out.println(u.getCpf());
            System.out.println(u.getEndereco());
            System.out.println(u.getDataNasc());
            System.out.println(u.getQtdLivros());
            System.out.println(u.isDevendo());
            System.out.println("-----------------------------------");
        }
        System.out.println("=======================================");
        System.out.println("Sucesso!");
    }

    @Test
    public void TestManyInsert() {
        UsuarioRepository ur = new UsuarioRepository();
        ArrayList<Usuario> us = new ArrayList<Usuario>();
        us.add(new Usuario("Roberto", "12334567910", "Juazeuiro do norte", "2004/02/20", 0, false));
        us.add(new Usuario("Wallyson", "12334567910", "Juazeiro do norte", "1999/05/24", 5, true));

        ur.criarVariosUsuarios(us);
        System.out.println("Sucesso!");
    }

}
