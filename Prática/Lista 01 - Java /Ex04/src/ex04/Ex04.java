package ex04;

import java.util.Scanner;

/**
 * @author bryan
 */

public class Ex04 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean loop = true;

        do {

            System.out.println("1. Soma de dois números");
            System.out.println("2. Raiz quadrada de um número");
            System.out.println("0. Sair");

            System.out.print("Digite uma opção: ");
            byte opc = sc.nextByte();

            switch (opc) {

                case 1:

                    System.out.print("Digite dois números para soma-los: ");

                    double a = sc.nextDouble();
                    double b = sc.nextDouble();
                    
                    sc.close();

                    System.out.printf("%.0f + %.0f = %.0f \n", a, b, (a + b));

                    break;

                case 2:

                    System.out.print("Digite um número para obter sua raiz: ");

                    int c = sc.nextInt();
                    
                    sc.close();

                    System.out.printf("A raiz de %d é %.0f \n", c, Math.sqrt(c));

                    break;

                case 0:

                    loop = false;

                    break;

                default:

                    System.out.println("Opção inválida!");

                    break;
            }

        } while (loop == true);
    }

}
