import java.util.*;
import java.lang.*;

class Principal {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Produto[] produtos = new Produto[0];
        boolean loop = true;
        byte opcao;

        do {
            Console.Clear();

            menu();

            System.out.print("\nEscolha uma opção: ");
            opcao = sc.nextByte();

            Console.Clear();

            switch (opcao) {
                case 0:
                    loop = false;
                    break;

                case 1:
                    int inicio = produtos.length;
                    System.out.print("Digite a quantidade de produtos para cadastrar: ");
                    int quantidade = sc.nextInt() + produtos.length;

                    if(inicio == 0) {
                        produtos = new Produto[quantidade];
                    }
                    else{
                        produtos = aumentarVetor(produtos, quantidade);
                    }
                    
                    cadastrarProduto(produtos, inicio, quantidade);
                    break;

                case 2:
                    System.out.print("\nInforme um código de barras para pesquisar: ");
                    int id = sc.nextInt();
                    System.out.println("\n" + Produto.getProduto(produtos, id));
                    esperar();
                    break;

                case 3:
                    Produto.exibirTodos(produtos);
                    esperar();
                    break;

                default:
                    System.out.print("Opção inválida ");
                    Console.Sleep(1500);
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

    public static Produto[] aumentarVetor(Produto[] produtos, int quantidade){
        Produto[] novoVetor = new Produto[quantidade];

        for(int i = 0; i < produtos.length; i++){
            novoVetor[i] = produtos[i];
        }
        return novoVetor;
    }

    public static void cadastrarProduto(Produto[] produtos, int inicio, int quantidade) {
        int id;
        String nome;
        float preco;

        for (int i = inicio; i < quantidade; i++) {
            Console.Clear();

            System.out.printf("Preencha os dados do %dº produo\n\n", i + 1);

            do {
                System.out.print("Id: ");
                id = sc.nextInt();
            } while (!Validar.id(produtos, id));

            System.out.print("Nome: ");
            nome = sc.next();

            do {
                System.out.print("Preço: ");
                preco = sc.nextFloat();
            } while (!Validar.preco(preco));

            produtos[i] = new Produto(id, nome, preco);

            Console.Clear();
        }

        System.out.print("Produto(s) cadastrado(s) com sucesso! ");
        Console.Sleep(1500);
    }

    public static void esperar(){
        System.out.print("\nDigite qualquer tecla e pressione enter para voltar ao menu: ");
        sc.next();
    }
}
