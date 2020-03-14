class Ex05 {
    public static void main(String[] args) {
        int n = 32; // --> Valor máximo
        if (n % 2 != 0) n -= 1;
        
        System.out.println(calcularCosseno(n));
    }
    
    public static double calcularCosseno(int n) {
        if (n == 0) return 1;
        else return (1.0 / fatorial(n*2)) - calcularCosseno(n - 1);
    }

    public static long fatorial(int numero) {
        if (numero == 0) {
            return 1;
        } else {
            return numero * fatorial(numero - 1);
        }
    }
}