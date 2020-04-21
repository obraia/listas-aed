class Merge {

    public static void sort(Registro[] registros, int inicio, int fim, boolean crescente) {
        int meio = (inicio + fim) / 2;

        // Separar vetor em vetores menores
        if (inicio < fim) {
            // Separar primeira parte do vetor
            sort(registros, inicio, meio, crescente);
            // Separar segunda parte do vetor
            sort(registros, meio + 1, fim, crescente);
        }

        // Definir posições do primeiro e do último elemento do vetor
        int i = 0, primeira = inicio, ultima = meio + 1;

        Registro[] aux = new Registro[fim - inicio + 1];

        while (primeira <= meio && ultima <= fim) {
            aux[i++] = registros[primeira].menorQue(registros[ultima], crescente) ? registros[primeira++] : registros[ultima++];
        }

        //Caso ainda existir elementos na primeira metade
        while (primeira <= meio) {
            aux[i++] = registros[primeira++];
        }

        //Caso ainda existir elementos na segunda metade
        while (ultima <= fim) {
            aux[i++] = registros[ultima++];
        }
        i = 0;
        while (inicio <= fim) {
            registros[inicio++] = aux[i++];
        }
    }
}