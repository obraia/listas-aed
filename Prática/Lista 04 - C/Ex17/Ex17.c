#include "../Console.c"
#include <stdio.h>
#include <stdlib.h>

int main()
{
    clear();
    int maxSize = 45;
    char frase[maxSize];
    char fraseCriptografada[maxSize];
    int tamanho = 0;

    printf("Digite uma frase que deseja criptografar: ");
    scanf("%[^\n]%*c", frase);

    tamanho = length(frase, maxSize);

    inverterFrase(frase, fraseCriptografada, tamanho);

    printf("%s\n", frase);
    printf("%s\n\n", fraseCriptografada);
    return 0;
}

void inverterFrase(char frase[], char fraseInvertida[], int tamanho)
{
    for (int i = 0; i < tamanho; i++)
    {
        fraseInvertida[i] = frase[tamanho - 1 - i];
    }
}

int length(char array[], int maxSize)
{
    int size = 0;
    
    for (int i = 0; i < maxSize; i++){
        if (array[i] == NULL) break;
        else size++;
    }

    return size;
}