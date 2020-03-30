#include "../Console.c"
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

int quantLinhas = 5;
int quantColunas = 5;

void preecherMatriz(int matriz[quantLinhas][quantColunas])
{
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

int SomarAbaixoDiagonal(int matriz[quantLinhas][quantColunas])
{
    int somaValores = 0;

    for (int linha = 0; linha < quantLinhas; linha++)
    {
        for (int coluna = 0; coluna < linha; coluna++)
        {
            somaValores += matriz[linha][coluna];
        }
    }
    return somaValores;
}

int main()
{
    int matriz[quantLinhas][quantColunas];
    int vetorSomas[quantLinhas];

    preecherMatriz(matriz);
    imprimirMatriz(matriz);
    printf("\nSomas dos valores abaixo da diagonal principal: %d\n\n", SomarAbaixoDiagonal(matriz));

    return 0;
}
