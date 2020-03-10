public class Program {

    public static void main(String[] args) {
        String palavra = "Socorram-me em Marrocos";
        palavra = palavra.replaceAll("[ -]", "").toLowerCase(); // Remover espaços e hífens     
        int tamanho = palavra.length();
        System.out.println("A palavra é um políndromo: " + palindromo(palavra, tamanho));
    }
	
    public static boolean palindromo(String palavra, int posicao) {
        int length = palavra.length();

        if (posicao == 0) {
            return (palavra.charAt(posicao) == palavra.charAt(length - 1));
        } 
        else if (palavra.charAt((length - posicao)) == palavra.charAt(posicao - 1)) {
            return palindromo(palavra, posicao - 1);
        } 
        else {
            return false;
        }
    }
}
