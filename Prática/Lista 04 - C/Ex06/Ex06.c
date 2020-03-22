#include "../Console.c"
#include <stdio.h>
#include <stdlib.h>

main(){
    int numA, numB;

    clear();

    printf("Digite dois número inteiros:\n");
    scanf("%d %d", &numA, &numB);

    clear();

    if((numA + numB) % 2 == 0) printf("A soma %d + %d é par\n\n", numA, numB);
    else printf("A soma %d + %d é ímpar\n\n", numA, numB);
}