#include "../Console.c"
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

float soma(float a, float b)
{
    return a + b;
}

void menu()
{
    printf("1. Soma de dois números\n");
    printf("2. Raiz quadrada de um número\n");
    printf("\n");
}

int main()
{
    int opcao;
    float numA, numB, resultado;

    clear();
    menu();

    printf("Digite a opção desejada: ");
    scanf("%d", &opcao);
    clear();

    switch (opcao)
    {
    case 1:
        printf("Digite o primeiro número: ");
        scanf("%f", &numA);
        printf("Digite o segundo número: ");
        scanf("%f", &numB);
        resultado = soma(numA, numB);
        clear();
        printf("%g + %g = %g\n\n", numA, numB, resultado);
        break;

    case 2:
        printf("Digite um número para calcular a raiz: ");
        scanf("%f", &numA);
        resultado = sqrt(numA);
        clear();
        printf("A raiz de %g é %g\n\n", numA, resultado);
        break;

    default:
        printf("Opção inválida\n\n");
        break;
    }

    return 0;
}
