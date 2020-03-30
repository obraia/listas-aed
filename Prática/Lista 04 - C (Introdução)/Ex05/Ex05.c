#include "../Console.c"
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h> 

int main()
{
    int quantNotas = 3;
    float nota = 0;
    float somaNotas = 0;
    float media = 0;
    bool loop = false;

    for (int i = 0; i < quantNotas; i++)
    {
        clear();

        do{
            printf("Digite a %dº nota: ", i+1);
            scanf("%f",&nota);

            if(nota >= 0 && nota <=10){
                somaNotas += nota;
                loop = false;
            }else{
                clear();
                printf("Nota inválida, digite uma nota entre 0 e 10\n\n");
                loop = true;
            }

        } while(loop);

    }

    clear();

    media = somaNotas/quantNotas;

    printf("A média aritmética é %.2g, situação: ", media);

    if(media < 4.0) printf("Reprovado\n\n");
    else if(media < 6.0) printf("Exame Especial\n\n");
    else printf("Aprovado\n\n");

    return 0;
}

