
public class Program {

	public static void main(String[] args) {
		System.out.println(calcular(4));
	}
	
	public static double calcular(double n) {
		if(n == 1) return n;
		else return (1/n + calcular((n - 1)));
	}

}
