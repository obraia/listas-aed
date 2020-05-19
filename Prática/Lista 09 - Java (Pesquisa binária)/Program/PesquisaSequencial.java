package Program;

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