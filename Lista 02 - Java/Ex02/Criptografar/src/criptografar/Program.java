package criptografar;

import java.util.ArrayList;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        ArquivoTextoEscrita arquivoEscrita = new ArquivoTextoEscrita();
        ArquivoTextoLeitura arquivoLeitura = new ArquivoTextoLeitura();

        ArrayList<String> texto = new ArrayList();
        ArrayList<String> textoCriptografado;

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o nome do arquivo para criptografá-lo: ");
        String nomeArquivoTexto = sc.nextLine();

        arquivoLeitura.abrirArquivo(nomeArquivoTexto + ".txt");
        
        String textoLinha = arquivoLeitura.ler();
        
        if(textoLinha == null) sc.nextLine();

        while (textoLinha != null) {
            texto.add(textoLinha);
            textoLinha = arquivoLeitura.ler();
        }

        arquivoLeitura.fecharArquivo();

        System.out.print("Digite o nome do arquivo chave: ");
        String nomeArquivoChave = sc.nextLine();
        
        arquivoLeitura.abrirArquivo(nomeArquivoChave + ".txt");
        String chaveLinha = arquivoLeitura.ler();     
        String[] chave = chaveLinha.split((";"));

        textoCriptografado = Criptografar(texto, chave);
        
        arquivoEscrita.abrirArquivo(nomeArquivoTexto + " (crypted).txt");

        for (int i = 0; i < texto.size(); i++) {
            arquivoEscrita.escrever(textoCriptografado.get(i));
        }

        arquivoEscrita.fecharArquivo();     
    }

    public static ArrayList<String> Criptografar(ArrayList<String> texto, String[] chave) {

        ArrayList<String> textoCriptografado = new ArrayList();

        for (int i = 0; i < texto.size(); i++) {
            char[] aux = texto.get(i).toCharArray();

            for (int j = 0; j < chave.length; j++) {

                switch (chave[j]) {
                    case "invert":
                        aux = InverterFrase(aux);
                        break;
                    case "sum":
                        aux = SomarCaracteres(aux, 3);
                        break;
                    case "sub":
                        aux = SubtrairCaracteres(aux, 2);
                        break;
                }
            }

            textoCriptografado.add(new String(aux));
        }

        return textoCriptografado;
    }

    public static char[] InverterFrase(char[] frase) {
        char[] aux = new char[frase.length];

        for (int i = 0; i < frase.length; i++) {
            aux[i] = frase[(frase.length - 1) - i];
        }

        return aux;
    }

    public static char[] SomarCaracteres(char[] frase, int valor) {
        char[] aux = new char[frase.length];

        for (int i = 0; i < frase.length; i++) {

            aux[i] = (frase[i] += valor);
        }

        return aux;
    }

    public static char[] SubtrairCaracteres(char[] frase, int valor) {
        char[] aux = new char[frase.length];

        for (int i = 0; i < frase.length; i++) {

            aux[i] = (frase[i] -= valor);
        }

        return aux;
    }
    
}
