public class PilhaCaractere {

    private CelulaCaractere fundo; // referência à célula que está no fundo da pilha. Essa célula é utilizada
                                   // apenas para controle.
    private CelulaCaractere topo; // referência à célula que está no topo da pilha.

    // Construtor que cria uma pilha "vazia" inicializando a célula do fundo da
    // pilha e os atributos de controle da pilha (fundo e topo).
    PilhaCaractere() {

        CelulaCaractere aux = new CelulaCaractere();

        fundo = aux;
        topo = aux;
    }

    // Insere o item, passado como parâmetro para esse método, no topo da pilha.
    public void empilhar(Caractere l) {
        // inserção da nova célula no topo da pilha.
        CelulaCaractere aux = new CelulaCaractere();
        aux.proximo = topo;
        aux.item = l;

        // atualização do atributo de controle topo.
        topo = aux;
    }

    // Retira o item que está no topo da pilha. Se a pilha estiver vazia, esse
    // método deve retornar null; caso contrário, esse método deve retornar o item
    // retirado da pilha.
    public Caractere desempilhar() {
        // se a pilha estiver vazia, esse método deve retornar null.
        Caractere aux = null;

        if (!pilhaVazia()) {
            // aux aponta para o item da pilha que será retornado/desempilhado, ou seja, o
            // item do topo.
            aux = topo.item;

            // atualização do atributo de controle topo.
            topo = topo.proximo;
        }
        return (aux);
    }

    // Verifica se a pilha está vazia. Em caso afirmativo, retorna true e em caso
    // negativo retorna false.
    public Boolean pilhaVazia() {
        // se a pilha apresentar apenas a célula sentinela, ela está vazia.
        if (fundo == topo)
            return (true);
        else
            return (false);
    }

    public Caractere obterTopo() {
        return this.topo.item;
    }

    public int obterNumeroItens() {
        CelulaCaractere auxTopo = this.topo;
        int cont = 0;

        while (auxTopo != this.fundo) {
            auxTopo = auxTopo.proximo;
            cont++;
        }

        return cont;
    }

    public void imprimirInverso() {
        CelulaCaractere auxTopo = new CelulaCaractere();
        Caractere auxCaractere = null;

        auxTopo = this.topo;

        while (auxTopo != this.fundo) {
            auxCaractere = auxTopo.item;
            auxTopo = auxTopo.proximo;

            System.out.println(auxCaractere.getLetra());
        }
    }

    public int obterNumeroItensAcima(char l) {
        CelulaCaractere auxTopo = this.topo;
        Caractere auxCaractere = null;
        int cont = 0;

        while (auxTopo != this.fundo) {
            auxCaractere = auxTopo.item;

            if (auxCaractere.getLetra() == l) {
                return cont;
            }

            auxTopo = auxTopo.proximo;
            cont++;
        }

        return -1;
    }

    public void imprimir() {
        PilhaCaractere auxPilha = new PilhaCaractere();
        CelulaCaractere auxTopo = this.topo;
        Caractere auxCaractere = null;

        while (auxTopo != this.fundo) {
            auxCaractere = auxTopo.item;
            auxTopo = auxTopo.proximo;
            auxPilha.empilhar(auxCaractere);
        }

        while (!auxPilha.pilhaVazia()) {
            System.out.print(auxPilha.desempilhar().getLetra());
        }
        System.out.println();
    }

    public PilhaCaractere inverterPilha() {
        PilhaCaractere auxPilha = new PilhaCaractere();

        while (!this.pilhaVazia()) {
            auxPilha.empilhar(this.desempilhar());
        }

        return auxPilha;
    }

    public PilhaCaractere cencelarCaracteres(char l) {
        PilhaCaractere auxPilha = new PilhaCaractere();
        CelulaCaractere auxTopo = this.topo;

        while (auxTopo != this.fundo) {
            if (auxTopo.item.getLetra() != l) {
                auxPilha.empilhar(auxTopo.item);
            } else {
                auxPilha.desempilhar();
            }
            auxTopo = auxTopo.proximo;
        }

        return auxPilha;
    }
}