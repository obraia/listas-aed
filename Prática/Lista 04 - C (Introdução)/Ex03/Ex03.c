#include "../Console.c";
#include <stdio.h>
#include <stdlib.h>

int main()
{
    clear();
    float salario;
    int aumento;

    printf("Digite o salário do funcionário: ");
    scanf("%f", &salario);  

    if(salario <= 1200) {
        aumento = 10;
        salario += salario*0.1;
    }else{
        aumento = 5;
        salario += salario*0.05;
    }

    printf("\nO funcionário teve um aumento de %d%% passando a R$ %.2f\n\n",aumento, salario);

    return 0;
}



