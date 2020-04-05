public class Insertion {
    public static void sort(Registro vetor[], boolean crescente) {
        Registro aux[] = new Registro[vetor.length];
        int n = vetor.length;
        for (int j = 1; j < n; j++) {
            aux[j] = vetor[j];
            int i = j - 1;
            while ((i > -1) && (aux[j].menorQue(vetor[i], crescente))) {
                vetor[i + 1] = vetor[i];
                i--;
            }
            vetor[i + 1] = aux[j];
        }
    }
}
