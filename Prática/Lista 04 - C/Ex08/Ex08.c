#include "../Console.c"
#include <stdio.h>
#include <stdlib.h>

long fatorial(int n)
{
    for (int i = n - 1; i > 1; i--)
    {
        n *= i;
    }
    return n;
}

main()
{
    int N;

    clear();

    printf("Digite a quantidade de número para calcular o fatorial: ");
    scanf("%d", &N);

    int vetor[N];

    for (int i = 0; i < N; i++)
    {
        clear();
        printf("Digite o %dº valor: ", i + 1);
        scanf("%d", &vetor[i]);
    }

    clear();

    for (int i = 0; i < N; i++)
    {
        printf("%d! = %d\n", vetor[i], fatorial(vetor[i]));
    }

    printf("\n");
}
