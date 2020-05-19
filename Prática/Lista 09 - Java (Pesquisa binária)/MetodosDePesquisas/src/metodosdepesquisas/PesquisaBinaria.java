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
public class PesquisaBinaria {
    private int quantidadeOperacoes = 0;

    public Produto pesquisar(long codigoDeBarras, Produto[] produtos, int inicio, int fim) {
        int meio = (fim + inicio) / 2;
        this.quantidadeOperacoes++;
        
        if (inicio > fim) {
            return null;
        } else if (produtos[meio].getCodigoDeBarras() == codigoDeBarras) {
            return produtos[meio];
        } else if (codigoDeBarras > produtos[meio].getCodigoDeBarras()) {
            return pesquisar(codigoDeBarras, produtos, meio + 1, fim);
        } else {
            return pesquisar(codigoDeBarras, produtos, inicio, meio - 1);
        }
    }

    public int getQuantidadeOperacoes() {
        return this.quantidadeOperacoes;
    }
}