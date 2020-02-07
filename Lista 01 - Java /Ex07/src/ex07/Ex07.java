/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex07;

import java.util.Scanner;

/**
 *
 * @author bryan
 */
public class Ex07 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner sc = new Scanner(System.in);

        int quantidadeVeiculos = 5;
        double[] velocidades = new double[quantidadeVeiculos];
        int quantidadeMultas = 0;
        double valorTotalArrecadado = 0;

        for (int i = 0; i < quantidadeVeiculos; i++) {
            
            System.out.println("Digite a velocidade do " + (i+1) + "º veículo");
            velocidades[i] = sc.nextDouble();
        }
        
        for (int i = 0; i < velocidades.length; i++) {
            
            if(velocidades[i] > 60){
                quantidadeMultas++;
                valorTotalArrecadado += 150;
            }
        }
        
        System.out.println("\nA quantidade de veículos multados foi: " + quantidadeMultas);
        System.out.println("Com um valor total arrecadado de R$ " + valorTotalArrecadado);

    }

}
