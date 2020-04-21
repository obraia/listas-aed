#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <limits.h>

int main() {
    int i;
    int *maior = (int *)malloc(sizeof(int));
    int *menor = (int *)malloc(sizeof(int));
    int *vetor = (int *)calloc(10, sizeof(int));

    *maior = INT_MIN;
    *menor = INT_MAX;

    srand(time(NULL));
    for (i = 0; i < 10; i++) {
        vetor[i] = (rand() % 100) + 1;
    }

    for (i = 0; i < 10; i++) {
        if(*maior < vetor[i]) *maior = vetor[i];
        if(*menor > vetor[i]) *menor = vetor[i];
    }

    for (i = 0; i < 10; i++) {
        printf("%d ", vetor[i]);
    }

    printf("\n\nO maior valor e: %d\n", *maior);
    printf("O menor valor e: %d\n\n", *menor);
}
