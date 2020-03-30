#include "../Console.c"
#include <stdio.h>
#include <stdlib.h>

main(){
    int quantVeiculos = 5;
    int quantMultas = 0;
    int velocidadeMax = 60;
    float totalArrecadado = 0;
    float velocidade;

    for(int i = 0; i < quantVeiculos; i++){
        clear();
        printf("Digite a velocidade do %dº veículo: ", i+1);
        scanf("%f", &velocidade);  
        if(velocidade > velocidadeMax){
            quantMultas++;
            totalArrecadado += 150;
        }
    }
    
    clear();

    printf("%d veículos foram multados, tendo um total arrecadado de R$ %.2f\n\n", quantMultas, totalArrecadado);
    
}