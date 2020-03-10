class Ex05 {
    public static void main(String[] args) {
        System.out.println(calcularCosseno(0));
    }

    public static double calcularCosseno( int denominador) {
        if (denominador == 12) {
            return (1.0 / fatorial(denominador));
        } else {
            return (1.0 / fatorial(denominador)) - calcularCosseno((denominador + 2));
        }
    }

    public static int fatorial(int numero) {
        if (numero == 0) {
            return 1;
        } else {
            return numero * fatorial(numero - 1);
        }
    }
}