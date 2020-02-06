package ex11;

import java.util.Scanner;

/**
 * @author bryan
 */

public class Ex11 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        int tamanhoVetor = 3;

        char[] vetorA = new char[tamanhoVetor];
        char[] vetorB = new char[tamanhoVetor];

        for (int i = 0; i < tamanhoVetor; i++) {
            System.out.println(String.format("Digite o %dº caracter", (i + 1)));
            vetorA[i] = sc.next().charAt(0);
        }
        
        // --> Invertando vetorA e salvando no vetorB
        for (int i = 0; i < tamanhoVetor; i++) {
            vetorB[i] = vetorA[(tamanhoVetor-1) - i];
        }
        
        System.out.print("\nVetor A: ");
        
        for (int i = 0; i < tamanhoVetor; i++) {
            System.out.print(vetorA[i]);
        }

        System.out.print("\nVetor B: ");
        
        for (int i = 0; i < tamanhoVetor; i++) {
            System.out.print(vetorB[i]);
        }
        
        System.out.println("");
    }
}
