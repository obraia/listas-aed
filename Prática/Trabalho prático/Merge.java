class Merge {

    public static void sort(Registro[] vetor, int inicio, int fim) {
        int meio = (inicio + fim) / 2;

        if (inicio < fim) {
            sort(vetor, inicio, meio);
            sort(vetor, meio + 1, fim);
        }

        int i = 0, first = inicio, last = meio + 1;

        Registro[] tmp = new Registro[fim - inicio + 1];

        while (first <= meio && last <= fim) {
            tmp[i++] = vetor[first].menorQue(vetor[last]) ? vetor[first++] : vetor[last++];
        }

        while (first <= meio) {
            tmp[i++] = vetor[first++];
        }
        while (last <= fim) {
            tmp[i++] = vetor[last++];
        }
        i = 0;
        while (inicio <= fim) {
            vetor[inicio++] = tmp[i++];
        }
    }
}