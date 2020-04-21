#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int main()
{
    int *num = (int *)malloc(sizeof(int));
    int j;
    int *ehPrimo = (int *)malloc(sizeof(int));
    *ehPrimo = 0;

    printf("valor de ehPrimo: %d\n", *ehPrimo);

    printf("Digite um numero inteiro maior ou igual a 3: ");
    scanf("%d", num);

    for (j = 1; j <= *num; j++)
    {
        if (*num % j == 0)
        {
            printf("Dividiu por %d\n", j);
            *ehPrimo += 1;
        }
    }

    printf("\n%d dividiu por %d numeros\n\n", *num, *ehPrimo);

    if (*ehPrimo > 2)
    {
        printf("O numero %d nao e primo", *num);
    }
    else
    {
        printf("O numero %d e primo", *num);
    }

    return 0;
}
