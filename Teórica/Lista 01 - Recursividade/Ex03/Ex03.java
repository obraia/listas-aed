class Ex03 {
	public static void main(String[] args) {
		int[] vetor = {5, 7, 11, 3, 9};
		int tamanho = vetor.length -1;
		
		System.out.println(encontrarValor(vetor, tamanho, 10));
	}
	
	public static boolean encontrarValor(int[] vetor, int tamanho, int valor) {
		if(vetor[tamanho] == valor) return true;
		else if(tamanho == 0) return false;
		else return encontrarValor(vetor,  tamanho -1, valor);		
	}
}