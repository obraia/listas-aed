package ex10;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author bryan
 */

public class Ex10 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int quantidadeNumeros = 6;

        ArrayList<Integer> numeros = new ArrayList<>();
        ArrayList<Integer> numerosPares = new ArrayList<>();
        ArrayList<Integer> numerosImpares = new ArrayList<>();

        int somaPares = 0;
        int somaImpares = 0;

        for (int i = 0; i < quantidadeNumeros; i++) {
            System.out.printf("Digite o %dº valor: ", (i + 1));
            numeros.add(sc.nextInt());
        }

        // --> Verificando pares e ímpares e fazendo as somas
        for (int i = 0; i < numeros.size(); i++) {

            if (numeros.get(i) % 2 == 0) {
                numerosPares.add(numeros.get(i));
                somaPares += numeros.get(i);
            } else {
                numerosImpares.add(numeros.get(i));
                somaImpares += numeros.get(i);
            }
        }

        System.out.println("\na) Números pares:");

        for (int i = 0; i < numerosPares.size(); i++) {
            System.out.println(numerosPares.get(i));
        }

        System.out.println("\nb) Soma de todos números pares: " + somaPares);

        System.out.println("\nc) Números ímpares:");

        for (int i = 0; i < numerosImpares.size(); i++) {
            System.out.println(numerosImpares.get(i));
        }

        System.out.println("\nd) Quantidade de números ímpares: " + numerosImpares.size());
    }
}
