/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author roberts
 */
public class LivroAutor {
    private int id;
    private int livro_id;
    private int autor_id;

    public LivroAutor(){}

    public LivroAutor(int livro_id, int autor_id) {
        this.livro_id = livro_id;
        this.autor_id = autor_id;
    }

    public int getId() {
        return id;
    }

    public int getLivro_id() {
        return livro_id;
    }

    public int getAutor_id() {
        return autor_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLivro_id(int livro_id) {
        this.livro_id = livro_id;
    }

    public void setAutor_id(int autor_id) {
        this.autor_id = autor_id;
    }
    
}
