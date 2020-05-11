
public class TestaPilha {

    public static void main(String[] args) {

        PilhaCaractere minhaPilha = new PilhaCaractere();
        Caractere aux;

        aux = new Caractere('A');
        minhaPilha.empilhar(aux);
        aux = new Caractere('E');
        minhaPilha.empilhar(aux);
        aux = new Caractere('D');
        minhaPilha.empilhar(aux);
        aux = new Caractere('s');
        minhaPilha.empilhar(aux);
        aux = new Caractere('I');
        minhaPilha.empilhar(aux);
        aux = new Caractere('I');
        minhaPilha.empilhar(aux);

        minhaPilha.imprimir(); // AEDs II
        minhaPilha.desempilhar();
        minhaPilha.desempilhar();
        minhaPilha.imprimirInverso(); // sDEA
        System.out.println("A letra do item do topo da pilha é: " + minhaPilha.obterTopo().getLetra()); // s

        System.out.println("A pilha possui " + minhaPilha.obterNumeroItens() + " itens."); // A pilha possui 4 itens.
        System.out.println("Número de itens acima da letra A: " + minhaPilha.obterNumeroItensAcima('A')); // 3
        System.out.println("Número de itens acima da letra s: " + minhaPilha.obterNumeroItensAcima('s')); // 0
        System.out.println("Número de itens acima da letra d: " + minhaPilha.obterNumeroItensAcima('d')); // -1
    }

}
