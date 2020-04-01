import java.io.FileNotFoundException;
import java.util.Scanner;

class App {
    public static void main(String[] args) throws FileNotFoundException {

        String caminhoArquivo = "./dados/dados_airbnb.txt";

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
                    System.out.println("Ordenando vetor...\n");
                    tempoInicial = System.currentTimeMillis();
                    relatorio(registros, crescente);
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

        //Registro.ExibirResumo(registros);
        System.out.printf("\nTempo total gasto %.5f segundos%n\n", (tempoFinal - tempoInicial) / 1000d);
    }

    public static void menuMetodoOrdenamento() {
        clear();
        System.out.println("1. Inserção \n2. Seleção \n3. Bolha \n4. Mergesort \n5. Heapsort \n6. Quicksort \n7. Relatório completo\n");
        System.out.print("Escolha um método de ordenação: ");
    }

    public static void menuQuantidade() {
        clear();
        for (int i = 1; i <= 7; i++) {
            System.out.printf("%d. %d registros\n", i, (int) Math.pow(2.0, i) * 1000);
        }
        System.out.print("\nEscolha a quantidade de registros: ");
    }

    public static void relatorio(Registro[] registros, boolean crescente) {
        long tempInsertionI = 0, tempInsertionF = 0;
        long tempSelectionI = 0, tempSelectionF = 0;
        long tempBubbleI = 0, tempBubbleF = 0;
        long tempMergeI = 0, tempMergeF = 0;
        long tempHeapI = 0, tempHeapF = 0;
        long tempQuickI = 0, tempQuickF = 0;

        tempInsertionI = System.currentTimeMillis();
        Insertion.sort(registros, crescente);
        tempInsertionF = System.currentTimeMillis();

        tempSelectionI = System.currentTimeMillis();
        Selection.sort(registros, crescente);
        tempSelectionF = System.currentTimeMillis();

        tempBubbleI = System.currentTimeMillis();
        Bubble.sort(registros, crescente);
        tempBubbleF = System.currentTimeMillis();

        tempMergeI = System.currentTimeMillis();
        Merge.sort(registros, 0, registros.length - 1, crescente);
        tempMergeF = System.currentTimeMillis();

        tempHeapI = System.currentTimeMillis();
        Heap.sort(registros, crescente);
        tempHeapF = System.currentTimeMillis();

        tempQuickI = System.currentTimeMillis();
        Quick.sort(registros, crescente);
        tempQuickF = System.currentTimeMillis();

        System.out.println("Tempo gasto em cada método de ordenamento: ");
        System.out.printf("\nInsertion sort %.5f segundos%n", (tempInsertionF - tempInsertionI) / 1000d);
        System.out.printf("\nSelection sort %.5f segundos%n", (tempSelectionF-tempSelectionI) / 1000d);
        System.out.printf("\nBubble sort %.5f segundos%n", (tempBubbleF - tempBubbleI) / 1000d);
        System.out.printf("\nMerge sort %.5f segundos%n", (tempMergeF - tempMergeI) / 1000d);
        System.out.printf("\nHeap sort %.5f segundos%n", (tempHeapF - tempHeapI) / 1000d);
        System.out.printf("\nQuick sort %.5f segundos%n\n", (tempQuickF - tempQuickI) / 1000d);
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