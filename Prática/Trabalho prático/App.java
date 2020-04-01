import java.io.FileNotFoundException;
import java.util.Scanner;

class App {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        String caminhoArquivo = "./arquivos/dados_airbnb.txt";
        long tempoInicial = 0, tempoFinal = 0;
        int quantidade = 0;
        byte opc = 0;
        boolean loop = false;

        do {
            menuQuantidade();
            opc = sc.nextByte();

            if (opc >= 1 && opc <= 7) {
                quantidade = (int) Math.pow(2.0, opc) * 1000;
                loop = false;
            } else {
                clear();
                System.out.print("Opção inválida, tente novamente ");
                loop = true;
                sleep(1000);
            }
        } while (loop);

        Registro vetor[] = Arquivo.ler(caminhoArquivo, quantidade);

        System.out.println("\n");

        do {
            menu();
            opc = sc.nextByte();
            clear();

            switch (opc) {
                case 1:
                    System.out.println("Ordenando vetor...\n");
                    tempoInicial = System.currentTimeMillis();
                    Insertion.sort(vetor);
                    tempoFinal = System.currentTimeMillis();
                    loop = false;
                    break;
                case 2:
                    System.out.println("Ordenando vetor...\n");
                    tempoInicial = System.currentTimeMillis();
                    Selection.sort(vetor);
                    tempoFinal = System.currentTimeMillis();
                    loop = false;
                    break;
                case 3:
                    System.out.println("Ordenando vetor...\n");
                    tempoInicial = System.currentTimeMillis();
                    Bubble.sort(vetor);
                    tempoFinal = System.currentTimeMillis();
                    loop = false;
                    break;
                case 4:
                    System.out.println("Ordenando vetor...\n");
                    tempoInicial = System.currentTimeMillis();
                    Merge.sort(vetor, 0, quantidade - 1);
                    tempoFinal = System.currentTimeMillis();
                    loop = false;
                    break;
                case 5:
                    System.out.println("Ordenando vetor...\n");
                    tempoInicial = System.currentTimeMillis();
                    Merge.sort(vetor, 0, quantidade - 1);
                    tempoFinal = System.currentTimeMillis();
                    loop = false;
                    break;
                case 6:
                    System.out.println("Ordenando vetor...\n");
                    tempoInicial = System.currentTimeMillis();
                    Quick.sort(vetor);
                    tempoFinal = System.currentTimeMillis();
                    loop = false;
                    break;
                default:
                    System.out.print("Opção inválida, tente novamente ");
                    loop = true;
                    sleep(1000);
                    break;
            }
        } while (loop);

        Registro.ExibirResumo(vetor);
        System.out.printf("\nTempo total gasto %.5f segundos%n\n", (tempoFinal - tempoInicial) / 1000d);
    }

    public static void menu() {
        clear();
        System.out.println("1. Inserção \n2. Seleção \n3. Bolha \n4. Mergesort \n5. Heapsort \n6. Quicksort\n");
        System.out.print("Escolha um método de ordenação: ");
    }

    public static void menuQuantidade() {
        clear();
        for (int i = 1; i <= 7; i++) {
            System.out.printf("%d. %d registros\n", i, (int) Math.pow(2.0, i) * 1000);
        }
        System.out.print("\nEscolha a quantidade de registros: ");
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