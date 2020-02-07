package ex05;

import java.util.Scanner;

/**
 * @author bryan
 */
public class Ex05 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int quantidadeNotas = 3;
        double somaNotas = 0;
        String mensagem;

        for (int i = 0; i < quantidadeNotas; i++) {

            System.out.printf("Digite a %d ª nota: ", (i + 1));
            somaNotas += sc.nextDouble();
        }

        sc.close();

        double mediaAritmetica = somaNotas / quantidadeNotas;

        if (mediaAritmetica < 4) {
            mensagem = "Reprovado";
        } else if (mediaAritmetica < 6) {
            mensagem = "Exame especial";
        } else {
            mensagem = "Aprovado";
        }

        System.out.printf("A média do aluno(a) é %.2f e sua situação é %s \n", mediaAritmetica, mensagem);

    }

}
