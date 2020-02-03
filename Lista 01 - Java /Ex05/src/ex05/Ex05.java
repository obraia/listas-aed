/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex05;

import java.util.Scanner;

/**
 *
 * @author bryan
 */
public class Ex05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner sc = new Scanner(System.in);

        int quantidadeNotas = 3;
        double somaNotas = 0;
        String mensagem = "";
 
        for (int i = 0; i < quantidadeNotas; i++) {

            System.out.print("Digite a " + (i+1) + "ª nota: ");
            somaNotas += sc.nextDouble();
        }

        double mediaAritmetica = somaNotas / quantidadeNotas;
        
        if(mediaAritmetica < 4) mensagem = "Reprovado";
        else if(mediaAritmetica < 6) mensagem = "Exame especial";
        else mensagem = "Aprovado";
        
        System.out.println("A média do aluno(a) é: " + mediaAritmetica + " e sua situação é: " + mensagem);

    }

}
