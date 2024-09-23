package util;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Random;

import static util.DatasFormatadas.PADRAO_USA;

public class Util implements UtilInterface{

    // Gera um número aleatorio de 5 digitos
    public int GerarNumeroAleatorio() throws NullPointerException, IllegalArgumentException{
        Random random = new Random();
        // Gera número entre 10000 e 99999
        int randomNumber = 10000 + random.nextInt(90000);
        return randomNumber;
    }

    // Converte uma String para um tipo Date e retorna
    public Date ConverterStrintParaDate(String value) throws IllegalArgumentException, DateTimeParseException {
        LocalDate localDate = LocalDate.parse(value, DateTimeFormatter.ofPattern(PADRAO_USA.getValor()));
        Date date = Date.valueOf(localDate);
        return date;
    }

    // Converte um tipo Date para String e retorna
    public String ConverterDateParaString(Date value) throws NullPointerException, IllegalArgumentException{
        DateFormat df = new SimpleDateFormat(PADRAO_USA.getValor());
        String string = df.format(value);
        return string;
    }

}
