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

        int quantVeiculos = 5;
        double[] velocidades = new double[quantVeiculos];
        int quantMultas = 0;
        double valorArrecadado = 0;

        for (int i = 0; i < quantVeiculos; i++) {
            
            System.out.println("Digite a velocidade do " + (i+1) + "º veículo");
            velocidades[i] = sc.nextDouble();
        }
        
        for (int i = 0; i < velocidades.length; i++) {
            
            if(velocidades[i] > 60){
                quantMultas++;
                valorArrecadado += 150;
            }
        }
        
        System.out.println("A quantidade de veículos multados foi: " + quantMultas);
        System.out.println("Com um valor total arrecadado de R$ " + valorArrecadado);

    }

}
