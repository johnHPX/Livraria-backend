import model.Editora;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.EditoraRepository;

import java.util.ArrayList;

class TestEditora {

    private Editora editora;

    @BeforeEach
    void setUP(){
        editora = new Editora("Patuá", "12345678910123");
    }

    @Test
    void TestInsertoInto(){
        try{
            EditoraRepository er = new EditoraRepository();
            er.criarEditora(editora);
            System.out.println("Sucesso!");
        }catch (Exception e){
            System.err.println("Error: "+e.getMessage()+"\nErro Especifico: "+e.getCause());
        }
    }

    @Test
    void TestSelect(){
        try{
            EditoraRepository er = new EditoraRepository();
            ArrayList<Editora> livros = er.listarTodosEditora();
            System.out.println("===================================");
            for (Editora l: livros){
                System.out.println("ID: "+l.getId());
                System.out.println("NOME: "+l.getNome());
                System.out.println("CNPJ: "+l.getCnpj());
                System.out.println("-------------------------------");
            }
            System.out.println("===================================");
        }catch (Exception e){
            System.err.println("Error: "+e.getMessage()+"\nErro Especifico: "+e.getCause());
        }
    }

    @Test
    void TestUpdate(){
        try{
            EditoraRepository er = new EditoraRepository();
            editora.setId(2);
            editora.setNome("nome alterado");
            editora.setCnpj("alterado");
            er.alterarEditora(editora);
            System.out.println("Sucesso!");
        }catch (Exception e){
            System.err.println("Error: "+e.getMessage()+"\nErro Especifico: "+e.getCause());
        }
    }

    @Test
    void TestDelete(){
        try{
            EditoraRepository er = new EditoraRepository();
            er.removerEditora(2);
            System.out.println("Sucesso!");
        }catch (Exception e){
            System.err.println("Error: "+e.getMessage()+"\nErro Especifico: "+e.getCause());
        }
    }

}
