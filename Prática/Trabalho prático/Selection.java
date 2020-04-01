public class Selection {
	public static void sort(Registro [] registro)
	{
		int i,j,pos;
		Registro aux;
		for(i=0;i<registro.length;i++)
		{
			aux=registro[i];
			pos=i;
			for(j=i;j<registro.length;j++)
			{
				if(registro[j].menorQue(aux))
				{
					pos=j;
					aux=registro[j];
				}
			}
			if(aux.menorQue(registro[i]))
			{
				aux=registro[i];
				registro[i]=registro[pos];
				registro[pos]=aux;
			}
		}
	}
}
