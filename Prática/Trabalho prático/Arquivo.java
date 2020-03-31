import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Arquivo {

    public static Registro [] ler(String path) throws FileNotFoundException{
        File arquivo = new File(path);
        Scanner sc = new Scanner(arquivo);

        Registro vetorRegistro[] = new Registro[fileLength(arquivo)];

        int lineNumber = 0;

        String line = sc.nextLine();

        while(sc.hasNextLine()){
            line = sc.nextLine();
            
            String aux[] = line.split("\t");

            int roomId = Integer.parseInt(aux[0]);
            int hostId = Integer.parseInt(aux[1]);
            String roomType = aux[2];
            String country = aux[3];
            String city = aux[4];
            String neighborhood = aux[5];
            float reviews = Float.parseFloat(aux[6]);
            float overallSatisfaction = Float.parseFloat(aux[7]);
            int accommodates = Integer.parseInt(aux[8]);
            int bedrooms = (int)Float.parseFloat(aux[9]);
            float price = Float.parseFloat(aux[10]);
            String propertyType = aux[11];

            vetorRegistro[lineNumber] = new Registro(roomId, hostId, roomType, country, city, neighborhood, reviews,
            overallSatisfaction, accommodates, bedrooms, price, propertyType);

            lineNumber++;
        }  


        return vetorRegistro;
    }

    public static int fileLength(File arquivo) throws FileNotFoundException {
        Scanner counter = new Scanner(arquivo);
        int linhas = 0;

        while(counter.hasNextLine()){
            counter.nextLine();
            linhas++;
        }  

        return linhas;
    }
}