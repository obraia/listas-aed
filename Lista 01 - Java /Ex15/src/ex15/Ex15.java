package ex15;

import java.util.Random;

/**
 * @author bryan
 */

public class Ex15 {

    public static void main(String[] args) {

        int[] vetorA = new int[10];
        int[] vetorB = new int[10];
        int[] vetorC;

        PreecnherVetor(vetorA);
        PreecnherVetor(vetorB);
        vetorC = MultiplicarVetores(vetorA, vetorB);

        ImprimirVetor(vetorA);
        ImprimirVetor(vetorB);
        ImprimirVetor(vetorC);

    }

    // --> Preenche vetor com inteiros aleatórios de 0 a 9
    public static void PreecnherVetor(int[] vetor) {

        Random random = new Random();

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = random.nextInt(10);
        }
    }

    // --> Multiplica índices iguais de dois vetores salvando em um vetor para retorna-lo
    public static int[] MultiplicarVetores(int[] vetorA, int[] vetorB) {

        int[] vetorC = new int[vetorA.length];

        for (int i = 0; i < vetorA.length; i++) {
            vetorC[i] = vetorA[i] * vetorB[i];
        }

        return vetorC;
    }
    
    public static void ImprimirVetor(int[] vetor) {

        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }

        System.out.println();
    }
}
