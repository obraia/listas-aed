#include "../Console.c"
#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

int main()
{
    setlocale(LC_ALL, "Portuguese_Brasil");
    int tamanho = 15;
    char vetor[tamanho];
    char vetorInvertido[tamanho];

    clear();

    for (int i = 0; i < tamanho; i++)
    {
        printf("Digite o %dº caracter: ", i + 1);
        scanf("%s", &vetor[i]);
    }

    clear();

    inverterVetor(vetor, &vetorInvertido, tamanho);
    printf("%s\n", vetor);
    printf("%s\n\n", vetorInvertido);

    return 0;
}

void inverterVetor(char vetor[], char vetorInvertido[], int tamanho)
{
    for (int i = 0; i < tamanho; i++)
    {
        vetorInvertido[i] = vetor[tamanho - 1 - i];
    }
}