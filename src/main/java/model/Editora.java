/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author roberts
 */
public class Editora {
    private int cod;
    private String nome_edicao;
    private int editora_id;
    private int livro_id;
    private int ano;
    private int quantidade;
    private String idioma;
    private int total_paginas;

    public Editora(String nome_edicao, int editora_id, int livro_id, int ano, int quantidade, String idioma, int total_paginas) {
        this.nome_edicao = nome_edicao;
        this.editora_id = editora_id;
        this.livro_id = livro_id;
        this.ano = ano;
        this.quantidade = quantidade;
        this.idioma = idioma;
        this.total_paginas = total_paginas;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome_edicao() {
        return nome_edicao;
    }

    public void setNome_edicao(String nome_edicao) {
        this.nome_edicao = nome_edicao;
    }

    public int getEditora_id() {
        return editora_id;
    }

    public void setEditora_id(int editora_id) {
        this.editora_id = editora_id;
    }

    public int getLivro_id() {
        return livro_id;
    }

    public void setLivro_id(int livro_id) {
        this.livro_id = livro_id;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getTotal_paginas() {
        return total_paginas;
    }

    public void setTotal_paginas(int total_paginas) {
        this.total_paginas = total_paginas;
    }
    
    
}
