#include "../Console.c"
#include <stdio.h>
#include <stdlib.h>

int main(){
    int tamanho = 6;
    int vetor[tamanho];
    clear();
    preencherVetor(vetor, tamanho);
    clear();
    relatorio(vetor, tamanho);

    return 0;
}

void preencherVetor(int vetor[], int tamanho){
    for (int i = 0; i < tamanho; i++)
    {
        printf("Digite o %dº valor: ", i+1);
        scanf("%d", &vetor[i]);
    }
}

void relatorio(int vetor[], int tamanho){
    int somaPares = 0;
    int quantImpares = 0;

    for (int i = 0; i < tamanho; i++)
    {
        if(vetor[i] % 2 == 0){
            printf("Número par digitado na posição %d do vetor: %d\n", i, vetor[i]);
            somaPares += vetor[i];
        }else{
            printf("Número ímpar digitado na posição %d do vetor: %d\n", i, vetor[i]);
            quantImpares++;
        }
    }

    printf("\nA soma dos números pares digitados é: %d", somaPares);
    printf("\nA quantidade de números ímpares digitados é: %d\n\n", quantImpares);
}