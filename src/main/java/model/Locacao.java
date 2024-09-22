/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author roberts
 */
public class Locacao {
    private int id;
    private int usuario_id;
    private int funcionario_id;
    private int edicao_cod;
    private String prazo;
    private String data_locacao;
    private int ano;
    private boolean aberta;

    public Locacao(int usuario_id, int funcionario_id, int edicao_cod, String prazo, String data_locacao, int ano, boolean aberta) {
        this.usuario_id = usuario_id;
        this.funcionario_id = funcionario_id;
        this.edicao_cod = edicao_cod;
        this.prazo = prazo;
        this.data_locacao = data_locacao;
        this.ano = ano;
        this.aberta = aberta;
    }

    public Locacao(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public int getFuncionario_id() {
        return funcionario_id;
    }

    public void setFuncionario_id(int funcionario_id) {
        this.funcionario_id = funcionario_id;
    }

    public int getEdicao_cod() {
        return edicao_cod;
    }

    public void setEdicao_cod(int edicao_cod) {
        this.edicao_cod = edicao_cod;
    }

    public String getPrazo() {
        return prazo;
    }

    public void setPrazo(String prazo) {
        this.prazo = prazo;
    }

    public String getData_locacao() {
        return data_locacao;
    }

    public void setData_locacao(String data_locacao) {
        this.data_locacao = data_locacao;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public boolean isAberta() {
        return aberta;
    }

    public void setAberta(boolean aberta) {
        this.aberta = aberta;
    }
}
