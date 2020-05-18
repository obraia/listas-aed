package src.utils;

import java.io.*;

public class Arquivo {

    BufferedReader entrada;

    public Arquivo(String caminhoArquivo) {
        try {
            entrada = new BufferedReader(new FileReader(caminhoArquivo));
        } catch (FileNotFoundException excecao) {
            System.out.println("Arquivo não encontrado");
        }
    }

    public void close() {
        try {
            entrada.close();
        } catch (IOException excecao) {
            System.out.println("Erro no fechamento do arquivo de leitura: " + excecao);
        }
    }

    public String readLine() {
        String linha;

        try {
            linha = entrada.readLine();
        } catch (EOFException excecao) { // Exceção de final de arquivo.
            return null;
        } catch (IOException excecao) {
            System.out.println("Erro de leitura: " + excecao);
            return null;
        }
        return linha;
    }
}
