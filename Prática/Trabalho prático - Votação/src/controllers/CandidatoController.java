package src.controllers;

import src.utils.*;
import src.models.Candidato;

public class CandidatoController {
    public static void carregar(String caminhoArquivo) {
        Arquivo dados = new Arquivo(caminhoArquivo);

        String linha = dados.readLine();

        do {
            String[] aux = linha.split(";");
            
        } while ((linha = dados.readLine()) != null);

    }

    public static void imprimir() {

    }
}