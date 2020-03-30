package ex09;

import java.util.Scanner;

/**
 * @author bryan
 */
public class Ex09 {

    public static void main(String[] args) {    

        boolean loop = true;
        int quantidadeNumeros = 3;
        double[] valores = new double[quantidadeNumeros];
        double[] pesos = new double[quantidadeNumeros];

        do {

            byte opc = Menu();
            
            System.out.println("");

            switch (opc) {

                case 1:
                    
                    ObterNumerosMediaAritmetica(valores);
                    System.out.printf("\nA média aritmética é: %.2f \n\n", MediaAritmetica(valores));

                    break;

                case 2:

                    ObterNumerosMediaPonderada(valores, pesos);
                    System.out.printf("\nA média ponderada é: %.2f \n\n", MediaPonderada(valores, pesos));
                    break;

                case 3:

                    ObterNumerosMediaPonderada(valores, pesos);
                    System.out.printf("\nA média aritmética é: %.2f \n", MediaAritmetica(valores));
                    System.out.printf("A média ponderada é: %.2f \n\n", MediaPonderada(valores, pesos));

                    break;

                case 4:

                    loop = false;

                    break;

                default:

                    System.out.println("Opção inválida!");

                    break;
            }

        } while (loop == true);
    }

    public static byte Menu() {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Média Aritmética");
        System.out.println("2. Média Ponderada");
        System.out.println("3. Média Aritmética e Ponderada");
        System.out.println("4. Sair\n");

        System.out.print("Digite uma opção: ");

        return sc.nextByte();
    }

    public static void ObterNumerosMediaAritmetica(double[] valores) {

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < valores.length; i++) {
            System.out.printf("Digite o %dº valor: ", (i + 1));
            valores[i] = sc.nextDouble();
        }

    }

    public static void ObterNumerosMediaPonderada(double[] valores, double[] pesos) {

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < valores.length; i++) {
            System.out.printf("Digite o %dº valor: ", (i + 1));
            valores[i] = sc.nextDouble();
            System.out.printf("Digite o %dº peso: ", (i + 1));
            pesos[i] = sc.nextInt();
        }

    }

    public static double MediaAritmetica(double[] valores) {

        double soma = 0;

        for (int i = 0; i < valores.length; i++) {
            soma += valores[i];
        }

        return soma / valores.length;
    }

    public static double MediaPonderada(double[] numeros, double[] pesos) {

        double soma = 0;
        double somaPesos = 0;

        for (int i = 0; i < numeros.length; i++) {
            soma += numeros[i] * pesos[i];
        }

        for (int i = 0; i < numeros.length; i++) {
            somaPesos += pesos[i];
        }

        return soma / somaPesos;
    }

}
