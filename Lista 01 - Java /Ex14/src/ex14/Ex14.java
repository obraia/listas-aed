/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex14;

import java.util.Random;

/**
 * @author bryan
 */

public class Ex14 {

    public static void main(String[] args) {

        int[][] matriz = new int[3][4];

        int maiorNumero = Integer.MIN_VALUE;
        int menorNumero = Integer.MAX_VALUE;
        
        int[] maiorPosicao = new int[2];
        int[] menorPosicao = new int[2];

        Random random = new Random();
        
        // --> Gerar matriz com números inteiros aleatórios de 0 a 99
        for (int linha = 0; linha < matriz.length; linha++) {

            for (int coluna = 0; coluna < matriz[0].length; coluna++) {
                matriz[linha][coluna] = random.nextInt(9);
            }
        }

        // --> Encontrar maior e menor número e armazenar suas posições
        for (int linha = 0; linha < matriz.length; linha++) {

            for (int coluna = 0; coluna < matriz[0].length; coluna++) {

                if (matriz[linha][coluna] > maiorNumero) {
                    maiorNumero = matriz[linha][coluna];
                    maiorPosicao[0] = linha;
                    maiorPosicao[1] = coluna;
                }

                if (matriz[linha][coluna] < menorNumero) {
                    menorNumero = matriz[linha][coluna];
                    menorPosicao[0] = linha;
                    menorPosicao[1] = coluna;
                }
            }
        }
        
        // --> Imprimir matriz
        for (int linha = 0; linha < matriz.length; linha++) {

            for (int coluna = 0; coluna < matriz[0].length; coluna++) {

                System.out.print(matriz[linha][coluna] + " ");
            }
            
            System.out.println();
        }
        
        System.out.println();
        System.out.println("Maior número: " + maiorNumero + " Posição: [" + maiorPosicao[0] + ", " + maiorPosicao[1] +"]");
        System.out.println("Menor número: " + menorNumero + " Posição: [" + menorPosicao[0] + ", " + menorPosicao[1] +"]");
        System.out.println();
    }

}
