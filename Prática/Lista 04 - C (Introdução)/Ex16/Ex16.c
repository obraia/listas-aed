#include "../Console.c"
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

int quantLinhas = 4;
int quantColunas = 5;

void preecherMatriz(int matriz[quantLinhas][quantColunas])
{
    srand(time(NULL));
    for (int linha = 0; linha < quantLinhas; linha++)
    {
        for (int coluna = 0; coluna < quantColunas; coluna++)
        {
            matriz[linha][coluna] = (rand() % 100) + 1;
        }
    }
}

void imprimirMatriz(int matriz[quantLinhas][quantColunas])
{
    for (int linha = 0; linha < quantLinhas; linha++)
    {
        for (int coluna = 0; coluna < quantColunas; coluna++)
        {
            printf("%d ", matriz[linha][coluna]);
        }
        printf("\n");
    }
}

void imprimirVetor(int vetor[], int tamanho)
{
    for (int i = 0; i < tamanho; i++)
    {
        printf("%d ", vetor[i]);
    }
    printf("\n");
}

void somarLinhasMatriz(int matriz[quantLinhas][quantColunas], int vetorSomas[])
{
    for (int linha = 0; linha < quantLinhas; linha++)
    {
        for (int coluna = 0; coluna < quantColunas; coluna++)
        {
            vetorSomas[linha] +=  matriz[linha][coluna];
        }
    }
}

int main()
{
    int matriz[quantLinhas][quantColunas];
    int vetorSomas[quantLinhas];

    preecherMatriz(matriz);
    imprimirMatriz(matriz);
    somarLinhasMatriz(matriz, vetorSomas);
    printf("\nSomas das linhas: "); imprimirVetor(vetorSomas, quantLinhas);
    
    return 0;
}
