
public class Program {

	public static void main(String[] args) {
		for (int i = 0; i <= 50; i++) {
			System.out.println(i + " - " + Fibonacci(i));
		}	
	}
	
	public static long Fibonacci(int n) {
		if(n < 2 && n >= 0) return n;
		else return  Fibonacci((n - 1)) + Fibonacci((n - 2));
	}
}


