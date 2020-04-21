class Ordernar {
    public static void mergeSort(Produto[] produtos, int inicio, int fim) {
        int meio = (inicio + fim) / 2;

        if (inicio < fim) {
            mergeSort(produtos, inicio, meio);
            mergeSort(produtos, meio + 1, fim);
        }

        int i = 0, first = inicio, last = meio + 1;

        Produto[] aux = new Produto[fim - inicio + 1];

        while (first <= meio && last <= fim) {
            aux[i++] = produtos[first].menorQue(produtos[last]) ? produtos[first++] : produtos[last++];
        }

        while (first <= meio) {
            aux[i++] = produtos[first++];
        }
        while (last <= fim) {
            aux[i++] = produtos[last++];
        }
        i = 0;
        while (inicio <= fim) {
            produtos[inicio++] = aux[i++];
        }
    }
}