package Program;

import java.io.FileNotFoundException;
import java.util.Scanner;

class Principal {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        PesquisaBinaria pesquisaBinaria = new PesquisaBinaria();
        Produto[] produtos;
        Produto produto;
        int quantidadeProdutos = 10;

        produtos = Arquivo.carregar("arquivos/produtosOrdenados.txt", quantidadeProdutos);

        System.out.print("Digite o código de barras do produto: ");
        long codigoDeBarras = sc.nextLong();
        
        produto = pesquisaBinaria.pesquisar(codigoDeBarras, produtos, 0, quantidadeProdutos - 1);

        if (produto != null) {
            System.out.println(produto.toString());
            System.out.println("Interações: " + pesquisaBinaria.getQuantidadeOperacoes() + "\n");
        } else {
            System.out.println("Produto não encontrado");
        }
    }
}