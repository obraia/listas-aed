/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosdepesquisas;

import java.io.FileNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.Test;
// import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Bryan
 */
public class PesquisaBinariaTest {
    
    public PesquisaBinariaTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of pesquisar method, of class PesquisaBinaria.
     */
    @Test
    public void testPesquisarPrimeiro() throws FileNotFoundException {
        System.out.println("-> testPesquisarPrimeiro");
        
        PesquisaBinaria pesquisaBinaria = new PesquisaBinaria();
        Produto[] produtos;
        Produto produto;
        int quantidadeProdutos = 10;
        long codigoDeBarras = 789123450001L; // -> código primeiro produto

        produtos = Arquivo.carregar("src/arquivos/produtosOrdenados.txt", quantidadeProdutos);

        produto = pesquisaBinaria.pesquisar(codigoDeBarras, produtos, 0, quantidadeProdutos - 1);
        
        String expResult = "789123450001;Desinfetante Líquido Pinho Sol - Lavanda 1L;8.60";
        
        assertEquals(expResult, produto.toString());
    }
    
    @Test
    public void testPesquisarMeio() throws FileNotFoundException {
        System.out.println("-> testPesquisarMeio");
        
        PesquisaBinaria pesquisaBinaria = new PesquisaBinaria();
        Produto[] produtos;
        Produto produto;
        int quantidadeProdutos = 10;
        long codigoDeBarras = 789123450005L; // -> código do produto do meio do vetor

        produtos = Arquivo.carregar("src/arquivos/produtosOrdenados.txt", quantidadeProdutos);

        produto = pesquisaBinaria.pesquisar(codigoDeBarras, produtos, 0, quantidadeProdutos - 1);
        
        String expResult = "789123450005;Óleo Equilíbrio LIZA Pet 900ml;13.95";
        
        assertEquals(expResult, produto.toString());
    }

    @Test
    public void testPesquisarUltimo() throws FileNotFoundException {
        System.out.println("-> testPesquisarUltimo");
        
        PesquisaBinaria pesquisaBinaria = new PesquisaBinaria();
        Produto[] produtos;
        Produto produto;
        int quantidadeProdutos = 10;
        long codigoDeBarras = 789123450010L; // -> código do ultimo produto

        produtos = Arquivo.carregar("src/arquivos/produtosOrdenados.txt", quantidadeProdutos);

        produto = pesquisaBinaria.pesquisar(codigoDeBarras, produtos, 0, quantidadeProdutos - 1);
        
        String expResult = "789123450010;Cadeira Diretor Encosto Telado - Preta;239.90";
        
        assertEquals(expResult, produto.toString());
    }    
    /**
     * Test of getQuantidadeOperacoes method, of class PesquisaBinaria.
     */
    @Test
    public void testGetQuantidadeOperacoesPesquisarPrimeiro() throws FileNotFoundException {
        System.out.println("-> testGetQuantidadeOperacoesPesquisarPrimeiro");
        
        PesquisaBinaria pesquisaBinaria = new PesquisaBinaria();
        Produto[] produtos;
        int quantidadeProdutos = 10;
        long codigoDeBarras = 789123450001L; // -> código primeiro produto

        produtos = Arquivo.carregar("src/arquivos/produtosOrdenados.txt", quantidadeProdutos);

        pesquisaBinaria.pesquisar(codigoDeBarras, produtos, 0, quantidadeProdutos - 1);
        
        int expResult = 3;
        
        assertEquals(expResult, pesquisaBinaria.getQuantidadeOperacoes());
    }    
}
