import org.junit.jupiter.api.Test;
import util.Util;

import java.util.Date;

public class Testvoid {

    @Test
    void TestNumerosAleatorios(){
        int randomNumber = Util.GerarNumeroAleatorio();
        System.out.println("Número aleatório: " + randomNumber);
    }

    @Test
    public void TestConverteData() {
        Date nasc = Util.ConverterStrintParaDate("15/01/2004");
        System.out.println(nasc);

    }

}
