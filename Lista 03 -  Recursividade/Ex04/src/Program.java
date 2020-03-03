
public class Program {

	public static void main(String[] args) {
		System.out.println(AlgoritmoDeEuclides(10, 1000));
	}
	
	public static int AlgoritmoDeEuclides(int numero, int numero2) {
		if(numero2 == 0) return numero;
		return AlgoritmoDeEuclides(numero2, numero % numero2);
	}

}
