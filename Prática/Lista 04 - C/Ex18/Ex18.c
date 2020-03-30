#include "../Console.c"
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

int quantLinhas = 4;
int quantColunas = 4;

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

void DividirPelaDiagonal(int matriz[quantLinhas][quantColunas])
{
    for (int linha = 0; linha < quantLinhas; linha++)
    {
        int indiceDiagonalPrincipal = matriz[linha][linha];

        for (int coluna = 0; coluna < quantColunas; coluna++)
        {

            matriz[linha][coluna] = matriz[linha][coluna] / indiceDiagonalPrincipal;
        }
    }
}

int main()
{
    int matriz[quantLinhas][quantColunas];
    int vetorSomas[quantLinhas];

    preecherMatriz(matriz);
    imprimirMatriz(matriz);
    printf("\n\nMatriz resultante da divisão pelos elementos da diagonal principal:\n\n");
    DividirPelaDiagonal(matriz);
    imprimirMatriz(matriz);
    return 0;
}
