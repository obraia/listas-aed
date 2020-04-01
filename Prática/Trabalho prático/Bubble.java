public class Bubble {
	
	public static void sort(Registro[] registro) {
		int i, j;
		Registro aux;
		for (i = 0; i < registro.length - 1; i++) {
			for (j = 0; j < registro.length - 1 - i; j++) {
				if (!registro[j].menorQue(registro[j + 1])) {
					aux = registro[j];
					registro[j] = registro[j + 1];
					registro[j + 1] = aux;
				}
			}

		}
	}
}
