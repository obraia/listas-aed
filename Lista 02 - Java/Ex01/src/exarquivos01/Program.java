/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exarquivos01;

import java.util.ArrayList;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        ArquivoTextoEscrita arquivoEscrita = new ArquivoTextoEscrita();
        ArquivoTextoLeitura arquivoLeitura = new ArquivoTextoLeitura();

        ArrayList<String> texto = new ArrayList();

        Scanner sc = new Scanner(System.in);

        String frase = "";

        System.out.println("Digite um texto e pressione enter, ou 'sair' para finalizar");

        do {
            frase = sc.nextLine();
            if (!frase.equals("sair")) {
                texto.add(frase);
            }
        } while (!frase.equals("sair"));

        System.out.print("Digite o nome do arquivo para salvar: ");
        String nomeArquivo = sc.nextLine() + ".txt";

        arquivoEscrita.abrirArquivo(nomeArquivo);

        for (int i = 0; i < texto.size(); i++) {
            arquivoEscrita.escrever(texto.get(i));
        }

        arquivoEscrita.fecharArquivo();

        arquivoLeitura.abrirArquivo(nomeArquivo);

        String linha = arquivoLeitura.ler();

        while (linha != null) {
            System.out.println(linha);
            linha = arquivoLeitura.ler();
        }

    }

}
