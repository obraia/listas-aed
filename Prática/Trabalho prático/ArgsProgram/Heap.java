
public class Heap {
	 
	public static void sort(Registro registros[], boolean crescente) 
	    { 
	    	Registro aux[] = new Registro[registros.length];  
	        for (int i = registros.length / 2 - 1; i >= 0; i--) 
	            heapify(registros, registros.length, i, crescente); 
	  
	        for (int i=registros.length-1; i>=0; i--) 
	        { 
	        	aux[i] = registros[0]; 
	            registros[0] = registros[i]; 
	            registros[i] = aux[i]; 
	  
	            heapify(registros, i, 0, crescente); 
	        } 
	    } 
	  
	    public static void heapify(Registro registros[], int pos, int tamanhoDoVetor, boolean crescente) 
	    { 
	        int largest = tamanhoDoVetor;
	        int l = 2*tamanhoDoVetor + 1;
	        int r = 2*tamanhoDoVetor + 2; 

	        if (l < pos && !registros[l].menorQue(registros[largest], crescente)) 
	            largest = l; 
	  
	        if (r < pos && !registros[r].menorQue(registros[largest], crescente)) 
	            largest = r; 
	  
	        if (largest != tamanhoDoVetor) 
	        { 
	        	Registro swap = registros[tamanhoDoVetor]; 
	            registros[tamanhoDoVetor] = registros[largest]; 
	            registros[largest] = swap; 
	  
	            heapify(registros, pos, largest, crescente); 
	        } 
	    } 
}
