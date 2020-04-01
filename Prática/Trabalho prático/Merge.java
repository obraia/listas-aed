class Merge {

    public static void sort(Registro[] vetor, int inicio, int fim, boolean crescente) {
        int meio = (inicio + fim) / 2;

        if (inicio < fim) {
            sort(vetor, inicio, meio, crescente);
            sort(vetor, meio + 1, fim, crescente);
        }

        int i = 0, first = inicio, last = meio + 1;

        Registro[] aux = new Registro[fim - inicio + 1];

        while (first <= meio && last <= fim) {
            aux[i++] = vetor[first].menorQue(vetor[last], crescente) ? vetor[first++] : vetor[last++];
        }

        while (first <= meio) {
            aux[i++] = vetor[first++];
        }
        while (last <= fim) {
            aux[i++] = vetor[last++];
        }
        i = 0;
        while (inicio <= fim) {
            vetor[inicio++] = aux[i++];
        }
    }
}