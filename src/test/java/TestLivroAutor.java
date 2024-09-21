import model.Livro;
import model.LivroAutor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.LivroAutorRepository;
import repository.LivroRepository;

import java.util.ArrayList;

class TestLivroAutor {

    private LivroAutor livroAutor;

    @BeforeEach
    void setUp(){
        livroAutor = new LivroAutor(1, 1);
    }

    @Test
    void TestInsertInto(){
        LivroAutorRepository lar = new LivroAutorRepository();
        lar.criarLivroAutor(livroAutor);
        System.out.println("Sucesso!");
    }

    @Test
    void TestSelect(){
        LivroAutorRepository lar = new LivroAutorRepository();
        ArrayList<LivroAutor> array = lar.listarTodosLivroAutor();
        System.out.println("===================================");
        for (LivroAutor l: array){
            System.out.println("ID: "+l.getId());
            System.out.println("LIVRO_FK: "+l.getLivro_id());
            System.out.println("AUTOR_FK: "+l.getAutor_id());
            System.out.println("-------------------------------");
        }
        System.out.println("===================================");
    }

    @Test
    void TestUpdate(){
        LivroAutorRepository lar = new LivroAutorRepository();
        livroAutor.setId(2);
        livroAutor.setLivro_id(3);
        livroAutor.setAutor_id(2);
        lar.alterarLivroAutor(livroAutor);
        System.out.println("Sucesso!");
    }

    @Test
    void TestDelete(){
        LivroAutorRepository lar = new LivroAutorRepository();
        lar.removerLivroAutor(2);
        System.out.println("Sucesso!");
    }

}
