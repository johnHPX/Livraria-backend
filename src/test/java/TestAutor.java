import model.Autor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.AutorRepository;

class TestAutor {

    private Autor autor;

    @BeforeEach
    public void setUp(){
        autor = new Autor();
        autor.setNome("J.K Rowling");
        autor.setBio("Joanne \"Jo\" Rowling OBE FRSL, mais conhecida como J. K. Rowling, é uma escritora, roteirista e produtora cinematográfica britânica, notória por escrever a série de livros Harry Potter.");
        autor.setAno_nasc(1965);
    }

    @Test
    public void TestInsertInto(){
        AutorRepository ar = new AutorRepository();
        ar.criarAutor(autor);
        System.out.println("Sucesso!");
    }

}
