package gabriel.io;

import gabriel.io.components.AddressValidator;
import gabriel.io.components.TestCases;

import javax.swing.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Object[] options ={
            "Executar casos de teste",
            "Digitar um endereço",
            "Sair"
        };

        boolean repeat = true;

        while(repeat){
            int choice = JOptionPane.showOptionDialog(null,
                    "Escolha uma opção:",
                    "Validador de endereço",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, options, options[2]
            );
            switch (choice) {
                case 0 -> TestCases.testAll();
                case 1 -> enterAddress();
                default -> repeat = false;
            }
        }
    }
    //Função onde receberá o endereço digitado e irá formata-lo
    private static void enterAddress(){
        String address = JOptionPane.showInputDialog("Digite um endereço");
        String[] formattedAddress = AddressValidator.validate(address);
        JOptionPane.showMessageDialog(
                null,
                "Endereço: " + formattedAddress[0]
                        + "\nNúmero: "
                        + formattedAddress[1]
                        + "\n\nSaída sem formatação:\n"
                        + Arrays.toString(formattedAddress)
        );
    }
}

