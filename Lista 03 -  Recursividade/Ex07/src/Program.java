
public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String palavra = "arara";
		int tamanho = palavra.length() - 1;
		
		System.out.println(palindromo(palavra, tamanho));
	}
	
	public static boolean palindromo(String palavra, int tamanho) {
		if(palavra.charAt((palavra.length() - tamanho)) == palavra.charAt(tamanho)) {
			return true;
		}
		else return false;
	}
}
