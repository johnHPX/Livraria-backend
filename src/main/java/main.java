import repository.ConexaoBD;

public class main {

    public static void main(String[] args){
        ConexaoBD conexao = new ConexaoBD();
        conexao.connectar();
        System.out.println("Hello boy");
    }
}
