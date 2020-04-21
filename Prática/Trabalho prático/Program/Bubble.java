public class Bubble {

	public static void sort(Registro[] registros, boolean crescente) {
		int i, j;
		Registro aux; //variável auxiliar
		
		for (i = 0; i < registros.length - 1; i++) {
			for (j = 0; j < registros.length - 1 - i; j++) {
				if (!registros[j].menorQue(registros[j + 1], crescente)) // se a posição de referência for menor do que a seguinte
				{ 
					//faz a troca entre as posições
					aux = registros[j];
					registros[j] = registros[j + 1];
					registros[j + 1] = aux;
				}
			}
		}
	}
}
