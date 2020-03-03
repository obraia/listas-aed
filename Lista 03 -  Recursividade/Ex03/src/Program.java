
public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(calcular(2));

	}
	
	public static double calcular(double n) {
		if(n == 1) return n;
		else return 1 + 1 / (1 + calcular((n - 1)));
	}

}
