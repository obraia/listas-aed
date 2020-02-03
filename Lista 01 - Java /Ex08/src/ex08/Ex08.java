/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex08;

import java.util.Scanner;

/**
 *
 * @author bryan
 */
public class Ex08 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner sc = new Scanner(System.in);
        int quantNumeros = 0;

        System.out.print("Digite a quantidade de números a serem lidos: ");
        quantNumeros = sc.nextInt();

        int[] numeros = new int[quantNumeros];

        for (int i = 0; i < quantNumeros; i++) {
            System.out.println("Digite o " + (i + 1) + "º valor");
            numeros[i] = sc.nextInt();
        }

        int[] fatoriais = new int[quantNumeros];

        for (int i = 0; i < quantNumeros; i++) {
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
