package util;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public enum DatasFormatadas {

    PADRAO_USA("yyyy/MM/dd"),
    PADRAO_BR("dd/MM/yyyy");

    private String valor;

    public String getValor() {
        return valor;
    }
    
    //construtor
    DatasFormatadas(String valor){
        this.valor = valor;
    }
    
    
    }


