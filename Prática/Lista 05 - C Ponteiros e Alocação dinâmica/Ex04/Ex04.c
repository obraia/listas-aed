#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <limits.h>

int **alocarMatriz(int m, int n)
{
    int **matriz = (int **)calloc(m, sizeof(int *));

    if (matriz == NULL)
    {
        printf("Erro: Memória insuficiênte!");
        return NULL;
    }

    for (int i = 0; i < m; i++)
    {
        matriz[i] = (int *)calloc(n, sizeof(int));

        if (matriz[i] == NULL)
        {
            printf("Erro: Memória insuficiênte!");
            return NULL;
        }
    }
}

void liberarMatriz(int **matriz, int m, int n)
{
    for (int i = 0; i < m; i++)
    {
        free(matriz[i]);
    }
    free(matriz);
}

void preencherMatriz(int (*matriz)[1], int m, int n)
{
    srand(time(NULL));
    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
        {
            *(*(matriz + i) + j) = (rand() % 100) + 1;
        }
    }
}

void imprimirMatriz(int (*matriz)[1], int m, int n)
{
    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
        {
            printf("%0d ", (*(matriz + i) + j));
        }
        printf("\n");
    }
}

int main()
{
    int **matrizA;
    int **matrizB;
    int m = 0, n = 0;

    printf("Digite a quantidade de linhas da matriz: ");
    scanf("%d", &m);
    printf("Digite a quantidade de colunas da matriz: ");
    scanf("%d", &n);

    matrizA = alocarMatriz(m, n);
    matrizB = alocarMatriz(m, n);

    preencherMatriz(matrizA, m, n);
    preencherMatriz(matrizB, m, n);

    imprimirMatriz(matrizA, m, n);
    printf("\n");
    imprimirMatriz(matrizB, m, n);

    liberarMatriz(matrizA, m, n);
    liberarMatriz(matrizB, m, n);

    return 0;
}
