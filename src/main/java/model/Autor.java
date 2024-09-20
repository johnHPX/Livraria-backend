/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author roberts
 */
public class Autor {
    private int id;
    private String nome;
    private String bio;
    private int ano_nasc;

    /**
     * @return the id
     */
    
    
    public Autor(int id, String nome, String bio, int ano_nasc) {
        this.id = id;
        this.nome = nome;
        this.bio = bio;
        this.ano_nasc = ano_nasc;
    }

    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the bio
     */
    public String getBio() {
        return bio;
    }

    /**
     * @param bio the bio to set
     */
    public void setBio(String bio) {
        this.bio = bio;
    }

    /**
     * @return the ano_nasc
     */
    public int getAno_nasc() {
        return ano_nasc;
    }

    /**
     * @param ano_nasc the ano_nasc to set
     */
    public void setAno_nasc(int ano_nasc) {
        this.ano_nasc = ano_nasc;
    }
   
    
}
