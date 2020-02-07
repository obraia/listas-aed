package ex08;

import java.util.Scanner;

/**
 * @author bryan
 */

public class Ex08 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int quantidadeNumeros = 0;

        System.out.print("Digite a quantidade de números a serem lidos: ");
        quantidadeNumeros = sc.nextInt();
        
        System.out.println("");

        int[] numeros = new int[quantidadeNumeros];

        for (int i = 0; i < quantidadeNumeros; i++) {
            System.out.print(String.format("Digite o %dº valor: ", (i + 1)));
            numeros[i] = sc.nextInt();
        }

        int[] fatoriais = new int[quantidadeNumeros];

        for (int i = 0; i < quantidadeNumeros; i++) {
            fatoriais[i] = fatorial(numeros[i]);
            
            System.out.println(numeros[i] + "! = " + fatoriais[i]);
        }

    }

    public static int fatorial(int a) {

        for (int i = (a - 1); i > 1; i--) {
            a *= i;
        }

        return a;
    }

}
