#include "../Console.c"
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <ctype.h>

typedef struct
{
    char sexo;
    float salario;
    int quantidadeFilhos;
} Pessoa;

void esperar()
{
    char a;
    printf("Digite qualquer tecla e pressione enter para continuar: ");
    scanf("%s", &a);
}

void preencherVetor(Pessoa vetor[], int tamanho)
{
    Pessoa pessoa;
    float salario = 0;
    char sexo = ' ';
    int quantFilhos = 0;
    bool loop = false;

    for (int i = 0; i < tamanho; i++)
    {
        clear();
        printf("Preencha os dados da %dª pessoa:\n\n", i+1);
        do
        {
            printf("Digite o salário: ");
            scanf("%f", &salario);
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
            printf("Digite o sexo: ");
            scanf(" %c", &sexo);
            sexo = tolower(sexo);

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
            printf("Digite a quantidade de filhos: ");
            scanf("%d", &quantFilhos);

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

int main()
{
    int quantPessoas = 3;

    Pessoa vetorPessoas[quantPessoas];

    preencherVetor(vetorPessoas, quantPessoas);
}
