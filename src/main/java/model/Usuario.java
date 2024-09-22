package model;

public final class Usuario  extends Pessoa{

    private int qtdLivros;
    private boolean devendo;

    public Usuario(){
        super();
    }

    public Usuario(String nome, String cpf, String endereço, String dataNasc, int qtdLivros, boolean devendo) {
        super(nome, cpf, dataNasc, endereço);
        this.qtdLivros = qtdLivros;
        this.devendo = devendo;
    }

    public int getId(){
        return super.id;
    }

    public void setId(int id){
        super.id = id;
    }

    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public void setNome(String nome) {
        super.setNome(nome);
    }

    @Override
    public String getCpf() {
        return super.getCpf();
    }

    @Override
    public void setCpf(String cpf) {
        super.setCpf(cpf);
    }

    @Override
    public String getDataNasc() {
        return super.getDataNasc();
    }

    @Override
    public void setDataNasc(String dataNasc) {
        super.setDataNasc(dataNasc);
    }

    @Override
    public String getEndereco() {
        return super.getEndereco();
    }

    @Override
    public void setEndereco(String endereco) {
        super.setEndereco(endereco);
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
