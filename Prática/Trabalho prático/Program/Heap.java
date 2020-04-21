public class Heap {

	public static void sort(Registro[] registros, boolean crescente) {
		Registro[] aux = new Registro[registros.length];

		for (int i = registros.length / 2 - 1; i >= 0; i--) {
			heapify(registros, registros.length, i, crescente);
		}

		// Um ​​por um extrai um elemento do heap
		for (int i = registros.length - 1; i >= 0; i--) {
			// Move o indice atual para o final
			aux[i] = registros[0];
			registros[0] = registros[i];
			registros[i] = aux[i];

			// chama heapify na pilha reduzida
			heapify(registros, i, 0, crescente);
		}
	}

	public static void heapify(Registro[] registros, int pos, int tamanhoDoVetor, boolean crescente) {
		int largest = tamanhoDoVetor;
		int l = 2 * tamanhoDoVetor + 1;
		int r = 2 * tamanhoDoVetor + 2;

		// Se o esquerdo for maior que o tamanho do vetor
		if (l < pos && !registros[l].menorQue(registros[largest], crescente)) {
			largest = l;
		}

		// Se o direito for maior que o maior até agora
		if (r < pos && !registros[r].menorQue(registros[largest], crescente)) {
			largest = r;
		}

		// Se o maior não for tamanhoDoVetor
		if (largest != tamanhoDoVetor) {
			Registro swap = registros[tamanhoDoVetor];
			registros[tamanhoDoVetor] = registros[largest];
			registros[largest] = swap;

			// heapSort recursivamente
			heapify(registros, pos, largest, crescente);
		}
	}
}
