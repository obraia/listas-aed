import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

class AppArgs {

    static String caminhoArquivo = "./dados/dados_airbnb.txt";

    public static void main(String[] args) throws IOException {
        boolean ordernarCrescente = true;
        boolean entradaOrdenada = false;

        if (args.length == 3) {
            try {
                int quantidade = Integer.parseInt(args[0]);
                String ordemEntrada = args[1].toLowerCase();
                String ordemSaida = args[2].toLowerCase();

                Registro[] registros = Arquivo.carregarVetor(caminhoArquivo, quantidade);

                // Ordem em que os dados entrarão em cada método
                switch (ordemEntrada) {
                    case "crescente":
                        Quick.sort(registros, true);
                        entradaOrdenada = true;
                        break;
                    case "decrescente":
                        Quick.sort(registros, false);
                        entradaOrdenada = true;
                        break;
                    case "aleatorio":
                        entradaOrdenada = false;
                        break;
                }

                // Ordem em que os dados serão ordenados em cada método
                switch (ordemSaida) {
                    case "crescente":
                        ordernarCrescente = true;
                        break;
                    case "decrescente":
                        ordernarCrescente = false;
                        break;
                }

                relatorio(registros, ordernarCrescente, entradaOrdenada);
            } catch (Exception e) {
                System.out.println(
                        "Erro!\nPara testar o programa use: java AppArgs quantidadeRegistros ordemEntrada OrdemSaida");
                System.out.println("Ex: java AppArgs 2000 crescente crescente");
            }
        } else {
            System.out.println("Erro!\nPara testar o programa use: java AppArgs quantidadeRegistros ordemEntrada OrdemSaida");
            System.out.println("Ex: java AppArgs 2000 crescente crescente");
        }
    }

    // Esse método irá testar todos os métodos de ordenação em sequência
    public static void relatorio(Registro[] registros, boolean crescente, boolean entradaOrdenada) throws IOException {
        Instant start, end;
        long tempoInsertion = 0;
        long tempoSelection = 0;
        long tempoBubble = 0;
        long tempoMerge = 0;
        long tempoHeap = 0;
        long tempoQuick = 0;

        System.out.println("Fazendo testes, aguarde...\n");

        start = Instant.now(); // Obter tempo inicial
        Insertion.sort(registros, crescente);
        end = Instant.now(); // Obter tempo final
        tempoInsertion = Duration.between(start, end).toNanos(); // obeter tempo total em nanossegundos gasto no método

        // Ler o arquivo novamente em caso de entrada Aleatória
        if (!entradaOrdenada) {
            registros = Arquivo.carregarVetor(caminhoArquivo, registros.length);
        }

        start = Instant.now();
        Selection.sort(registros, crescente);
        end = Instant.now();
        tempoSelection = Duration.between(start, end).toNanos();

        if (!entradaOrdenada) {
            registros = Arquivo.carregarVetor(caminhoArquivo, registros.length);
        }

        start = Instant.now();
        Bubble.sort(registros, crescente);
        end = Instant.now();
        tempoBubble = Duration.between(start, end).toNanos();

        if (!entradaOrdenada) {
            registros = Arquivo.carregarVetor(caminhoArquivo, registros.length);
        }

        start = Instant.now();
        Merge.sort(registros, 0, registros.length - 1, crescente);
        end = Instant.now();
        tempoMerge = Duration.between(start, end).toNanos();

        if (!entradaOrdenada) {
            registros = Arquivo.carregarVetor(caminhoArquivo, registros.length);
        }

        start = Instant.now();
        Heap.sort(registros, crescente);
        end = Instant.now();
        tempoHeap = Duration.between(start, end).toNanos();

        if (!entradaOrdenada) {
            registros = Arquivo.carregarVetor(caminhoArquivo, registros.length);
        }

        start = Instant.now();
        Quick.sort(registros, crescente);
        end = Instant.now();
        tempoQuick = Duration.between(start, end).toNanos();

        // Exibição em tela de todos os tempos de determinado número de registros
        System.out.printf("Tempo gasto com %d registros:\n", registros.length);
        System.out.printf("\nInsertion sort %.3f segundos", tempoInsertion / 1000000000d);
        System.out.printf("\nSelection sort %.3f segundos", tempoSelection / 1000000000d);
        System.out.printf("\nBubble sort %.3f segundos", tempoBubble / 1000000000d);
        System.out.printf("\nMerge sort %.3f segundos", tempoMerge / 1000000000d);
        System.out.printf("\nHeap sort %.3f segundos", tempoHeap / 1000000000d);
        System.out.printf("\nQuick sort %.3f segundos\n\n", tempoQuick / 1000000000d);

        String nomeArquivo = registros.length + "";

        // Salvar mesmo testes exibido acima em um arquivo
        Arquivo.salvarTestes(nomeArquivo, tempoInsertion, tempoSelection, tempoBubble, tempoMerge, tempoHeap,
                tempoQuick);

        // Salvar tempos separados por ';' em um arquivo para calcular as médias
        // posteriormente
        Arquivo.salvarTempos(nomeArquivo, tempoInsertion, tempoSelection, tempoBubble, tempoMerge, tempoHeap,
                tempoQuick);
    }
}