package ex19;

import java.util.Scanner;

/**
 * @author bryan
 */
public class Ex19 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double numero;
        int pisoNumero;
        int tetoNumero;

        System.out.print("Digite um número real: ");
        numero = sc.nextDouble();

        pisoNumero = Piso(numero);
        tetoNumero = Teto(numero);

        System.out.println("Piso: " + pisoNumero);
        System.out.println("Teto: " + tetoNumero);

    }

    public static int Piso(double numero) {
        return (int) numero;
    }

    public static int Teto(double numero) {

        if ((int) numero != numero) {
            return (int) (numero + 1);
        } else {
            return (int) numero;
        }

    }
}
