#include "../Console.c"
#include <stdio.h>
#include <stdlib.h>

typedef struct
{
    int id;
    int nota;
    char respostas[8];
} Aluno;

int main()
{
    int quantAlunos = 10;
    int quantQuestoes = 8;
    char gabarito[9] = {'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A'};
    Aluno vetorAlunos[quantAlunos];

    for (int i = 0; i < quantAlunos; i++)
    {
        clear();
        
        Aluno aluno;

        printf("\nGabarito: %s\n\n", gabarito);

        printf("Digite o número do %dº aluno: ", (i + 1));
        scanf("%d", &aluno.id);

        clear();

        for (int j = 0; j < quantQuestoes; j++)
        {
            printf("Digite a %dª resposta do  aluno: ", (j + 1));
            scanf("%s", &aluno.respostas[j]);
        }

        printf("\nGabarito: %s", gabarito);
        printf("\nRespostas do aluno: %s\n\n", aluno.respostas);

        aluno.nota = calcularNota(gabarito, aluno.respostas, quantQuestoes);
        
        vetorAlunos[i] = aluno;
    }

    clear();

    relatorioNotas(vetorAlunos, quantAlunos);

    printf("\n");

    return 0;
}

int calcularNota(char gabarito[], char respostasAluno[], int quantQuestoes)
{
    int nota = 0;

    for (int i = 0; i < quantQuestoes; i++)
    {
        if (respostasAluno[i] == gabarito[i])
        {
            nota++;
        }
    }
    return nota;
}

void relatorioNotas(Aluno vetorAlunos[], int quantAlunos)
{
    int quantAprovados = 0;

    for (int i = 0; i < quantAlunos; i++)
    {
        printf("Id: %d - Nota: %d\n", vetorAlunos[i].id, vetorAlunos[i].nota);
        if(vetorAlunos[i].nota >= 5){
            quantAprovados++;
        }
    }
    
    printf("\nPorcentagem de aprovação: %.2f%%\n", (float)quantAprovados / ((float)quantAlunos/100));
}

void esperar(){
    char a;
    printf("Digite qualquer tecla e pressione enter para continuar: ");
    scanf("%s", &a);
}