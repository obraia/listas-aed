/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex03;

import java.util.Scanner;

/**
 * @author bryan
 */

public class Ex03 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o salário do funcionário: ");
        float salario = sc.nextInt();
        
        sc.close();

        float aumento = 0;

        if (salario <= 1200) {
            aumento = salario * 0.1f;
        } else if (salario > 1200) {
            aumento = salario * 0.05f;
        }

        salario += aumento;

        System.out.printf("O funcionario teve um aumento de R$ %.2f e seu novo salário é R$ %.2f \n", aumento, salario);
    }
}
