class Ex04 {
    public static void main(String[] args) {
        int[] vetor = { 1, 2, 3, 4, 5, 6, 7 };
        int tamanho = vetor.length;
        imprimirVetorCrescente(vetor, tamanho);
        imprimirVetorDecrescente(vetor, tamanho);
        System.out.println(somaValoresVetor(vetor, tamanho));
    }

    public static int imprimirVetorCrescente(int[] vetor, int tamanho) {
        int length = vetor.length;

        if (tamanho == 0) {
            System.out.println();
            return 0;
        } else {
            System.out.print(vetor[length - tamanho] + " ");
            return imprimirVetorCrescente(vetor, tamanho - 1);
        }
    }

    public static int imprimirVetorDecrescente(int[] vetor, int tamanho) {
        if (tamanho == 0) {
            System.out.println();
            return 0;
        } else {
            System.out.print(vetor[tamanho - 1] + " ");
            return imprimirVetorDecrescente(vetor, tamanho - 1);
        }
    }

    public static int somaValoresVetor(int[] vetor, int tamanho) {
        if (tamanho == 0) {
            return 0;
        } else {
            return vetor[tamanho - 1] + somaValoresVetor(vetor, tamanho - 1);
        }
    }

}