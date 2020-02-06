package ex20;

import java.util.Random;

/**
 * @author bryan
 */

public class Ex20 {

    public static void main(String[] args) {

        int[][] matriz = new int[5][5];
        int somaValores;

        PreencherMatriz(matriz);      
        somaValores = SomarAbaixoDiagonalPrincipal(matriz);
        
        ExibirMatriz(matriz);
        System.out.println("\nSoma valores abaixo da diagonal principal: " + somaValores + "\n");
    }

    // --> Gerar matriz com números inteiros aleatórios de 0 a 9
    public static void PreencherMatriz(int[][] matriz) {

        Random random = new Random();

        for (int linha = 0; linha < matriz.length; linha++) {

            for (int coluna = 0; coluna < matriz[0].length; coluna++) {
                matriz[linha][coluna] = random.nextInt(10);
            }
        }
    }

    // --> Exibir matriz na tela
    public static void ExibirMatriz(int[][] matriz) {

        for (int linha = 0; linha < matriz.length; linha++) {

            for (int coluna = 0; coluna < matriz[0].length; coluna++) {

                System.out.print(String.format("%2d ", matriz[linha][coluna]));
            }

            System.out.println();
        }
    }

    // --> obeter e somar valores abaixo da diagonal principal da matriz
    public static int SomarAbaixoDiagonalPrincipal(int[][] matriz) {

        int somaValores = 0;

        for (int linha = 0; linha < matriz.length; linha++) {

            for (int coluna = 0; coluna < linha; coluna++) {

                somaValores += matriz[linha][coluna];
            }
        }
        
        return somaValores;
    }

}