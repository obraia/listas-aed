package ex09;

import java.util.Scanner;

/**
 * @author bryan
 */
public class Ex09 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        int quantNumeros = 7;
        double[] vetorNumeros = new double[quantNumeros];
        double[] vetorPesos = new double[quantNumeros];

        do {

            byte opc = Menu();
                    
            switch (opc) {

                case 1:

                    for (int i = 0; i < vetorNumeros.length; i++) {
                        System.out.print(String.format("Digite o %dº valor: ", (i + 1)));
                        vetorNumeros[i] = sc.nextDouble();
                    }

                    System.out.println("A média aritmética é: " + MediaAritmetica(vetorNumeros));

                    break;

                case 2:

                    for (int i = 0; i < vetorPesos.length; i++) {
                        System.out.print(String.format("Digite o %dº valor: ", (i + 1)));
                        vetorNumeros[i] = sc.nextDouble();
                        System.out.print(String.format("Digite o %dº peso: ", (i + 1)));
                        vetorPesos[i] = sc.nextInt();
                    }

                    System.out.println("A média ponderada é: " + MediaPonderada(vetorNumeros, vetorPesos));
                    break;

                case 3:

                    for (int i = 0; i < vetorPesos.length; i++) {
                        System.out.print(String.format("Digite o %dº valor: ", (i + 1)));
                        vetorNumeros[i] = sc.nextDouble();
                        System.out.print(String.format("Digite o %dº peso: ", (i + 1)));
                        vetorPesos[i] = sc.nextInt();
                    }

                    System.out.println("A média aritmética é: " + MediaAritmetica(vetorNumeros));
                    System.out.println("A média ponderada é: " + MediaPonderada(vetorNumeros, vetorPesos));

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

    public static double MediaAritmetica(double[] numeros) {

        double soma = 0;

        for (int i = 0; i < numeros.length; i++) {
            soma += numeros[i];
        }

        return soma / numeros.length;
    }

    public static double MediaPonderada(double[] numeros, double[] pesos) {

        double[] aux = new double[numeros.length];
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
