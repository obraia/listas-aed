class Ex01 {
	public static void main(String[] args) {
		System.out.println(multiplicacao(5,3));
	}
	
	public static int multiplicacao(int numA, int numB) {
		if(numB == 1) return numA;
		else if((numA == 0 || numB == 0)) return 0;
		else return numA + multiplicacao(numA, numB - 1);	
	}

}