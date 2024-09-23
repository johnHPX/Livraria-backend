import model.Locacao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.EdicaoRepository;
import repository.LocacaoRepository;

import java.util.ArrayList;

class TestLocacao {

    private Locacao locacao;

    @BeforeEach
    void setUp(){
        locacao = new Locacao(1, 1, 39448, "2024/10/07", "2024/09/22", 2024, true);
    }

    @Test
    void TestInsertInto(){
        try{
            LocacaoRepository lr = new LocacaoRepository();
            lr.criarLocacao(locacao);
            System.out.println("Sucesso!");
        }catch (Exception e){
            System.err.println("Error: "+e.getMessage()+"\nErro Especifico: "+e.getCause());
        }
    }

    @Test
    void TestSelect(){
        try{
            LocacaoRepository lr = new LocacaoRepository();
            ArrayList<Locacao> locacoes = lr.listarTodasLocacoes();
            System.out.println("===================================");
            for (Locacao e: locacoes){
                System.out.println("ID: "+e.getId());
                System.out.println("USUARIO_FK: "+e.getUsuario_id());
                System.out.println("FUNCIONARIO_FK: "+e.getFuncionario_id());
                System.out.println("EDICAO_COD: "+e.getEdicao_cod());
                System.out.println("PRAZO: "+e.getPrazo());
                System.out.println("DATA_LOCACAO: "+e.getData_locacao());
                System.out.println("ANO: "+e.getAno());
                System.out.println("ABERTA: "+e.isAberta());
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
            LocacaoRepository lr = new LocacaoRepository();
            locacao.setId(6);
            locacao.setUsuario_id(1);
            locacao.setFuncionario_id(1);
            locacao.setEdicao_cod(39448);
            locacao.setPrazo("2024/08/30");
            locacao.setData_locacao("2024/08/15");
            locacao.setAno(2023);
            locacao.setAberta(false);
            lr.atualizarLocacao(locacao);
            System.out.println("Sucesso!");
        }catch (Exception e){
            System.err.println("Error: "+e.getMessage()+"\nErro Especifico: "+e.getCause());
        }
    }

    @Test
    void TestDelete(){
        try{
            LocacaoRepository lr = new LocacaoRepository();
            lr.removerLocacao(2);
            System.out.println("Sucesso!");
        }catch (Exception e){
            System.err.println("Error: "+e.getMessage()+"\nErro Especifico: "+e.getCause());
        }
    }

}
