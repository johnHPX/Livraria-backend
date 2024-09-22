package model;

public final class Funcionario  extends Pessoa{
    private String senha;

    public Funcionario(){
        super();
    }
    
    public Funcionario(String nome, String cpf, String senha, String data_nasc, String endereco) {
        super(nome, cpf, data_nasc, endereco);
        this.senha = senha;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
