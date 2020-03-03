
public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String palavra = "Bryan";
		int tamanhoPalavra = palavra.length() - 1;
		char caracter = 'B';
		
		System.out.println(encontrarCaracter(palavra, tamanhoPalavra, caracter));
	}
	
	public static boolean encontrarCaracter(String palavra, int tamanhoPalavra, char caracter) {
		if(palavra.charAt(tamanhoPalavra) == caracter) return true;
		else if(tamanhoPalavra > 0) return encontrarCaracter(palavra, tamanhoPalavra -1, caracter);
		else return false;
	}

}
