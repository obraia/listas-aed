
public class Program {

	public static void main(String[] args) {
		System.out.println(somaDosTermos(10));
	}
	
	public static int somaDosTermos(int n) {
		if(n == 1) return n;
		else return n + somaDosTermos(n -1);
	}

}
