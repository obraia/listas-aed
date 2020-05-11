public class CelulaCaractere {
	
	Caractere item;          // corresponde ao item armazenado na célula da pilha.
    CelulaCaractere proximo; // referência à próxima célula de uma pilha.

    CelulaCaractere() {
    	item = new Caractere();
    	proximo = null;
    }
    
    // Construtor que inicializa o item com o valor passado através do parâmetro l desse método; e o atributo que indica a próxima célula da pilha com null.
    CelulaCaractere(char l) {    
    	item = new Caractere(l);
        proximo = null;
    }
}