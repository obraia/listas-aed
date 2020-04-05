public class Bubble {

	public static void sort(Registro[] registros, boolean crescente) {
		int i, j;
		Registro aux;
		for (i = 0; i < registros.length - 1; i++) {
			for (j = 0; j < registros.length - 1 - i; j++) {
				if (!registros[j].menorQue(registros[j + 1], crescente)) {
					aux = registros[j];
					registros[j] = registros[j + 1];
					registros[j + 1] = aux;
				}
			}

		}
	}
}
