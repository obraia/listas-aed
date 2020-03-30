#include "../Console.c"
#include <stdio.h>
#include <stdlib.h>

int piso(float valor)
{
    return (int)valor;
}

int teto(float valor)
{
    if (valor == (int)valor)
    {
        return (int)valor;
    }
    else
    {
        return (int)valor + 1;
    }
}

int main()
{
    float valor = 5.3;

    printf("O piso do valor %g é: %d\n", valor, piso(valor));
    printf("O teto do valor %g é: %d\n", valor, teto(valor));

    return 0;
}
