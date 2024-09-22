package util;

import java.sql.Date;

interface UtilInterface {

    int GerarNumeroAleatorio();
    Date ConverterStrintParaDate(String value);
    String ConverterDateParaString(Date value);

}
