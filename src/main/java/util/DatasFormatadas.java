package util;

public enum DatasFormatadas {

    PADRAO_USA("yyyy/MM/dd"),
    PADRAO_BR("dd/MM/yyyy");

    private String valor;

    public String getValor() {
        return valor;
    }

    DatasFormatadas(String valor){
        this.valor = valor;
    }

}
