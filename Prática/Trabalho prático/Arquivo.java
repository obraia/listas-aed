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

    public static void salvarTestes(String nomeArquivo, long tempoInsertion, long tempoSelection, long tempoBubble,
            long tempoMerge, long tempoHeap, long tempoQuick) throws IOException {
        File arquivo = new File("./testes/relatorios/" + nomeArquivo + ".txt");
        FileWriter fw = new FileWriter("./testes/relatorios/" + nomeArquivo + ".txt", true);

        if (!arquivo.exists()) {
            arquivo.createNewFile();
        }
        String linha = String.format(
                "Insertion: %.3f \nSelection: %.3f \nBubble: %.3f \nMerge: %.3f \nHeap: %.3f \nQuick: %.3f\n\n",
                tempoInsertion / 1000d, tempoSelection / 1000d, tempoBubble / 1000d, tempoMerge / 1000d,
                tempoHeap / 1000d, tempoQuick / 1000d);

        linha = linha.replaceAll(",", ".");
        fw.write(linha);
        fw.close();
    }

    public static void salvarTempos(String nomeArquivo, long tempoInsertion, long tempoSelection, long tempoBubble,
            long tempoMerge, long tempoHeap, long tempoQuick) throws IOException {

        File arquivo = new File("./testes/tempos/" + nomeArquivo + ".txt");
        FileWriter fw = new FileWriter("./testes/tempos/" + nomeArquivo + ".txt", true);

        if (!arquivo.exists()) {
            arquivo.createNewFile();
        }
        String linha = String.format("%.3f;%.3f;%.3f;%.3f;%.3f;%.3f\n", tempoInsertion / 1000d, tempoSelection / 1000d,
                tempoBubble / 1000d, tempoMerge / 1000d, tempoHeap / 1000d, tempoQuick / 1000d);

        linha = linha.replaceAll(",", ".");
        fw.write(linha);
        fw.close();
    }
}
