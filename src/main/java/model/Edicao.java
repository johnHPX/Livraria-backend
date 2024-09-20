/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author roberts
 */
public class Edicao {
    private int cod;
    private String nome_edicao;
    private int editora_id;
    private int livro_id;
    private int ano;
    private int quantidade;
    private String idioma;
    private int total_paginas;

    public Edicao(String nome_edicao, int editora_id, int livro_id, int ano, int quantidade, String idioma, int total_paginas) {
        this.nome_edicao = nome_edicao;
        this.editora_id = editora_id;
        this.livro_id = livro_id;
        this.ano = ano;
        this.quantidade = quantidade;
        this.idioma = idioma;
        this.total_paginas = total_paginas;
    }
    
    
    /**
     * @return the cod
     */
    public int getCod() {
        return cod;
    }

    /**
     * @param cod the cod to set
     */
    public void setCod(int cod) {
        this.cod = cod;
    }

    /**
     * @return the nome_edicao
     */
    public String getNome_edicao() {
        return nome_edicao;
    }

    /**
     * @param nome_edicao the nome_edicao to set
     */
    public void setNome_edicao(String nome_edicao) {
        this.nome_edicao = nome_edicao;
    }

    /**
     * @return the editora_id
     */
    public int getEditora_id() {
        return editora_id;
    }

    /**
     * @param editora_id the editora_id to set
     */
    public void setEditora_id(int editora_id) {
        this.editora_id = editora_id;
    }

    /**
     * @return the livro_id
     */
    public int getLivro_id() {
        return livro_id;
    }

    /**
     * @param livro_id the livro_id to set
     */
    public void setLivro_id(int livro_id) {
        this.livro_id = livro_id;
    }

    /**
     * @return the ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the idioma
     */
    public String getIdioma() {
        return idioma;
    }

    /**
     * @param idioma the idioma to set
     */
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    /**
     * @return the total_paginas
     */
    public int getTotal_paginas() {
        return total_paginas;
    }

    /**
     * @param total_paginas the total_paginas to set
     */
    public void setTotal_paginas(int total_paginas) {
        this.total_paginas = total_paginas;
    }
    
    
}
