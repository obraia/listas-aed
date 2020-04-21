public class Selection {
	public static void sort(Registro[] registros, boolean crescente) {
		int i, j, pos;
		Registro aux; //variavel auxiliar
		for (i = 0; i < registros.length; i++) {
			aux = registros[i]; //salva o valor da posição de referência
			pos = i;            //salva indice da posição de referência
			for (j = i; j < registros.length; j++) {
				if (registros[j].menorQue(aux, crescente))//se houver alguma posição menor do que a de referência
				{
					//salva nova posição de referência
					pos = j;
					aux = registros[j];
				}
			}
			if (aux.menorQue(registros[i], crescente))//se houve trocas da posição de referência
			{
				//realiza a troca dos valores
				aux = registros[i];
				registros[i] = registros[pos];
				registros[pos] = aux;
			}
		}
	}
}
