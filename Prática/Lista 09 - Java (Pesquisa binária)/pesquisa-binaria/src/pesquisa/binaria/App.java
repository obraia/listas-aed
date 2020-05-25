package pesquisa.binaria;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        PesquisaBinaria pesquisaBinaria = new PesquisaBinaria();
        PesquisaSequencial pesquisaSequencial = new PesquisaSequencial();
        Produto[] produtos;
        Produto produtoB;
        Produto produtoS;
        int quantidadeProdutos = 10;

        produtos = Arquivo.carregar("pesquisaprodutosOrdenados.txt", quantidadeProdutos);

        System.out.print("Digite o código de barras do produto: ");
        long codigoDeBarras = sc.nextLong();

        produtoB = pesquisaBinaria.pesquisar(codigoDeBarras, produtos, 0, quantidadeProdutos - 1);
        produtoS = pesquisaSequencial.pesquisar(codigoDeBarras, produtos);

        if (produtoB != null) {
            System.out.println(produtoB.toString());
            System.out.println("Interações pesquisa binária: " + pesquisaBinaria.getQuantidadeOperacoes());
            System.out.println("Interações pesquisa sequêncial: " + pesquisaSequencial.getQuantidadeOperacoes() + "\n");
        } else {
            System.out.println("Produto não encontrado");
        }
    }
}
