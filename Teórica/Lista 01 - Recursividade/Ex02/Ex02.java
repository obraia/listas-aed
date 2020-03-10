class Ex02 {
    public static void main(String[] args) {
		System.out.println(divisao(10,1));
	}
	
	public static int divisao(int numA, int numB) {
		if(numB > numA) return 0;
		else return 1 + divisao((numA-numB), numB);	
	}
}