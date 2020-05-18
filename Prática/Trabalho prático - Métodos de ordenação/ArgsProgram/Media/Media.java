import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

class Media {
    public static void main(String[] args) throws IOException {
        try {
            lerArquivo("2000");
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            lerArquivo("4000");
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            lerArquivo("8000");
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            lerArquivo("16000");
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            lerArquivo("32000");
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            lerArquivo("64000");
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            lerArquivo("128000");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void salvarMedias(String nomeArquivo, float mediaInsertion, float mediaSelection, float mediaBubble,
            float mediaMerge, float mediaHeap, float mediaQuick) throws IOException {

        File arquivo = new File("medias/media-" + nomeArquivo + ".txt");
        FileWriter fw = new FileWriter("medias/media-" + nomeArquivo + ".txt", true);

        if (!arquivo.exists()) {
            arquivo.createNewFile();
        }
        String linha = String.format(
                "Insertion: %.4f \nSelection: %.4f \nBubble: %.4f \nMerge: %.4f \nHeap: %.4f \nQuick: %.4f\n",
                mediaInsertion, mediaSelection, mediaBubble, mediaMerge, mediaHeap, mediaQuick);

        fw.write(linha);
        fw.close();
    }

    public static void lerArquivo(String nomeArquivo) throws IOException {

        Scanner sc = new Scanner(new File("tempos/" + nomeArquivo + ".txt"));

        float[] tempoInsertion = new float[5];
        float[] tempoSelection = new float[5];
        float[] tempoBubble = new float[5];
        float[] tempoMerge = new float[5];
        float[] tempoHeap = new float[5];
        float[] tempoQuick = new float[5];

        float mediaInsertion = 0;
        float mediaSelection = 0;
        float mediaBubble = 0;
        float mediaMerge = 0;
        float mediaHeap = 0;
        float mediaQuick = 0;

        String linha = sc.nextLine();

        for (int i = 0; i < 5; i++) {
            String aux[] = linha.split(";");

            tempoInsertion[i] = Float.parseFloat(aux[0]);
            tempoSelection[i] = Float.parseFloat(aux[1]);
            tempoBubble[i] = Float.parseFloat(aux[2]);
            tempoMerge[i] = Float.parseFloat(aux[3]);
            tempoHeap[i] = Float.parseFloat(aux[4]);
            tempoQuick[i] = Float.parseFloat(aux[5]);

            try {
                linha = sc.nextLine();
            } catch (Exception e) {
            }
        }

        mediaInsertion = mediaTempos(tempoInsertion);
        mediaSelection = mediaTempos(tempoSelection);
        mediaBubble = mediaTempos(tempoBubble);
        mediaMerge = mediaTempos(tempoMerge);
        mediaHeap = mediaTempos(tempoHeap);
        mediaQuick = mediaTempos(tempoQuick);

        System.out.println("Meida Insertion: " + mediaInsertion);
        System.out.println("Meida Selection: " + mediaSelection);
        System.out.println("Meida Bubble: " + mediaBubble);
        System.out.println("Meida Merge: " + mediaMerge);
        System.out.println("Meida Heap: " + mediaHeap);
        System.out.println("Meida Quick: " + mediaQuick);

        salvarMedias(nomeArquivo, mediaInsertion, mediaSelection, mediaBubble, mediaMerge, mediaHeap, mediaQuick);
    }

    public static float mediaTempos(float[] tempos) {
        float maiorTempo = Float.MIN_VALUE;
        float menorTempo = Float.MAX_VALUE;
        int posMaior = 0, posMenor = 0;
        float somaTempos = 0;

        for (int i = 0; i < tempos.length; i++) {
            if (tempos[i] > maiorTempo) {
                maiorTempo = tempos[i];
                posMaior = i;
            }

            if (tempos[i] < menorTempo) {
                menorTempo = tempos[i];
                posMenor = i;
            }
        }

        for (int i = 0; i < tempos.length; i++) {
            if (i != posMaior && i != posMenor) {
                somaTempos += tempos[i];
            }
        }

        return somaTempos / 3;
    }

}