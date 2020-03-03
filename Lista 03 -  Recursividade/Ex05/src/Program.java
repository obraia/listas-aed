
public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(somaDosTermo(10));
	}
	
	public static int somaDosTermo(int n) {
		if(n == 1) return n;
		else return n + somaDosTermo(n -1);
	}

}
