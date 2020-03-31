import java.io.FileNotFoundException;

class App {
    public static void main(String[] args) throws FileNotFoundException {
        Registro vetorRegistros[] = Arquivo.ler("./arquivos/dados_airbnb.txt", 10);

        Registro.ExibirResumo(vetorRegistros);
            
    }
}