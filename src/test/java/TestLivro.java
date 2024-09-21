import model.Livro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.LivroRepository;

import java.util.ArrayList;

class TestLivro {

    private Livro livro;

    @BeforeEach
    void setUP(){
        livro = new Livro("Algoritmos: Teoria e prática", "Esducação", "qualque descrição...");
    }

    @Test
    void TestInsertoInto(){
        LivroRepository lr = new LivroRepository();
        lr.criarLivro(livro);
        System.out.println("Sucesso!");
    }

    @Test
    void TestSelect(){
        LivroRepository lr = new LivroRepository();
        ArrayList<Livro> livros = lr.listarTodosLivros();
        System.out.println("===================================");
        for (Livro l: livros){
            System.out.println("ID: "+l.getId());
            System.out.println("NOME: "+l.getNome());
            System.out.println("GÊNERO: "+l.getGenero());
            System.out.println("DESCRIÇÃO: "+l.getDescricao());
            System.out.println("-------------------------------");
        }
        System.out.println("===================================");
    }

    @Test
    void TestUpdate(){
        LivroRepository lr = new LivroRepository();
        livro.setId(2);
        livro.setNome("nome alterado");
        livro.setGenero("alterado");
        livro.setDescricao("desc alterado");
        lr.alterarLivro(livro);
        System.out.println("Sucesso!");
    }

    @Test
    void TestDelete(){
        LivroRepository lr = new LivroRepository();
        lr.removerLivro(2);
        System.out.println("Sucesso!");
    }

}