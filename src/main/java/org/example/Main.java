package org.example;

import javax.swing.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String originalAddress = JOptionPane
                .showInputDialog("Digite um endereço")
                .replaceAll("[#,]", "");

        //Separa o endereço digitado em um array
        String[] addressFragments = originalAddress.split("\s");

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
            if(isInteger(addressFragments[i])){
                addressNum[1] = addressFragments[i];
                //Verifica se existe um carácter de bloco após o número
                if (i + 1 < addressFragments.length && addressFragments[i+1].length() == 1 ){
                    addressNum[2] = addressFragments[i+1];
                }
                //Verifica se existe o "No" antes do número
                if ( i - 1 >= 0 && addressFragments[i-1].equalsIgnoreCase("no") ){
                    addressNum[0] = addressFragments[i-1];
                }
            }
            else if(containsAInteger( addressFragments[i] )){
                addressNum[1] = addressFragments[i];
            }
        }
        for (String element : addressFragments) {
            if(Arrays.asList( addressNum ).contains( element )) formattedAddress[1] += element;
            else formattedAddress[0] += element + " ";
        }
        JOptionPane.showMessageDialog(
                null,
                "Endereço: " + formattedAddress[0]
                + "\nNúmero: " + formattedAddress[1]
                + "\n\nSaída sem formatação:\n"
                + Arrays.toString(formattedAddress)
        );
    }
    //Verifica se uma string é um número inteiro
    private static boolean isInteger(String str){
        return str != null && str.matches("[0-9]*");
    }
    //Verifica se existe um número inteiro em uma string
    private static boolean containsAInteger(String str){
        String replacedStr = str.replaceAll("(\\D)", "");
        return replacedStr.length() > 0;
    }
}