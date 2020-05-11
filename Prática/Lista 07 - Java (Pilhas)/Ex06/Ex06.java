
public class Ex06 {

    public static void main(String[] args) {
        PilhaCaractere pilhaCaracteres = new PilhaCaractere();

        empilharFrase(pilhaCaracteres, "PO#UCTE##-MIB#NADR##S");
        pilhaCaracteres = pilhaCaracteres.inverterPilha();
        pilhaCaracteres = pilhaCaracteres.cencelarCaracteres('#');

        pilhaCaracteres.imprimir();
    }

    public static void empilharFrase(PilhaCaractere pilha, String frase){
        for(int i = 0; i < frase.length(); i++){
            pilha.empilhar(new Caractere(frase.charAt(i)));
        }
    }
}
