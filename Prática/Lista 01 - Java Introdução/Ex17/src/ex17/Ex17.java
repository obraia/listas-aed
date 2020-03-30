package ex17;

import java.util.Scanner;

/**
 * @author bryan
 */
public class Ex17 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String frase, fraseCriptografada;

        System.out.print("Digite uma frase: ");
        frase = sc.nextLine();
        
        fraseCriptografada = CriptografarFrase(frase);
        
        System.out.println("Frase criptografada: " + fraseCriptografada);

    }

    // --> "Criptografar" uma String invertendo seus caracteres
    public static String CriptografarFrase(String frase) {

        int length = frase.length();
        char[] fraseCriptografada = new char[length];

        for (int i = 0; i < length; i++) {

            fraseCriptografada[i] = frase.charAt((length-1) - i);

        }

        return new String(fraseCriptografada);
    }

}
