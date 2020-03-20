class Produto {

    private int Id;
    private String Nome;
    private float Preco;

    public Produto(int id, String nome, float preco) {
        this.Id = id;
        this.Nome = nome;
        this.Preco = preco;
    }

    public int GetId() {
        return Id;
    }

    public String GetNome(){
        return Nome;
    }

    public float GetPreco(){
        return Preco;
    }

    @Override
    public String toString() {

        return "ID: " + Id + " - Nome: " + Nome + " - Preço: R$ " + Preco;
    }
}
