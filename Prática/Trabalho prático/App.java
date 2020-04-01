import java.io.FileNotFoundException;
import java.util.Scanner;

class App {
    public static void main(String[] args) throws FileNotFoundException {
        clear();
        Scanner sc = new Scanner(System.in);

        int quantidade = 1000;
        Registro vetor[] = Arquivo.ler("./arquivos/dados_airbnb.txt", quantidade);
        Registro aux[] = new Registro[quantidade];

        long tempoInicial = 0, tempoFinal = 0;

        menu();
        byte opc = sc.nextByte();

        switch (opc) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                tempoInicial = System.currentTimeMillis();
                Bubble.sort(vetor);
                tempoFinal = System.currentTimeMillis();
                break;
            case 4:
                tempoInicial = System.currentTimeMillis();
                Merge.sort(vetor, 0, quantidade - 1);
                tempoFinal = System.currentTimeMillis();
                break;
            case 5:
                break;
            case 6:
                break;
            default:
                System.out.println("Opção inválida, tente novamente.");
                break;
        }

        Registro.ExibirResumo(vetor);
        System.out.printf("\nTempo total gasto %.3f ms%n\n", (tempoFinal - tempoInicial) / 1000d);

    }

    public static void menu() {
        System.out.println("1. Inserção \n2. Seleção \n3. Bolha \n4. Mergesort \n5. Heapsort \n6. Quicksort\n");
        System.out.print("Escolha um método de ordenação: ");
    }

    public static int quantidadeRegistros() {
        Scanner sc = new Scanner(System.in);

        int a = 1000;
        for (int i = 1; i < 8; i++) {
            System.out.printf("%d. %d registros\n", i, a *= 2);
        }

        System.out.print("Escolha a quantidade de registros: ");
        return 0;
    }

    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}