package model;

public class Usuario {

    private int id;
    private String nome;
    private String cpf;
    private String endereço;
    private String dataNasc;
    private int qtdLivros;
    private boolean devendo;

    public Usuario(String nome, String cpf, String endereço, String dataNasc, int qtdLivros, boolean devendo) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereço = endereço;
        this.dataNasc = dataNasc;
        this.qtdLivros = qtdLivros;
        this.devendo = devendo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public int getQtdLivros() {
        return qtdLivros;
    }

    public void setQtdLivros(int qtdLivros) {
        this.qtdLivros = qtdLivros;
    }

    public boolean isDevendo() {
        return devendo;
    }

    public void setDevendo(boolean devendo) {
        this.devendo = devendo;
    }
}