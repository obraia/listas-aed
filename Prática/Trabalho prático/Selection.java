public class Selection {
	public static void sort(Registro [] registros, boolean crescente)
	{
		int i,j,pos;
		Registro aux;
		for(i=0;i<registros.length;i++)
		{
			aux=registros[i];
			pos=i;
			for(j=i;j<registros.length;j++)
			{
				if(registros[j].menorQue(aux, crescente))
				{
					pos=j;
					aux=registros[j];
				}
			}
			if(aux.menorQue(registros[i], crescente))
			{
				aux=registros[i];
				registros[i]=registros[pos];
				registros[pos]=aux;
			}
		}
	}
}
