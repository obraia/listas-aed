package ex13;

import java.util.Random;

/**
 * @author bryan
 */
public class Ex13 {

    public static void main(String[] args) {

        int[][] matriz = new int[3][3];
        int somaDiagonalPrincipal = 0;
        double mediaDiagonalPrincipal;

        // --> Gerando matriz com inteiros aleatórios
        Random random = new Random();

        for (int linha = 0; linha < matriz.length; linha++) {

            for (int coluna = 0; coluna < matriz[0].length; coluna++) {

                matriz[linha][coluna] = random.nextInt(100);
            }
        }

        // --> Somando e obtendo média da diagonal principal
        for (int i = 0; i < matriz.length; i++) {

            somaDiagonalPrincipal += matriz[i][i];
        }

        mediaDiagonalPrincipal = (double) somaDiagonalPrincipal / matriz.length;

        // --> Imprimir matriz
        for (int linha = 0; linha < matriz.length; linha++) {

            for (int coluna = 0; coluna < matriz[0].length; coluna++) {

                System.out.print(matriz[linha][coluna] + " ");
            }
            
            System.out.println();
        }

        System.out.println("A média da diagonal principal é: " + mediaDiagonalPrincipal);

    }
}
