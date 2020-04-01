public class Insertion {
    public static void sort(Registro array[]) {
        Registro key[] = new Registro[array.length];
        int n = array.length;
        for (int j = 1; j < n; j++) {
            key[j] = array[j];
            int i = j - 1;
            while ((i > -1) && (key[j].menorQue(array[i]))) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = key[j];
        }
    }
}
