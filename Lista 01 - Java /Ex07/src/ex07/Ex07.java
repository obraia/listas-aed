package ex07;

import java.util.Scanner;

/**
 * @author bryan
 */
public class Ex07 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int quantidadeVeiculos = 5;
        double[] velocidades = new double[quantidadeVeiculos];
        int quantidadeMultas = 0;
        double valorTotalArrecadado = 0;

        for (int i = 0; i < quantidadeVeiculos; i++) {

            System.out.printf("Digite a velocidade do %dº veículo: ", (i + 1));
            velocidades[i] = sc.nextDouble();
        }

        sc.close();

        for (int i = 0; i < velocidades.length; i++) {

            if (velocidades[i] > 60) {
                quantidadeMultas++;
                valorTotalArrecadado += 150;
            }
        }

        System.out.println("\nA quantidade de veículos multados foi: " + quantidadeMultas);
        System.out.printf("Com um valor total arrecadado de R$ %.2f \n", valorTotalArrecadado);

    }

}
