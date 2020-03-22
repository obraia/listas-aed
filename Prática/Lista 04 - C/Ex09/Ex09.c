#include "../Console.c"
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

void menu()
{
    printf("1. Média Aritmética\n");
    printf("2. Média Ponderada\n");
    printf("3. Média Aritmética e Ponderada\n");
    printf("4. Sair\n");
    printf("\nDigite a opção desejada: ");
}

float mediaAritmetica(float valores[], int tamanho)
{
    float soma = 0;

    for (int i = 0; i < tamanho; i++)
    {
        soma += valores[i];
    }
    return soma / tamanho;
}

float mediaPonderada(float valores[], float pesos[], int tamanho)
{
    float soma = 0;
    float somaPesos = 0;

    for (int i = 0; i < tamanho; i++)
    {
        soma += valores[i] * pesos[i];
    }

    for (int i = 0; i < tamanho; i++)
    {
        somaPesos += pesos[i];
    }
    return soma / somaPesos;
}

void preecnherVetor(float valores[], int tamanho)
{
    for (int i = 0; i < tamanho; i++)
    {
        printf("Digite o %dº valor: ", i + 1);
        scanf("%f", &valores[i]);
    }
}

main()
{
    int opcao = 0;
    bool loop = true;
    int quantValores = 3;
    int valores[quantValores];
    int pesos[quantValores];

    do
    {
        clear();
        menu();
        scanf("%d", &opcao);
        clear();

        switch (opcao)
        {
        case 1:
            printf("Preencha com os valores\n\n");
            preecnherVetor(valores, quantValores);
            clear();
            printf("\nA média aritmética é %g\n\n", mediaAritmetica(valores, quantValores));
            esperar();
            break;

        case 2:
            printf("Preencha com os valores\n\n");
            preecnherVetor(valores, quantValores);
            clear();
            printf("Preencha com os pesos\n\n");
            preecnherVetor(pesos, quantValores);
            clear();
            printf("\nA média ponderada é %g\n\n", mediaPonderada(valores, pesos, quantValores));
            esperar();
            break;

        case 3:
            printf("Preencha com os valores\n\n");
            preecnherVetor(valores, quantValores);
            clear();
            printf("Preencha com os pesos\n\n");
            preecnherVetor(pesos, quantValores);
            clear();
            printf("\nA média aritmética é %g\n", mediaAritmetica(valores, quantValores));
            printf("\nA média ponderada é %g\n\n", mediaPonderada(valores, pesos, quantValores));
            esperar();
            break;

        case 4:
            loop = false;
            break;

        default:
            printf("Opção inválida\n\n");
            break;
        }
    } while (loop);
}

void esperar(){
    char a;
    printf("Digite qualquer tecla e pressione enter para voltar ao menu: ");
    scanf("%s", &a);
}