import org.junit.jupiter.api.Test;
import util.Util;

import java.util.Date;

public class Testvoid {

    @Test
    void TestNumerosAleatorios(){
        Util util = new Util();
        int randomNumber = util.GerarNumeroAleatorio();
        System.out.println("Número aleatório: " + randomNumber);
    }

    @Test
    public void TestConverteData() {
        Util util = new Util();
        Date nasc = util.ConverterStrintParaDate("15/01/2004");
        System.out.println(nasc);

    }

}
