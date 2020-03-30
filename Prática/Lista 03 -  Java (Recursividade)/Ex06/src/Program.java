
public class Program {

	public static void main(String[] args) {
		String palavra = "Thaís";
		int tamanho = palavra.length() - 1;
		char caracter = 't';

		palavra = palavra.toLowerCase();
		caracter = Character.toLowerCase(caracter);

		System.out.println(encontrarCaracter(palavra, tamanho, caracter));
	}

	public static boolean encontrarCaracter(String palavra, int tamanho, char caracter) {
		if (palavra.charAt(tamanho) == caracter) {
			return true;
		} else if (tamanho > 0) {
			return encontrarCaracter(palavra, tamanho - 1, caracter);
		} else {
			return false;
		}
	}

}
