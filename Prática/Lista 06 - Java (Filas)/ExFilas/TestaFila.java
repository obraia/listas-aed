import java.time.*;

public class TestaFila {

    public static void main(String[] args) throws InterruptedException {
        //testeA();
        testeB();
    }

    public static void testeA() throws InterruptedException {
        Cliente cli;
        FilaCliente filaLanchonete;
        filaLanchonete = new FilaCliente();
        cli = new Cliente("Eveline", LocalDateTime.now());
        filaLanchonete.enfileirar(cli);
        Thread.sleep(1000);
        cli = new Cliente("João", LocalDateTime.now());
        filaLanchonete.enfileirar(cli);
        Thread.sleep(1000);
        cli = new Cliente("Ana", LocalDateTime.now());
        filaLanchonete.enfileirar(cli);
        Thread.sleep(1000);
        System.out.println("Os clientes presentes na fila são, nessa ordem:");
        filaLanchonete.imprimir(); // Eveline João Ana
        System.out.println("A fila possui " + filaLanchonete.obterNumeroClientes() + " clientes."); // 3

        System.out.println("O primeiro cliente da fila é: " + filaLanchonete.obterPrimeiro().getNome());
        // Eveline
        FilaCliente fila2 = new FilaCliente();
        cli = new Cliente("José", LocalDateTime.now());
        fila2.enfileirar(cli);
        filaLanchonete.concatenar(fila2);
        System.out.println("Os clientes presentes na fila são, nessa ordem: ");
        filaLanchonete.imprimir(); // Eveline João Ana José
    }

    public static void testeB()  throws InterruptedException {
        Cliente cli;
        FilaCliente filaLanchonete;
        filaLanchonete = new FilaCliente();
        cli = new Cliente("Eveline", LocalDateTime.now ());
        filaLanchonete.enfileirar(cli);
        Thread.sleep(1000);
        cli = new Cliente("João", LocalDateTime.now ());
        filaLanchonete.enfileirar(cli);
        Thread.sleep(1000);
        cli = new Cliente("Ana", LocalDateTime.now());
        filaLanchonete.enfileirar(cli);
        Thread.sleep(1000);
        System.out.println("Os clientes presentes na fila são, nessa ordem:");
        filaLanchonete.imprimir(); // Eveline João Ana

        System.out.println("Existem " + filaLanchonete.obterNumClientesAFrente("Ana") + " clientes à frente do cliente Ana"); // 2 clientes
        System.out.println("Existem " + filaLanchonete.obterNumClientesAFrente("João") + " clientes à frente do cliente João"); // 1 cliente
        System.out.println("Existem " + filaLanchonete.obterNumClientesAFrente("Eveline") + " clientes à frente do cliente Eveline"); // 0 clientes
        System.out.println("Os clientes esperaram, em média, " + filaLanchonete.obterTempoMedioEspera() + " segundos na fila.");
    
        FilaCliente fila2 = filaLanchonete.copiar();
        System.out.println("Os clientes presentes na fila cópia são, nessa ordem:");
        fila2.imprimir(); // Eveline João Ana
    }

}