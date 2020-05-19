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
public class PesquisaSequencial {
    private int quantidadeOperacoes = 0;

    public Produto pesquisar(long codigoDeBarras, Produto[] produtos) {
        for (Produto produto : produtos) {
            this.quantidadeOperacoes++;
            if (produto.getCodigoDeBarras() == codigoDeBarras) {
                return produto;
            }
        }
        return null;
    }

    public int getQuantidadeOperacoes() {
        return this.quantidadeOperacoes;
    }
}