/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex10;

import java.util.Scanner;

/**
 *
 * @author bryan
 */
public class Ex10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner sc = new Scanner(System.in);

        int quantNumeros = 6;
        int[] vetorNumeros = new int[quantNumeros];
        int[] vetorNumerosPares = new int[quantNumeros];
        int[] vetorNumerosImpares = new int[quantNumeros];

        int somaPares = 0;
        int somaImpares = 0;
        int quantPares = 0;
        int quantImpares = 0;

        for (int i = 0; i < vetorNumeros.length; i++) {
            System.out.println("Digite o " + (i + 1) + "º valor");
            vetorNumeros[i] = sc.nextInt();
        }

        for (int i = 0; i < vetorNumeros.length; i++) {

            if (vetorNumeros[i] % 2 == 0) {
                vetorNumerosPares[i] = vetorNumeros[i];
                vetorNumerosImpares[i] = -1;

                quantPares++;
                somaPares += vetorNumeros[i];
            } else {
                vetorNumerosImpares[i] = vetorNumeros[i];
                vetorNumerosPares[i] = -1;

                quantImpares++;
                somaImpares += vetorNumeros[i];
            }

        }

        System.out.println("\na) Números pares:");

        for (int i = 0; i < vetorNumeros.length; i++) {

            if (vetorNumerosPares[i] != -1) {
                System.out.println(vetorNumerosPares[i]);
            }

        }

        System.out.println("\nb) Soma de todos números pares: " + somaPares);

        System.out.println("\nc) Números ímpares:");

        for (int i = 0; i < vetorNumeros.length; i++) {

            if (vetorNumerosImpares[i] != -1) {
                System.out.println(vetorNumerosImpares[i]);
            }

        }

        System.out.println("\nd) Quantidade de números ímpares: " + quantImpares);

    }

}
