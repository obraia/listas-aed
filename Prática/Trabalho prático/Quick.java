import java.util.Random;

public class Quick {
	public static void sort(Registro[] registros, boolean crescente) {
		sort(registros, 0, registros.length - 1, crescente);
	}

	private static void sort(Registro[] registros, int inicio, int fim,  boolean crescente) {
		if (inicio < fim + 1) {
			int pos = particao(registros, inicio, fim, crescente);
			sort(registros, inicio, pos - 1, crescente);
			sort(registros, pos + 1, fim, crescente);
		}
	}

	private static void troca(Registro[] registros, int pos1, int pos2) {
		Registro aux = registros[pos1];
		registros[pos1] = registros[pos2];
		registros[pos2] = aux;
	}

	private static int pivoAleatorio(int inicio, int fim) {
		Random aleatorio = new Random();
		return aleatorio.nextInt((fim - inicio) + 1) + inicio;
	}

	private static int particao(Registro[] registros, int inicio, int fim, boolean crescente) {
		troca(registros, inicio, pivoAleatorio(inicio, fim));
		int pos = inicio + 1;
		for (int i = pos; i <= fim; i++) {
			if (registros[i].menorQue(registros[inicio], crescente))
				troca(registros, i, pos++);
		}
		troca(registros, inicio, pos - 1);
		return pos - 1;
	}
}
