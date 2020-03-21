import java.util.Arrays;

class Produto {

    private int Id;
    private String Nome;
    private float Preco;

    public Produto(int id, String nome, float preco) {
        this.Id = id;
        this.Nome = nome;
        this.Preco = preco;
    }

    public int getId() {
        return Id;
    }

    public String getNome() {
        return Nome;
    }

    public float getPreco() {
        return Preco;
    }

    @Override
    public String toString() {

        return "ID: " + Id + " - Nome: " + Nome + " - Preço: R$ " + Preco;
    }

    public boolean menorQue(Produto p) {
        if (this.Nome.compareToIgnoreCase(p.Nome) < 0) {
            return true;
        } else {
            return false;
        }
    }

    public static String getProduto(Produto[] produtos, int id) {

        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                return produto.toString();
            }
        }
        return "Código de produto não encontrado";
    }

    public static void exibirTodos(Produto[] produtos) {
        if (produtos.length == 0) {
            System.out.println("Nenhum produto cadastrado!");
        } else {
            int length = produtos.length;
            Produto[] aux = new Produto[length];

            Ordernar.mergeSort(produtos, aux, 0, length - 1);

            for (Produto produto : produtos) {
                System.out.println(produto);
            }
        }
    }
}
