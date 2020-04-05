import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

class AppArgs {

    static String caminhoArquivo = "./dados/dados_airbnb.txt";

    public static void main(String[] args) throws IOException {
        boolean crescente = true;

        int quantidade = Integer.parseInt(args[0]);
        String ordem = args[1];

        Registro[] registros = Arquivo.carregarVetor(caminhoArquivo, quantidade);

        switch (ordem) {
            case "crescente":
                crescente = true;
                break;
            case "decrescente":
                crescente = false;
                break;
        }

        relatorio(registros, crescente, true);
    }

    public static void relatorio(Registro[] registros, boolean crescente, boolean aleatorio) throws IOException {
        System.out.println("Fazendo testes, aguarde...\n");
        Instant start, end;
        long tempoInsertion = 0;
        long tempoSelection = 0;
        long tempoBubble = 0;
        long tempoMerge = 0;
        long tempoHeap = 0;
        long tempoQuick = 0;

        start = Instant.now();
        Insertion.sort(registros, crescente);
        end = Instant.now();
        tempoInsertion = Duration.between(start, end).toMillis();

        if (aleatorio) {
            registros = Arquivo.carregarVetor(caminhoArquivo, registros.length);
        }

        start = Instant.now();
        Selection.sort(registros, crescente);
        end = Instant.now();
        tempoSelection = Duration.between(start, end).toMillis();

        if (aleatorio) {
            registros = Arquivo.carregarVetor(caminhoArquivo, registros.length);
        }

        start = Instant.now();
        Bubble.sort(registros, crescente);
        end = Instant.now();
        tempoBubble = Duration.between(start, end).toMillis();

        if (aleatorio) {
            registros = Arquivo.carregarVetor(caminhoArquivo, registros.length);
        }

        start = Instant.now();
        Merge.sort(registros, 0, registros.length - 1, crescente);
        end = Instant.now();
        tempoMerge = Duration.between(start, end).toMillis();

        if (aleatorio) {
            registros = Arquivo.carregarVetor(caminhoArquivo, registros.length);
        }

        start = Instant.now();
        Heap.sort(registros, crescente);
        end = Instant.now();
        tempoHeap = Duration.between(start, end).toMillis();

        if (aleatorio) {
            registros = Arquivo.carregarVetor(caminhoArquivo, registros.length);
        }

        start = Instant.now();
        Quick.sort(registros, crescente);
        end = Instant.now();
        tempoQuick = Duration.between(start, end).toMillis();

        System.out.printf("Tempo gasto com %d registros:\n", registros.length);
        System.out.printf("\nInsertion sort %.3f segundos", tempoInsertion / 1000d);
        System.out.printf("\nSelection sort %.3f segundos", tempoSelection / 1000d);
        System.out.printf("\nBubble sort %.3f segundos", tempoBubble / 1000d);
        System.out.printf("\nMerge sort %.3f segundos", tempoMerge / 1000d);
        System.out.printf("\nHeap sort %.3f segundos", tempoHeap / 1000d);
        System.out.printf("\nQuick sort %.3f segundos\n\n", tempoQuick / 1000d);

        String nomeArquivo = registros.length + "";

        Arquivo.salvarTestes(nomeArquivo, tempoInsertion, tempoSelection, tempoBubble, tempoMerge, tempoHeap,
                tempoQuick);

        Arquivo.salvarTempos(nomeArquivo, tempoInsertion, tempoSelection, tempoBubble, tempoMerge, tempoHeap,
        tempoQuick);

    }
}