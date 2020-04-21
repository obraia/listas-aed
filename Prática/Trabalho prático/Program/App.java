import java.io.IOException;
import java.util.Scanner;
import java.time.Duration;
import java.time.Instant;

class App {

    static String caminhoArquivo = "./dados/dados_airbnb.txt";

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        Instant start, end; // Armazenar tempo inicial e final de cada teste
        long tempoTotal = 0; // Armazenar tempo total de execução de cada teste
        boolean entradaOrdenada = false;
        boolean saidaCrescente = false;
        int quantidade = 0;
        boolean loop = false;
        byte opc = 0;

        // Obeter quantidade de registros para os testes
        do {
            menuQuantidade();
            opc = sc.nextByte();

            if (opc >= 1 && opc <= 7) {
                quantidade = (int) Math.pow(2.0, opc) * 1000;
                loop = false;
            } else {
                System.out.println();
                System.out.println("Opção inválida, tente novamente.\n");
                loop = true;
                sleep(1000);
            }
        } while (loop);

        Registro[] registros = Arquivo.carregarVetor(caminhoArquivo, quantidade);

        System.out.println();

        // Ordem em que os dados entrarão em cada método
        do {
            System.out.print(
                    "Ordem de entrada\n\n1. Ordem crescente \n2. Ordem descrescente \n3. Aleatório \n\nEscolha uma opção: ");
            opc = sc.nextByte();

            switch (opc) {
                case 1:
                    Quick.sort(registros, true);
                    entradaOrdenada = true;
                    loop = false;
                    break;
                case 2:
                    Quick.sort(registros, false);
                    entradaOrdenada = true;
                    loop = false;
                    break;
                case 3:
                    break;
                default:
                    System.out.println();
                    System.out.println("Opção inválida, tente novamente.\n");
                    loop = true;
                    sleep(1000);
                    break;
            }
        } while (loop);

        System.out.println();

        // Ordem em que os dados serão ordenados em cada método
        do {
            System.out.print("Ordem de saída\n\n1. Ordem crescente \n2. Ordem descrescente \n\nEscolha uma opção: ");
            opc = sc.nextByte();

            switch (opc) {
                case 1:
                    saidaCrescente = true;
                    loop = false;
                    break;
                case 2:
                    saidaCrescente = false;
                    loop = false;
                    break;
                default:
                    System.out.println();

                    System.out.println("Opção inválida, tente novamente.\n");
                    loop = true;
                    sleep(1000);
                    break;
            }
        } while (loop);

        System.out.println();

        // Escolher qual método de ordenamento será utilizado
        // Opção 7. é um relatório completo com todos os métodos
        do {
            menuMetodoOrdenamento();
            opc = sc.nextByte();

            switch (opc) {
                case 1:
                    System.out.println("Ordenando vetor...\n");
                    start = Instant.now(); // Obter tempo inicial
                    Insertion.sort(registros, saidaCrescente);
                    end = Instant.now(); // Obter tempo final
                    // Obter tempo total em que o método gastou para ordenar
                    tempoTotal = Duration.between(start, end).toNanos();
                    loop = false;
                    break;
                case 2:
                    System.out.println("Ordenando vetor...\n");
                    start = Instant.now();
                    Selection.sort(registros, saidaCrescente);
                    end = Instant.now();
                    tempoTotal = Duration.between(start, end).toNanos();
                    loop = false;
                    break;
                case 3:
                    System.out.println("Ordenando vetor...\n");
                    start = Instant.now();
                    Bubble.sort(registros, saidaCrescente);
                    end = Instant.now();
                    tempoTotal = Duration.between(start, end).toNanos();
                    loop = false;
                    break;
                case 4:
                    System.out.println("Ordenando vetor...\n");
                    start = Instant.now();
                    Merge.sort(registros, 0, registros.length - 1, saidaCrescente);
                    end = Instant.now();
                    tempoTotal = Duration.between(start, end).toNanos();
                    loop = false;
                    break;
                case 5:
                    System.out.println("Ordenando vetor...\n");
                    start = Instant.now();
                    Heap.sort(registros, saidaCrescente);
                    end = Instant.now();
                    tempoTotal = Duration.between(start, end).toNanos();
                    loop = false;
                    break;
                case 6:
                    System.out.println("Ordenando vetor...\n");
                    start = Instant.now();
                    Quick.sort(registros, saidaCrescente);
                    end = Instant.now();
                    tempoTotal = Duration.between(start, end).toNanos();
                    loop = false;
                    break;
                case 7:
                    System.out.println("Fazendo testes, aguarde...\n");
                    relatorio(registros, saidaCrescente, entradaOrdenada);
                    loop = false;
                    break;
                default:
                    System.out.println();
                    System.out.println("Opção inválida, tente novamente.\n");
                    loop = true;
                    sleep(1000);
                    break;
            }
        } while (loop);

        if (opc != 7) {
            System.out.printf("Tempo total gasto %.3f segundos%n\n", tempoTotal / 1000000000d);
        }
    }

    public static void menuMetodoOrdenamento() {

        System.out.println(
                "1. Inserção \n2. Seleção \n3. Bolha \n4. Mergesort \n5. Heapsort \n6. Quicksort \n7. Relatório completo\n");
        System.out.print("Escolha um método de ordenação: ");
    }

    public static void menuQuantidade() {

        for (int i = 1; i <= 7; i++) {
            System.out.printf("%d. %d registros\n", i, (int) Math.pow(2.0, i) * 1000);
        }
        System.out.print("\nEscolha a quantidade de registros: ");
    }

    public static void relatorio(Registro[] registros, boolean crescente, boolean entradaOrdenada) throws IOException {
        Instant start, end;
        long tempoInsertion = 0;
        long tempoSelection = 0;
        long tempoBubble = 0;
        long tempoMerge = 0;
        long tempoHeap = 0;
        long tempoQuick = 0;

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
    }

    public static void sleep(long tempo) {
        try {
            Thread.sleep(tempo);
        } catch (Exception e) {
        }
    }
}