import java.util.*;
import java.lang.*;

class Principal {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Produto[] produtos = new Produto[0];
        boolean loop = true;
        byte opcao;
        int quantidade = 0;

        do {
            Console.clear();

            menu();

            System.out.print("\nEscolha uma opção: ");
            opcao = Validar.entradaByte();

            Console.clear();

            switch (opcao) {
                case 0:
                    loop = false;
                    break;

                case 1:
                    int inicio = produtos.length;

                    do {
                        System.out.print("Digite a quantidade de produtos para cadastrar: ");
                        quantidade = Validar.entradaInt() + produtos.length;
                    } while (!Validar.quantidade(quantidade));

                    if (inicio == 0) {
                        produtos = new Produto[quantidade];
                    } else {
                        produtos = aumentarVetor(produtos, quantidade);
                    }

                    cadastrarProduto(produtos, inicio, quantidade);
                    break;

                case 2:
                    System.out.print("\nInforme um código de barras para pesquisar: ");
                    int id = Validar.entradaInt();
                    System.out.println("\n" + Produto.getProduto(produtos, id));
                    esperar();
                    break;

                case 3:
                    Produto.exibirTodos(produtos);
                    esperar();
                    break;

                default:
                    System.out.print("Opção inválida ");
                    Console.sleep(1000);
                    break;
            }

        } while (loop == true);
    }

    public static void menu() {
        System.out.println("1. Cadastrar produtos");
        System.out.println("2. Pesquisar produto");
        System.out.println("3. Exibir produtos");
        System.out.println("0. Sair");
    }

    public static Produto[] aumentarVetor(Produto[] produtos, int quantidade) {
        Produto[] novoVetor = new Produto[quantidade];

        for (int i = 0; i < produtos.length; i++) {
            novoVetor[i] = produtos[i];
        }
        return novoVetor;
    }

    public static void cadastrarProduto(Produto[] produtos, int inicio, int quantidade) {
        int id;
        String nome;
        float preco;

        for (int i = inicio; i < quantidade; i++) {
            Console.clear();

            System.out.printf("Preencha os dados do %dº produo\n\n", i + 1);

            do {
                System.out.print("Id: ");
                id = Validar.entradaInt();
            } while (!Validar.id(produtos, id));

            System.out.print("Nome: ");
            nome = sc.next();

            do {
                System.out.print("Preço: ");
                preco = Validar.entradaFloat();
            } while (!Validar.preco(preco));

            produtos[i] = new Produto(id, nome, preco);

            Console.clear();
        }

        System.out.print("Produto(s) cadastrado(s) com sucesso! ");
        Console.sleep(1500);
    }

    public static void esperar() {
        System.out.print("\nDigite qualquer tecla e pressione enter para voltar ao menu: ");
        sc.next();
    }
}
