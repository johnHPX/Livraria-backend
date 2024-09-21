import model.Livro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.LivroRepository;

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

}
