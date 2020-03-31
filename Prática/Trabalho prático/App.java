import java.io.FileNotFoundException;

class App {
    public static void main(String[] args) throws FileNotFoundException {
        int quantidade = 10;
        
        Registro vetorRegistros[] = Arquivo.ler("./arquivos/dados_airbnb.txt", quantidade);
        Registro vetorRegistrosOrdenado[] = new Registro[quantidade];

        Merge.Sort(vetorRegistros, vetorRegistrosOrdenado, 0, quantidade - 1);

        Registro.ExibirResumo(vetorRegistrosOrdenado);

    }
}