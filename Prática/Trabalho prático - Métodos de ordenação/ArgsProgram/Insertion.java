public class Insertion {
    public static void sort(Registro[] registros, boolean crescente) {
        Registro[] aux = new Registro[registros.length];
        int n = registros.length;

        for (int j = 1; j < n; j++) {
            aux[j] = registros[j];
            int i = j - 1;

            // Move elementos de array [0..i-1], que são maior que a chave,
            // para uma posição à frente da posição atual

            while ((i > -1) && (aux[j].menorQue(registros[i], crescente))) {
                registros[i + 1] = registros[i];
                i--;
            }
            registros[i + 1] = aux[j];
        }
    }
}
