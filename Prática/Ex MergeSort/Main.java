import java.util.*;
import java.lang.*;

class Main {

    Thread t;

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Produto> listaProutos = new ArrayList();
        boolean loop = true;
        byte opcao;
        int id;

        do {
            ConsoleClear();

            Menu();

            System.out.print("\nEscolha uma opção: ");
            opcao = sc.nextByte();

            ConsoleClear();

            switch (opcao) {
                case 1:
                    cadastrarProdutos(listaProutos);
                    break;

                case 2:
                    System.out.print("Digite um código para pesquisar: ");
                    id = sc.nextInt();
                    ProcurarProduto(listaProutos, id);
                    break;

                case 3:

                    break;

                default:

                    break;
            }

        } while (loop == true);

    }

    public static void Menu() {
        System.out.println("1. Cadastrar produto");
        System.out.println("2. Pesquisar produto");
        System.out.println("3. Exibir produtos");
    }

    public static void cadastrarProdutos(ArrayList<Produto> listaProdutos) {
        int id;
        String nome;
        float preco;
        boolean loop = true;
        char opcao;

        do {
            ConsoleClear();

            System.out.println("Preencha os dados do produo");
            System.out.print("Id: ");
            id = sc.nextInt();
            System.out.print("Nome: ");
            nome = sc.next();
            System.out.print("Preço: ");
            preco = sc.nextFloat();

            listaProdutos.add(new Produto(id, nome, preco));

            ConsoleClear();

            System.out.print("Digite qualquer tecla para voltar ao menu ou 1 para continuar adicionando produtos: ");
            opcao = sc.next().charAt(0);

            loop = (opcao == '1');

        } while (loop == true);
    }

    public static void ProcurarProduto(ArrayList<Produto> listaProduto, int id) {
        boolean encontrou = false;

        ConsoleClear();

        for (Produto produto : listaProduto) {
            if (produto.GetId() == id) {
                System.out.println(produto);
                encontrou = true;
            }
        }
        if (encontrou == false) {
            System.out.print("Código de produto não encontrado");

            try { Thread.sleep(1500); } catch (Exception e) { }
        }
    }

    public static void ConsoleClear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
