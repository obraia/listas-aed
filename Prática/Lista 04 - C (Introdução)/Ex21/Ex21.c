// --> Para poder testar usei randoms para acelerar o processo
// as funções para entradas de dados se encontram comentadas
// então basta retirar os comentários e comentar as linhas com  "// --> Random"

#include "../Console.c"
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <ctype.h>
#include <limits.h>

typedef struct
{
    char sexo;
    float salario;
    int quantidadeFilhos;
} Pessoa;

void preencherVetor(Pessoa vetor[], int tamanho)
{
    srand(time(NULL));
    Pessoa pessoa;
    float salario = 0;
    char sexo = ' ';
    int quantFilhos = 0;
    bool loop = false;

    for (int i = 0; i < tamanho; i++)
    {
        clear();
        // printf("Preencha os dados da %dª pessoa:\n\n", i + 1);
        do
        {
            // printf("Digite o salário: ");
            // scanf("%f", &salario);

            salario = (rand() % 9999); // --> Random

            if (salario >= 0)
            {
                loop = false;
            }
            else
            {
                clear();
                printf("Digite um salario válido!\n\n");
                loop = true;
            }
        } while (loop);

        do
        {
            // printf("Digite o sexo: ");
            // scanf(" %c", &sexo);
            // sexo = tolower(sexo);

            if ((rand() % 9999) % 2 == 0) sexo = 'm'; // --> Random
            else sexo = 'f'; // --> Random

            if (sexo == 'm' || sexo == 'f')
            {
                loop = false;
            }
            else
            {
                clear();
                printf("Digite um sexo válido!\n\n");
                loop = true;
            }

        } while (loop);

        do
        {
            // printf("Digite a quantidade de filhos: ");
            // scanf("%d", &quantFilhos);

            quantFilhos = (rand() % 10); // --> Random

            if (quantFilhos >= 0)
            {
                loop = false;
            }
            else
            {
                clear();
                printf("Digite uma quantidade de filhos válida!\n\n");
                loop = true;
            }

        } while (loop);

        pessoa.sexo = sexo;
        pessoa.quantidadeFilhos = quantFilhos;
        pessoa.salario = salario;

        vetor[i] = pessoa;
    }
}

float mediaSalario(Pessoa vetor[], int tamanho)
{
    float somaSalario = 0;

    for (int i = 0; i < tamanho; i++)
    {
        somaSalario += vetor[i].salario;
    }

    return (float)somaSalario / tamanho;
}

int mediaFilhos(Pessoa vetor[], int tamanho)
{
    float somaFilhos = 0;

    for (int i = 0; i < tamanho; i++)
    {
        somaFilhos += vetor[i].quantidadeFilhos;
    }

    return somaFilhos / tamanho;
}

float percentualMulheresSalarioMaior1500(Pessoa vetor[], int tamanho)
{
    int quantMulheres = 0;

    for (int i = 0; i < tamanho; i++)
    {
        if (vetor[i].sexo == 'f')
        {
            if (vetor[i].salario > 1500.00)
            {
                quantMulheres++;
            }
        }
    }

    return ((float)quantMulheres * 100) / tamanho;
}

void imprimirVetor(Pessoa vetor[], int tamanho)
{
    for (int i = 0; i < tamanho; i++)
    {
        printf("%d - sexo: %c - salário: R$ %.2f - quantidade de filhos: %d\n",
               (i + 1), vetor[i].sexo, vetor[i].salario, vetor[i].quantidadeFilhos);
    }
}

int main()
{
    int quantPessoas = 20;
    Pessoa vetorPessoas[quantPessoas];

    preencherVetor(vetorPessoas, quantPessoas);

    imprimirVetor(vetorPessoas, quantPessoas);

    printf("\n");

    printf("Salário médio da população R$ %.2f\n", mediaSalario(vetorPessoas, quantPessoas));
    printf("O número médio de filhos é %d\n", mediaFilhos(vetorPessoas, quantPessoas));
    printf("O percentual de mulher com salário maior que R$ 1500.00 é %.2f%%\n\n", percentualMulheresSalarioMaior1500(vetorPessoas, quantPessoas));

    return 0;
}
