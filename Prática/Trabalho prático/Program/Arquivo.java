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

    // Ler todo arquivo e salvar em vetor do tipo Registro
    public static Registro[] carregarVetor(String caminhoArquivo, int length) throws FileNotFoundException {
        Arquivo arquivo = new Arquivo(caminhoArquivo);
        Registro vetorRegistro[] = new Registro[length];

        String linha = arquivo.readLine();

        for (int i = 0; i < length; i++) {
            linha = arquivo.readLine();

            String aux[] = linha.split("\t");

            int roomId = Integer.parseInt(aux[0]);
            int hostId = Integer.parseInt(aux[1]);
            String roomType = aux[2];
            String country = aux[3];
            String city = aux[4];
            String neighborhood = aux[5];
            float reviews = Float.parseFloat(aux[6]);
            float overallSatisfaction = Float.parseFloat(aux[7]);
            int accommodates = Integer.parseInt(aux[8]);
            int bedrooms = (int) Float.parseFloat(aux[9]);
            float price = Float.parseFloat(aux[10]);
            String propertyType = aux[11];
            vetorRegistro[i] = new Registro(roomId, hostId, roomType, country, city, neighborhood, reviews,
                    overallSatisfaction, accommodates, bedrooms, price, propertyType);
        }

        arquivo.close();

        return vetorRegistro;
    }
}
