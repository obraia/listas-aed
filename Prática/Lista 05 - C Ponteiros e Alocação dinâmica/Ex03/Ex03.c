#include <stdio.h>
#include <stdlib.h>

int main()
{
    int quantAlunos = 0;
    float nota, somaNotas = 0;
    float *vetorNotas;

    printf("Digite a quantidade de alunos a serem matriculados: ");
    scanf("%d", &quantAlunos);

    vetorNotas = (float *)calloc(quantAlunos, sizeof(float));

    for (int i = 0; i < quantAlunos; i++)
    {
        printf("Digite a %da nota: ", (i + 1));
        scanf("%f", &nota);
        vetorNotas[i] = nota;
    }

    for (int i = 0; i < quantAlunos; i++)
    {
        somaNotas += vetorNotas[i];
    }

    free(vetorNotas);

    printf("A media aritmetica das notas: %.2f\n\n", (somaNotas / quantAlunos));

    return 0;
}