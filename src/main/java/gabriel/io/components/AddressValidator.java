package gabriel.io.components;

import java.util.ArrayList;
import java.util.Arrays;

public class AddressValidator {

    public static String[] validate(String originalAddress){

        originalAddress = originalAddress
                .replaceAll("[#,]", "")
                .replaceAll("\s{2,}", " ")
                .strip();

        //Separa o endereço digitado em um array
        String[] addressFragments = originalAddress.split(" ");

        if(addressFragments.length < 2) {
            String[] errorMsg = new String[1];
            errorMsg[0] = "Adicione um endereço válido";
            return errorMsg;
        };

        /*Variável que guardará o endereço formatado sendo que:
            formattedAddress[0] = Guardará o endereço
            formattedAddress[1] = Guardará o número
         */
        String[] formattedAddress = new String[2];
        formattedAddress[0] = formattedAddress[1] = "";

        /*Variável que guardará o número do endereço sendo que:
            addressNum[0] = Guardará "No" (caso exista),
            addressNum[1] = Guardará o número em si,
            addressNum[2] = Guardará o bloco (caso exista)
         */
        String[] addressNum = new String[3];

        for (int i = 0; i < addressFragments.length; i++) {
            //Verifica se existe um carácter de bloco após o número
            boolean existsACharacter = i + 1 < addressFragments.length && addressFragments[i+1].length() == 1;

            //Verifica se existe o "No" antes do número
            boolean existsANo = i - 1 >= 0 && addressFragments[i-1].equalsIgnoreCase("no");

            if(isInteger(addressFragments[i])){
                addressNum[1] = addressFragments[i];
                if ( existsACharacter ){
                    addressNum[2] = addressFragments[i+1];
                }
                if ( existsANo ){
                    addressNum[0] = addressFragments[i-1];
                }
            }
            else if(containsAInteger( addressFragments[i] )){
                addressNum[1] = addressFragments[i];
                if ( existsACharacter ) {
                    addressNum[2] = addressFragments[i + 1];
                }
                if ( existsANo ){
                    addressNum[0] = addressFragments[i-1];
                }
            }
        }
        for (String element : addressFragments) {
            if(Arrays.asList( addressNum ).contains( element )) {
                if(element.equalsIgnoreCase("no")) formattedAddress[1] += element + " ";
                else formattedAddress[1] += element;
            }
            else formattedAddress[0] += element + " ";
        }
        return formattedAddress;
    }

    private static boolean isInteger(String str) { return str != null && str.matches("[0-9]*"); }

    private static boolean containsAInteger(String str) {
        String replacedStr = str.replaceAll("(\\D)", "");
        return replacedStr.length() > 0;
    }
}

