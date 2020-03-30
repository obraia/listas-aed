#include "../Console.c"
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

void preencherVetor(int vetor[], int tamanho)
{
    for (int i = 0; i < tamanho; i++)
    {
        vetor[i] = (rand() % 100) + 1;
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

multiplicarVetores(int vetorA[], int vetorB[], int vetorC[], int tamanho)
{
    for (int i = 0; i < tamanho; i++)
    {
        vetorC[i] = vetorA[i] * vetorB[i];
    }
}

int main()
{
    clear();
    int tamanho = 10;
    int vetorA[tamanho];
    int vetorB[tamanho];
    int vetorC[tamanho];
    
    preencherVetor(vetorA, tamanho);
    preencherVetor(vetorB, tamanho);

    imprimirVetor(vetorA, tamanho);
    imprimirVetor(vetorB, tamanho);

    multiplicarVetores(vetorA, vetorB, vetorC, tamanho);

    imprimirVetor(vetorC, tamanho);

    return 0;
}
