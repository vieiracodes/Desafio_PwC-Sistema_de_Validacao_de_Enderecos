package gabriel.io.components;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class TestCases {
    public static void testAll(){
        ArrayList<String> tests = new ArrayList<>(Arrays.asList(
            "Miritiba 339",
            "Babaçu 500",
            "Cambuí 804B",
            "Rio Branco 23",
            "Quirino dos Santos 23 b",
            "4, Rue de la République",
            "100 Broadway Av",
            "Calle Sagasta, 26",
            "Calle 44 No 1991"
        ));

        /*Os resultados serão armazenados em uma matriz, sendo:
        * results[array do resultado][0] = endereço original
        * results[array do resultado][1] = endereço em um array, separado entre Número e nome
        * ex:
        * results[0] -> [Miritiba 339, [Miritiba, 339]]
        */
        String[][] results = new String[9][2];
        int c = 0;

        for (String testCase: tests) {
            results[c][0] = testCase;
            results[c][1] = Arrays.toString(AddressValidator.validate(testCase));
            c++;
        }

        String[] formattedResults = resultsConversion(results);

        //Exibe uma janela para cada resultado
        for (String element: formattedResults) {
            JOptionPane.showMessageDialog(null, element);
        }

    }
    //Cria uma formatação para exibir os resultados
    private static String[] resultsConversion(String[][] test){
        String[] output = new String[9];
        int i = 0;
        for (String[] result : test) {
            output[i] = "\nEndereço Original:\n" +
                    result[0] +
                    "\nEndereço separado (Nome/número):\n" +
                    result[1];
            i++;
        }

        return output;
    }
}

