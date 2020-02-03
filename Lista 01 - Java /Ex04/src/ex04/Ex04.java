/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex04;

import java.io.Console;
import java.util.Scanner;

/**
 *
 * @author bryan
 */
public class Ex04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

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

                    System.out.println("A soma dos dois números é: " + (a + b));

                    break;

                case 2:

                    System.out.print("Digite um números para obter sua raiz: ");

                    int c = sc.nextInt();
                    
                    System.out.println("A raiz de " + c+ " é " + Math.sqrt(c));

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
