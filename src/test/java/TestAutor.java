import model.Autor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.AutorRepository;

import java.util.ArrayList;

class TestAutor {

    private Autor autor;

    @BeforeEach
    public void setUp(){
        autor = new Autor();
        autor.setNome("Robert Cecil Martin");
        autor.setBio("Robert Cecil Martin, também conhecido como \"Uncle Bob\", é uma grande personalidade da comunidade de desenvolvimento de software, métodos ágeis e software craftsmanship, atuando na área desde 1970. Atualmente é consultor internacional e autor de vários livros abordando o tema.");
        autor.setAno_nasc(1952);
    }

    @Test
    public void TestInsertInto(){
        try{
            AutorRepository ar = new AutorRepository();
            ar.criarAutor(autor);
            System.out.println("Sucesso!");
        }catch (Exception e){
            System.err.println("Error: "+e.getMessage()+"\nErro Especifico: "+e.getCause());
        }
    }

    @Test
    public void TestSelect(){
        try{
            AutorRepository ar = new AutorRepository();
            ArrayList<Autor> autores = ar.listarTodosAutor();
            System.out.println("=======================================");
            for(Autor autor:autores){
                System.out.println("ID: "+autor.getId());
                System.out.println("NOME: "+autor.getNome());
                System.out.println("BIO: "+autor.getBio());
                System.out.println("ANO_NASC: "+autor.getAno_nasc());
                System.out.println("------------------------------------");
            }
            System.out.println("=======================================");

            System.out.println("Total: "+autores.size());
        }catch (Exception e){
            System.err.println("Error: "+e.getMessage()+"\nErro Especifico: "+e.getCause());
        }
    }

    @Test
    public void testUpdate(){
        try{
            AutorRepository ar = new AutorRepository();
            autor.setId(3);
            autor.setNome("teste");
            autor.setBio("isso é uma biografia");
            autor.setAno_nasc(1931);
            ar.alterarAutor(autor);
            System.out.println("Sucesso!");
        }catch (Exception e){
            System.err.println("Error: "+e.getMessage()+"\nErro Especifico: "+e.getCause());
        }
    }

    @Test
    public void testDelete(){
        try{
            AutorRepository ar = new AutorRepository();
            ar.removerAutor(3);
            System.out.println("Sucesso!");
        }catch (Exception e){
            System.err.println("Error: "+e.getMessage()+"\nErro Especifico: "+e.getCause());
        }
    }

}
