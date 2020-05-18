package src.models;

public class Candidato {
    private String nome;
    private int numero;
    private String municipio;
    private String partido;
    private char cargo;

    public Candidato(String nome, int numero, String municipio, String partido, char cargo) {
        this.nome = nome;
        this.numero = numero;
        this.municipio = municipio;
        this.partido = partido;
        this.cargo = cargo;
    }

    public String getNome() {
        return this.nome;
    }

    public int getNumero() {
        return this.numero;
    }

    public String getMunicipio() {
        return this.municipio;
    }

    public String getPartido() {
        return this.partido;
    }

    public char getCargo() {
        return this.cargo;
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%s;%s;%s", nome, numero, municipio, partido, cargo);
    }
}