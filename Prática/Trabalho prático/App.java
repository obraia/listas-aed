import java.io.FileNotFoundException;
import java.util.Scanner;
import java.time.Duration;
import java.time.Instant;

class App {

    static String caminhoArquivo = "./dados/dados_airbnb.txt";

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(System.in);

        long tempoInicial = 0, tempoFinal = 0;
        boolean crescente = false;
        int quantidade = 0;
        boolean loop = false;
        byte opc = 0;

        do {
            menuQuantidade();
            opc = sc.nextByte();

            if (opc >= 1 && opc <= 7) {
                quantidade = (int) Math.pow(2.0, opc) * 1000;
                loop = false;
            } else {
                System.out.println();
                clear();
                System.out.println("Opção inválida, tente novamente.\n");
                loop = true;
                sleep(1000);
            }
        } while (loop);

        Registro[] registros = Arquivo.ler(caminhoArquivo, quantidade);

        System.out.println();

        do {
            clear();
            System.out.print("1. Ordem crescente \n2. Ordem descrescente \n\nEscolha uma opção: ");
            opc = sc.nextByte();
            clear();

            switch (opc) {
                case 1:
                    crescente = true;
                    loop = false;
                    break;
                case 2:
                    crescente = false;
                    loop = false;
                    break;
                default:
                    System.out.println();
                    clear();
                    System.out.println("Opção inválida, tente novamente.\n");
                    loop = true;
                    sleep(1000);
                    break;
            }
        } while (loop);

        System.out.println();

        do {
            menuMetodoOrdenamento();
            opc = sc.nextByte();
            clear();

            switch (opc) {
                case 1:
                    System.out.println("Ordenando vetor...\n");
                    tempoInicial = System.currentTimeMillis();
                    Insertion.sort(registros, crescente);
                    tempoFinal = System.currentTimeMillis();
                    loop = false;
                    break;
                case 2:
                    System.out.println("Ordenando vetor...\n");
                    tempoInicial = System.currentTimeMillis();
                    Selection.sort(registros, crescente);
                    tempoFinal = System.currentTimeMillis();
                    loop = false;
                    break;
                case 3:
                    System.out.println("Ordenando vetor...\n");
                    tempoInicial = System.currentTimeMillis();
                    Bubble.sort(registros, crescente);
                    tempoFinal = System.currentTimeMillis();
                    loop = false;
                    break;
                case 4:
                    System.out.println("Ordenando vetor...\n");
                    tempoInicial = System.currentTimeMillis();
                    Merge.sort(registros, 0, quantidade - 1, crescente);
                    tempoFinal = System.currentTimeMillis();
                    loop = false;
                    break;
                case 5:
                    System.out.println("Ordenando vetor...\n");
                    tempoInicial = System.currentTimeMillis();
                    Heap.sort(registros, crescente);
                    tempoFinal = System.currentTimeMillis();
                    loop = false;
                    break;
                case 6:
                    System.out.println("Ordenando vetor...\n");
                    tempoInicial = System.currentTimeMillis();
                    Quick.sort(registros, crescente);
                    tempoFinal = System.currentTimeMillis();
                    loop = false;
                    break;
                case 7:
                    System.out.println("Fazendo testes, aguarde...\n");
                    tempoInicial = System.currentTimeMillis();
                    relatorio(registros, crescente, true);
                    tempoFinal = System.currentTimeMillis();
                    loop = false;
                    break;
                default:
                    System.out.println();
                    clear();
                    System.out.println("Opção inválida, tente novamente.\n");
                    loop = true;
                    sleep(1000);
                    break;
            }
        } while (loop);

        System.out.printf("Tempo total gasto %.3f segundos%n\n", (tempoFinal - tempoInicial) / 1000d);
    }

    public static void menuMetodoOrdenamento() {
        clear();
        System.out.println(
                "1. Inserção \n2. Seleção \n3. Bolha \n4. Mergesort \n5. Heapsort \n6. Quicksort \n7. Relatório completo\n");
        System.out.print("Escolha um método de ordenação: ");
    }

    public static void menuQuantidade() {
        clear();
        for (int i = 1; i <= 7; i++) {
            System.out.printf("%d. %d registros\n", i, (int) Math.pow(2.0, i) * 1000);
        }
        System.out.print("\nEscolha a quantidade de registros: ");
    }

    public static void relatorio(Registro[] registros, boolean crescente, boolean aleatorio)
            throws FileNotFoundException {

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
            registros = Arquivo.ler(caminhoArquivo, registros.length);
        }

        start = Instant.now();
        Selection.sort(registros, crescente);
        end = Instant.now();
        tempoSelection = Duration.between(start, end).toMillis();

        if (aleatorio) {
            registros = Arquivo.ler(caminhoArquivo, registros.length);
        }

        start = Instant.now();
        Bubble.sort(registros, crescente);
        end = Instant.now();
        tempoBubble = Duration.between(start, end).toMillis();

        if (aleatorio) {
            registros = Arquivo.ler(caminhoArquivo, registros.length);
        }

        start = Instant.now();
        Merge.sort(registros, 0, registros.length - 1, crescente);
        end = Instant.now();
        tempoMerge = Duration.between(start, end).toMillis();

        if (aleatorio) {
            registros = Arquivo.ler(caminhoArquivo, registros.length);
        }

        start = Instant.now();
        Heap.sort(registros, crescente);
        end = Instant.now();
        tempoHeap = Duration.between(start, end).toMillis();

        if (aleatorio) {
            registros = Arquivo.ler(caminhoArquivo, registros.length);
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
    }

    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void sleep(long tempo) {
        try {
            Thread.sleep(tempo);
        } catch (Exception e) {
        }
    }
}