
public class TestaListaContaCorrente {

    public static void main(String[] args) {
        testeEx1a5();
    }

    public static void testeA() {
        ContaCorrente cc;
        ListaContaCorrente banco;

        banco = new ListaContaCorrente();

        if (banco.listaVazia()) {
            System.out.println("A lista de contas-correntes está vazia."); // essa mensagem deve ser exibida.
        }

        cc = new ContaCorrente("Eveline", 36, 707, 500.00);
        banco.inserirFinal(cc);
        System.out.println("Contas-correntes presentes no banco:");
        banco.imprimir(); // Titular: Eveline, Agência: 36, Número da conta-corrente: 707, Saldo atual:
                          // 500.00

        cc = new ContaCorrente("João", 45, 801, 500.00);
        banco.inserirFinal(cc);
        cc = new ContaCorrente("José", 71, 917, 1000.00);
        banco.inserirFinal(cc);
        System.out.println("Contas-correntes presentes no banco:");
        banco.imprimir(); // Titular: Eveline, Agência: 36, Número da conta-corrente: 707, Saldo atual:
                          // 500.00
                          // Titular: João, Agência: 45, Número da conta-corrente: 801, Saldo atual:
                          // 500.00
                          // Titular: José, Agência: 71, Número da conta-corrente: 917, Saldo atual:
                          // 1000.00

        cc = banco.localizar(801);
        if (cc != null) {
            System.out.println("A conta-corrente de número " + cc.getNumContaCorrente() + " foi encontrada no banco.");
            // deve ser exibida a mensagem "A conta-corrente de número 801 foi encontrada no
            // banco."
        } else {
            System.out.println("A conta-corrente de número 801 não foi encontrada no banco");
        }

        cc = banco.localizar(701);
        if (cc != null) {
            System.out.println("A conta-corrente de número " + cc.getNumContaCorrente() + " foi encontrada no banco.");
        } else {
            System.out.println("A conta-corrente de número 701 não foi encontrada no banco");
            // deve ser exibida a mensagem "A conta-corrente de número 701 não foi
            // encontrada no banco."
        }

        cc = banco.retirar(801);
        System.out.println("Contas-correntes presentes no banco:");
        banco.imprimir(); // Titular: Eveline, Agência: 36, Número da conta-corrente: 707, Saldo atual:
                          // 500.00
                          // Titular: José, Agência: 71, Número da conta-corrente: 917, Saldo atual:
                          // 1000.00

        cc = banco.retirar(917);
        System.out.println("Contas-correntes presentes no banco:");
        banco.imprimir(); // Titular: Eveline, Agência: 36, Número da conta-corrente: 707, Saldo atual:
                          // 500.00

        cc = banco.retirar(917);
        if (cc == null) {
            System.out.println("A conta-corrente de número 917 não foi localizada no banco."); // essa mensagem deve ser
                                                                                               // exibida.
        }
        System.out.println("Contas-correntes presentes no banco:");
        banco.imprimir(); // Titular: Eveline, Agência: 36, Número da conta-corrente: 707, Saldo atual:
                          // 500.00

        cc = banco.retirar(707);
        System.out.println("Contas-correntes presentes no banco:");
        banco.imprimir(); // a seguinte mensagem deve ser exibida: "A lista de contas-correntes está
                          // vazia."
    }

    public static void testeEx1a5() {
        ContaCorrente cc;
        ListaContaCorrente banco, bancoNovo, bancoCopia;
        banco = new ListaContaCorrente();
        cc = new ContaCorrente("Eveline", 36, 707, 500.00);
        banco.inserirFinal(cc);
        cc = new ContaCorrente("João", 45, 801, 500.00);
        banco.inserirFinal(cc);
        cc = new ContaCorrente("José", 71, 917, 900.00);
        banco.inserirFinal(cc);
        System.out.println("Contas-correntes presentes no banco:");
        banco.imprimir(); // Titular: Eveline, Agência: 36, Número da conta-corrente: 707, Saldo atual:
                          // 500.00
        // Titular: João, Agência: 45, Número da conta-corrente: 801, Saldo atual:
        // 500.00
        // Titular: José, Agência: 71, Número da conta-corrente: 917, Saldo atual:
        // 900.00
        banco.depositar(801, 500.00);
        System.out.println("Contas-correntes presentes no banco:");
        banco.imprimir(); // Titular: Eveline, Agência: 36, Número da conta-corrente: 707, Saldo atual:
                          // 500.00
        // Titular: João, Agência: 45, Número da conta-corrente: 801, Saldo atual:
        // 1000.00
        // Titular: José, Agência: 71, Número da conta-corrente: 917, Saldo atual:
        // 900.00
        bancoNovo = new ListaContaCorrente();
        cc = new ContaCorrente("Ana", 70, 17, 700.00);
        bancoNovo.inserirFinal(cc);
        banco.concatenar(bancoNovo);
        System.out.println("Contas-correntes presentes no banco:");
        banco.imprimir(); // Titular: Eveline, Agência: 36, Número da conta-corrente: 707, Saldo atual:
                          // 500.00
        // Titular: João, Agência: 45, Número da conta-corrente: 801, Saldo atual:
        // 1000.00
        // Titular: José, Agência: 71, Número da conta-corrente: 917, Saldo atual:
        // 900.00
        // Titular: Ana, Agência: 70, Número da conta-corrente: 17, Saldo: 700.00
        System.out.println("A instituição financeira apresenta " + banco.obterNumContasCorrentes() + " contas-correntes."); // 4
                                                                                                                 // contas-correntes.
        bancoCopia = banco.copiar();
        System.out.println("Contas-correntes presentes na cópia do banco:");
        bancoCopia.imprimir(); // Titular: Eveline, Agência: 36, Número da conta-corrente: 707, Saldo atual:
                               // 500.00
        // Titular: João, Agência: 45, Número da conta-corrente: 801, Saldo atual:
        // 1000.00
        // Titular: José, Agência: 71, Número da conta-corrente: 917, Saldo atual:
        // 900.00
        // Titular: Ana, Agência: 70, Número da conta-corrente: 17, Saldo: 700.00
        banco.eliminarContasCorrentesPosicoesPares();
        System.out.println("Contas-correntes presentes no banco:");
        banco.imprimir(); // Titular: Eveline, Agência: 36, Número da conta-corrente: 707, Saldo atual:
                          // 500.00
        // Titular: José, Agência: 71, Número da conta-corrente: 917, Saldo atual:
        // 900.00
        banco.eliminarContasCorrentesPosicoesPares();
        System.out.println("Contas-correntes presentes no banco:");
        banco.imprimir(); // Titular: Eveline, Agência: 36, Número da conta-corrente: 707, Saldo atual:
                          // 500.00

        banco.eliminarContasCorrentesPosicoesPares();
        System.out.println("Contas-correntes presentes no banco:");
        banco.imprimir(); // Titular: Eveline, Agência: 36, Número da conta-corrente: 707, Saldo atual:
                          // 500.00
    }

}
