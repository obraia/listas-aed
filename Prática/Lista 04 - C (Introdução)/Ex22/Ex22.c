// --> Para poder testar usei randoms para acelerar o processo
// as funções para entradas de dados se encontram comentadas
// então basta retirar os comentários e comentar as linhas com  "// --> Random"

#include "../Console.c"
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <ctype.h>
#include <limits.h>
#include <string.h>

typedef struct
{
    char sigla[2];
    int acidentesNoAno;
} Estado;

void preencherVetor(Estado vetorEstados[], int tamanho)
{
    srand(time(NULL));
    char siglas[26][26] = {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"};
    Estado estado;
    char siglaEstado[2];
    int acidentesNoAno = 0;

    for (int i = 0; i < tamanho; i++)
    {
        strcpy(estado.sigla, siglas[i]); // -> Random

        estado.acidentesNoAno = (rand() % 100000); // -> Random

        // printf("Digite a sigla do %dº estado: ", i+1);
        // scanf("%s", estado.sigla);

        // printf("Número de acidentes: ");
        //scanf("%d", estado.acidentesNoAno);

        vetorEstados[i] = estado;
    }
}

void imprimirVetor(Estado vetorEstados[], int tamanho)
{
    for (int i = 0; i < tamanho; i++)
    {
        printf("Estado: %s - N de acidentes: %d\n", vetorEstados[i].sigla, vetorEstados[i].acidentesNoAno);
    }
}

int main()
{
    int quantEstados = 15;
    Estado vetorEstados[quantEstados];
    int maiorValor = INT_MIN;
    int menorValor = INT_MAX;
    int posMaior, posMenor;

    preencherVetor(vetorEstados, quantEstados);
    imprimirVetor(vetorEstados, quantEstados);

    for (int i = 0; i < quantEstados; i++)
    {
        if (vetorEstados[i].acidentesNoAno > maiorValor)
        {
            maiorValor = vetorEstados[i].acidentesNoAno;
            posMaior = i;
        }

        if (vetorEstados[i].acidentesNoAno < menorValor)
        {
            menorValor = vetorEstados[i].acidentesNoAno;
            posMenor = i;
        }
    }

    printf("\n%s é o estado com maior número de acidentes em 2018, com um total de: %d",
           vetorEstados[posMaior].sigla, vetorEstados[posMaior].acidentesNoAno);
    printf("\n%s é o estado com menor número de acidentes em 2018, com um total de: %d\n\n",
           vetorEstados[posMenor].sigla, vetorEstados[posMenor].acidentesNoAno);
    return 0;
}
