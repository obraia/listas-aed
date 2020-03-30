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
        
        GerarMatriz(matriz);

        // --> Somar e obter média da diagonal principal
        for (int i = 0; i < matriz.length; i++) {
            
            somaDiagonalPrincipal += matriz[i][i];
        }
        
        mediaDiagonalPrincipal = (double) somaDiagonalPrincipal / matriz.length;
        
        ExibirMatriz(matriz);
        
        System.out.printf("\nA média da diagonal principal é: %.2f \n\n", mediaDiagonalPrincipal);
        
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
                
                System.out.printf("%2d ", matriz[linha][coluna]);
            }
            
            System.out.println();
        }
    }
}
