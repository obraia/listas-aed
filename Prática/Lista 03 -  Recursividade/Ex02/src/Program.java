
public class Program {

	public static void main(String[] args) {
		System.out.println(potencia(2, 2));
	}
	
	public static int potencia(int base, int expoente) {
		if(expoente == 0) return 1;
		else if (expoente % 2 == 0) return potencia(base, expoente / 2) *  potencia(base, expoente / 2);
		else return base * potencia(base, expoente / 2) *  potencia(base, expoente / 2);
	}

}
