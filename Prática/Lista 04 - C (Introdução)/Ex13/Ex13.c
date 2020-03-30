#include "../Console.c"
#include <stdio.h>
#include <stdlib.h>

int tamanho = 3;

void preecherMatriz(int matriz[][tamanho])
{
    srand(time(NULL));
    for (int linha = 0; linha < tamanho; linha++)
    {
        for (int coluna = 0; coluna < tamanho; coluna++)
        {
            matriz[linha][coluna] = (rand() % 100) + 1;
        }
    }
}

void imprimirMatriz(int matriz[][tamanho])
{
    for (int linha = 0; linha < tamanho; linha++)
    {
        for (int coluna = 0; coluna < tamanho; coluna++)
        {
            printf("%d ", matriz[linha][coluna]);
        }
        printf("\n");
    }
}

float mediaDiagonalPrincipal(int matriz[][tamanho])
{
    int somaDiagonal = 0;

    for (int i = 0; i < tamanho; i++)
    {
        somaDiagonal += matriz[i][i];
    }
    return (float)somaDiagonal/tamanho;
}

int main()
{
    int matriz[tamanho][tamanho];
    preecherMatriz(matriz);
    imprimirMatriz(matriz);
    float mediaDiagonal = mediaDiagonalPrincipal(matriz);
    printf("\nA média da diagonal principal é: %g\n\n", mediaDiagonal);

    return 0;
}

