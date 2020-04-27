import java.time.*;

public class FilaCliente {

    private CelulaCliente frente; // referência ao cliente que está na frente da fila. Esse cliente é utilizado
                                  // apenas para controle.
    private CelulaCliente tras; // referência ao cliente que está na última posição da fila.

    // Construtor que cria uma fila vazia inicializando o cliente da frente da fila
    // e os atributos de controle da fila (frente e tras).
    public FilaCliente() {
        Cliente cli;
        CelulaCliente celula;
        LocalDateTime horaChegada;

        horaChegada = LocalDateTime.now();
        cli = new Cliente(" ", horaChegada);
        celula = new CelulaCliente(cli);
        frente = celula;
        tras = celula;
    }

    // Verifica se a fila está vazia. Em caso afirmativo, retorna true e em caso
    // negativo retorna false.
    public Boolean filaVazia() {
        // Se a fila apresentar apenas o elemento de controle, ela está vazia.
        if (frente == tras) {
            return true;
        } else {
            return false;
        }
    }

    // Insere o item da fila cli, passado como parâmetro para esse método, no final
    // da fila.
    public void enfileirar(Cliente cli) {
        // inserção do novo cliente no final da fila.
        tras.proximo = new CelulaCliente(cli);

        // atualização do atributo de controle tras.
        tras = tras.proximo;
        tras.item = cli;
    }

    // Retira o cliente que ocupa a primeira posição da fila. Se a fila estiver
    // vazia, esse método deve retornar null; caso contrário, esse método deve
    // retornar o cliente retirado da fila.
    public Cliente desenfileirar() {

        CelulaCliente aux;
        Cliente cli;

        if (!(filaVazia())) {
            // aux aponta para o cliente da fila que será retornado/desenfileirado, ou seja,
            // o primeiro cliente da fila.
            aux = frente.proximo;

            // atualização do primeiro cliente da fila.
            frente.proximo = aux.proximo;

            cli = aux.item;
            aux.proximo = null;

            if (aux == tras)
                tras = frente;

            return (cli);
        }
        return null;
    }

    public Cliente obterPrimeiro() {
        if (!filaVazia()) {
            return this.frente.proximo.item;
        } else {
            return null;
        }
    }

    public int obterNumeroClientes() {
        FilaCliente auxFila = copiar();
        int contador = 0;

        while (!auxFila.filaVazia()) {
            auxFila.desenfileirar();
            contador++;
        }
        
        return contador;
    }

    public void imprimir() {
        FilaCliente auxFila = copiar();
        CelulaCliente auxCelulaA;

        while (!auxFila.filaVazia()) {
            auxCelulaA = auxFila.frente.proximo;
            System.out.println(auxCelulaA.item.getNome());
            auxFila.desenfileirar();
        }
    }

    public void concatenar(FilaCliente fila) {
        while (!fila.filaVazia()) {
            this.enfileirar(fila.desenfileirar());
        }
    }

    public int obterNumClientesAFrente(String nomeCliente) {
        FilaCliente auxFila = copiar();
        Cliente auxCliente;
        int cont = 0;

        while (!auxFila.filaVazia()) {
            cont++;
            auxCliente = auxFila.frente.item;

            if(auxCliente.getNome().equals(nomeCliente)){
                return auxFila.obterNumeroClientes() - cont;
            }
            auxFila.desenfileirar();
        }

        return -1;
    }

    public FilaCliente copiar() {
        FilaCliente copiaFila = new FilaCliente();
        FilaCliente copiaFilaAux = new FilaCliente();

        // Fazer duas copias, uma que será retornada e outra para poder reescrever a lista principal
        while (!this.filaVazia()) {
            Cliente aux = this.obterPrimeiro();
            Cliente copiaCliente = new Cliente(aux.getNome(), aux.getHorarioChegada());
            copiaFila.enfileirar(copiaCliente);

            Cliente copiaClienteAux = new Cliente(aux.getNome(), aux.getHorarioChegada());
            copiaFilaAux.enfileirar(copiaClienteAux);

            this.desenfileirar();
        }

        // Popular a lista principal novamente
        while (!copiaFilaAux.filaVazia()) {
            Cliente aux = copiaFilaAux.obterPrimeiro();
            Cliente copiaCliente = new Cliente(aux.getNome(), aux.getHorarioChegada());

            this.enfileirar(copiaCliente);
            
            copiaFilaAux.desenfileirar();
        }

        return copiaFila;
    } 

    public Double obterTempoMedioEspera(){
        FilaCliente auxFila = copiar();
        
        LocalDateTime chegada;
        LocalDateTime saida;
        long somaTempos = 0;

        while (!auxFila.filaVazia()) {
            chegada =  auxFila.frente.proximo.item.getHorarioChegada();
            saida = LocalDateTime.now();
            somaTempos += Duration.between(chegada, saida).getNano();

            auxFila.desenfileirar();
        }

        return (double)somaTempos / obterNumeroClientes() / 10000000;
    }
}