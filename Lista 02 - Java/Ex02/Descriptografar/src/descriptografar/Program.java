package descriptografar;

import java.util.ArrayList;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        ArquivoTextoEscrita arquivoEscrita = new ArquivoTextoEscrita();
        ArquivoTextoLeitura arquivoLeitura = new ArquivoTextoLeitura();
        
        ArrayList<String> textoCriptografado = new ArrayList();
        ArrayList<String> textoDescriptografado;

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o nome do arquivo para descriptografá-lo: ");
        String nomeArquivoTexto = sc.nextLine();

        arquivoLeitura.abrirArquivo(nomeArquivoTexto + ".txt");

        String textoLinha = arquivoLeitura.ler();

        while (textoLinha != null) {
            textoCriptografado.add(textoLinha);
            textoLinha = arquivoLeitura.ler();
        }

        arquivoLeitura.fecharArquivo();

        System.out.print("Digite o nome do arquivo chave: ");
        String nomeArquivoChave = sc.nextLine();

        arquivoLeitura.abrirArquivo(nomeArquivoChave + ".txt");
        String chaveLinha = arquivoLeitura.ler();
        String[] chave = chaveLinha.split((";"));

        textoDescriptografado = Descriptografar(textoCriptografado, chave);

        arquivoEscrita.abrirArquivo(nomeArquivoTexto + " (decrypted).txt");

        for (int i = 0; i < textoDescriptografado.size(); i++) {
            arquivoEscrita.escrever(textoDescriptografado.get(i));
        }

        arquivoEscrita.fecharArquivo();

    }

    public static ArrayList<String> Descriptografar(ArrayList<String> textoCriptografado, String[] chave) {

        ArrayList<String> textoDescriptografado = new ArrayList();

        for (int i = 0; i < textoCriptografado.size(); i++) {
            char[] aux = textoCriptografado.get(i).toCharArray();

            for (int j = 0; j < chave.length; j++) {

                switch (chave[j]) {
                    case "invert":
                        aux = InverterFrase(aux);
                        break;
                    case "sum":
                        aux = SubtrairCaracteres(aux, 3);
                        break;
                    case "sub":
                        aux = SomarCaracteres(aux, 2);
                        break;
                }
            }

            textoDescriptografado.add(new String(aux));
        }

        return textoDescriptografado;
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
