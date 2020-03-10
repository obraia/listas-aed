package ex06;

import java.util.Scanner;

/**
 * @author bryan
 */

public class Ex06 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite dois números: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        sc.close();

        if ((a + b) % 2 == 0) System.out.println("A soma dos números é par"); 
        else System.out.println("A soma dos números é ímpar");
    }

}
