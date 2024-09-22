import model.Edicao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.EdicaoRepository;

import java.util.ArrayList;

class TestEdicao {

    private Edicao edicao;

    @BeforeEach
    void setUp(){
        edicao = new Edicao("Edição de colecionador", 1, 1, 2002, 5, "Português Brasil", 354);
    }

    @Test
    void TestInsertInto(){
        EdicaoRepository er = new EdicaoRepository();
        er.criarEdicao(edicao);
        System.out.println("Sucesso!");
    }

    @Test
    void TestSelect(){
        EdicaoRepository er = new EdicaoRepository();
        ArrayList<Edicao> edicoes = er.listarTodasEdicao();
        System.out.println("===================================");
        for (Edicao e: edicoes){
            System.out.println("COD: "+e.getCod());
            System.out.println("NOME: "+e.getNome_edicao());
            System.out.println("EDITORA_FK: "+e.getEditora_id());
            System.out.println("LIVRO_FK: "+e.getLivro_id());
            System.out.println("ANO: "+e.getAno());
            System.out.println("QUANTIDADE: "+e.getQuantidade());
            System.out.println("IDIOMA: "+e.getIdioma());
            System.out.println("TOTAL_PAG: "+e.getTotal_paginas());
            System.out.println("-------------------------------");
        }
        System.out.println("===================================");
    }

    @Test
    void TestUpdate(){
        EdicaoRepository er = new EdicaoRepository();
        edicao.setCod(95427);
        edicao.setNome_edicao("teste alterado");
        edicao.setEditora_id(1);
        edicao.setLivro_id(1);
        edicao.setAno(2999);
        edicao.setQuantidade(10);
        edicao.setIdioma("Inglês Americando");
        edicao.setTotal_paginas(99);
        er.atualizarEdicao(edicao);
        System.out.println("Sucesso!");
    }

    @Test
    void TestDelete(){
        EdicaoRepository er = new EdicaoRepository();
        er.removerEdicao(94525);
        System.out.println("Sucesso!");
    }

}
