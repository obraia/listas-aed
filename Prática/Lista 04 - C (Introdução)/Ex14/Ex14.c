#include "../Console.c"
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

int quantLinhas = 3;
int quantColunas = 4;

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

int main()
{
    int matriz[quantLinhas][quantColunas];
    int maiorValor = INT_MIN;
    int posMaior[2];
    int menorValor = INT_MAX;
    int posMenor[2];

    preecherMatriz(matriz);
    imprimirMatriz(matriz);

    for (int linha = 0; linha < quantLinhas; linha++)
    {
        for (int coluna = 0; coluna < quantColunas; coluna++)
        {
            if (matriz[linha][coluna] > maiorValor)
            {
                maiorValor = matriz[linha][coluna];
                posMaior[0] = linha;
                posMaior[1] = coluna;
            }

            if (matriz[linha][coluna] < menorValor)
            {
                menorValor = matriz[linha][coluna];
                posMenor[0] = linha;
                posMenor[1] = coluna;
            }
        }
    }

    printf("\nO maior valor da matriz é %d, e se encontra na posição [%d, %d]\n", maiorValor, posMaior[0], posMaior[1]);
    printf("o menor valor da matriz é %d, e se encontra na posição [%d, %d]\n\n", menorValor, posMenor[0], posMenor[1]);

    return 0;
}
