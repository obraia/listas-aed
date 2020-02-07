package ex16;

import java.util.Random;

/**
 * @author bryan
 */
public class Ex16 {

    public static void main(String[] args) {

        int[][] matriz = new int[4][5];
        int[] somasLinhas;

        PreencherMatriz(matriz);
        somasLinhas = SomarValoresLinha(matriz);

        ExibirMatriz(matriz);
        System.out.println("");
        ExibirSomasLinhas(somasLinhas);
        System.out.println("");
        IndiceMaiorQueValor(matriz, 10);
        System.out.println("");

    }

    // --> Gerar matriz com números inteiros aleatórios de 0 a 11
    public static void PreencherMatriz(int[][] matriz) {

        Random random = new Random();

        for (int linha = 0; linha < matriz.length; linha++) {

            for (int coluna = 0; coluna < matriz[0].length; coluna++) {
                matriz[linha][coluna] = random.nextInt(12);
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

    // --> Somar valores de cada linha da matriz
    public static int[] SomarValoresLinha(int[][] matriz) {

        int[] somasLinhas = new int[matriz.length];

        for (int linha = 0; linha < matriz.length; linha++) {

            for (int coluna = 0; coluna < matriz[0].length; coluna++) {

                somasLinhas[linha] += matriz[linha][coluna];

            }
        }

        return somasLinhas;
    }

    // --> Exibir somas dos valores de cada linha da matriz
    public static void ExibirSomasLinhas(int[] vetor) {

        for (int i = 0; i < vetor.length; i++) {

            System.out.println(String.format("linha %d - %d", (i + 1), vetor[i]));

        }
    }

    // --> Verificar se existe índices maiores que a variável valor passado por parâmetro
    // e armazenar e exibir qual é este valor e sua posição na matriz
    public static void IndiceMaiorQueValor(int[][] matriz, int valor) {

        int numero;
        int[] posicao = new int[2];
        boolean achouValorMaior = false;

        for (int linha = 0; linha < matriz.length; linha++) {

            for (int coluna = 0; coluna < matriz[0].length; coluna++) {

                if (matriz[linha][coluna] > valor) {

                    numero = matriz[linha][coluna];
                    posicao[0] = linha;
                    posicao[1] = coluna;
                    achouValorMaior = true;

                    System.out.println(String.format("Numero: %d - Posição: [%d, %d]", numero, posicao[0], posicao[1]));
                }
            }
        }

        if (achouValorMaior == false) {
            System.out.println(String.format("Nenhum valor maior que %d foi encontrado", valor));
        }
    }
}
