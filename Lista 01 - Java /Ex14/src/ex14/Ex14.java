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

        GerarMatriz(matriz);

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
        
        ExibirMatriz(matriz);

        System.out.println();
        System.out.println(String.format("Maior: %d Posição: [%d, %d]", maiorNumero, maiorPosicao[0], maiorPosicao[1]));
        System.out.println(String.format("Menor: %d Posição: [%d, %d]", menorNumero, menorPosicao[0], menorPosicao[1]));

        System.out.println();
    }

    // --> Gerar matriz com números inteiros aleatórios de 0 a 99
    public static void GerarMatriz(int[][] matriz) {

        Random random = new Random();

        for (int linha = 0; linha < matriz.length; linha++) {

            for (int coluna = 0; coluna < matriz[0].length; coluna++) {
                matriz[linha][coluna] = random.nextInt(100);
            }
        }
    }
    
    public static void ExibirMatriz(int[][] matriz) {
        
        for (int linha = 0; linha < matriz.length; linha++) {

            for (int coluna = 0; coluna < matriz[0].length; coluna++) {

                System.out.print(String.format("%2d ", matriz[linha][coluna]));
            }

            System.out.println();
        }
    }

}
