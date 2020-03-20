class Ordernar {

    public static void mergeSort(Produto[] aux1, Produto[] aux2, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(aux1, aux2, inicio, meio);
            mergeSort(aux1, aux2, meio + 1, fim);
            intercalar(aux1, aux2, inicio, meio, fim);
        }
    }

    public static void intercalar(Produto[] aux1, Produto[] aux2, int inicio, int meio, int fim) {

        for (int i = inicio; i <= fim; i++) {
            aux2[i] = aux1[i];
        }

        int a = inicio;
        int b = meio + 1;

        for (int i = inicio; i <= fim; i++) {
            if(a > meio) aux1[i] = aux2[b++];
            else if(b > fim) aux1[i] = aux2[a++];
            else if(aux2[a].menorQue(aux1[b])) aux1[i] = aux1[a++];
            else aux1[i] = aux2[b++];
        }
    }
}