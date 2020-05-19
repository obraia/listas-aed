/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosdepesquisas;

/**
 *
 * @author Bryan
 */
public class Produto {
    public static Produto[] listaProdutos = new Produto[100];
    private long codigoDeBarras;
    private String nome;
    private float preco;

    public Produto(long codigoDeBarras, String nome, float preco) {
        this.codigoDeBarras = codigoDeBarras;
        this.nome = nome;
        this.preco = preco;
    }

    public long getCodigoDeBarras() {
        return this.codigoDeBarras;
    }

    public String getNome() {
        return this.nome;
    }

    public float getPreco() {
        return this.preco;
    }

    @Override
    public String toString() {
        return String.format("Código: %d - Nome: %s - preço: R$ %f.2", this.codigoDeBarras, this.nome, this.preco);
    }
}