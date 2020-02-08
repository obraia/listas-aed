package ex18;

import java.util.Random;

/**
 * @author bryan
 */

public class Ex18 {

    public static void main(String[] args) {

        int[][] matriz = new int[4][4];

        PreencherMatriz(matriz);
        ExibirMatriz(matriz);

        System.out.println("");

        DividirPelaDiagonal(matriz);
        ExibirMatriz(matriz);

    }

    // --> Gerar matriz com números inteiros aleatórios de 0 a 9
    public static void PreencherMatriz(int[][] matriz) {

        Random random = new Random();

        for (int linha = 0; linha < matriz.length; linha++) {

            for (int coluna = 0; coluna < matriz[0].length; coluna++) {
                matriz[linha][coluna] = random.nextInt(9) + 1;
            }
        }
    }

    public static void ExibirMatriz(int[][] matriz) {

        for (int linha = 0; linha < matriz.length; linha++) {

            for (int coluna = 0; coluna < matriz[0].length; coluna++) {

                System.out.printf("%2d ", matriz[linha][coluna]);
            }

            System.out.println();
        }
    }

    // --> Dividir cada elemento de um linha pelo elemento de mesma linha da diagonal principal
    public static void DividirPelaDiagonal(int[][] matriz) {

        for (int linha = 0; linha < matriz.length; linha++) {

            int indiceDiagonalPrincipal = matriz[linha][linha];

            for (int coluna = 0; coluna < matriz[0].length; coluna++) {

                matriz[linha][coluna] = matriz[linha][coluna] / indiceDiagonalPrincipal;
            }
        }
    }

}
