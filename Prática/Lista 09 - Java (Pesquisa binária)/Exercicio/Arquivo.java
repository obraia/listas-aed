package program;

import java.io.*;

public class Arquivo {

    BufferedReader entrada;

    public Arquivo(String caminhoArquivo) {
        try {
            entrada = new BufferedReader(new FileReader(caminhoArquivo));
        } catch (FileNotFoundException excecao) {
            System.out.println("Arquivo não encontrado");
            System.out.println(excecao.getMessage());
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

    public void writeLine(String linha) {

    }

    // Ler todo arquivo e salvar em vetor do tipo Registro
    public static Produto[] carregar(String caminhoArquivo, int quantidadeProdutos) throws FileNotFoundException {
        Arquivo arquivo = new Arquivo(caminhoArquivo);

        Produto[] produtos = new Produto[quantidadeProdutos];
        int count = 0;

        String linha = arquivo.readLine();

        do {
            String[] aux = linha.split(";");

            long codigoDeBarras = Long.parseLong(aux[0]);
            String nome = aux[1];
            float preco = Float.parseFloat(aux[2]);

            produtos[count] = new Produto(codigoDeBarras, nome, preco);
            count++;
        } while ((linha = arquivo.readLine()) != null);

        arquivo.close();

        return produtos;
    }
}
