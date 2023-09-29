#include <stdio.h>
#include <stdlib.h>

typedef struct CarModule {
  int valor;
  int boolean;
  struct CarModule *proximo;
} Module;

Module *addFila(int novo, Module ** inicio, Module **fim) {
  Module *newModule = malloc(sizeof(Module));
  if (*inicio == NULL) {
    *inicio = newModule;
    *fim = newModule;
  } else {
    (*fim)->proximo = newModule;
    *fim = newModule;
  }
  newModule->valor = novo;
  newModule->boolean = 1;
  newModule->proximo = NULL;
  printf("add: Novo valor: %d \n", newModule->valor);
  return newModule;
}

int addDepois(int novo, Module ** anterior, Module **fim) {
  printf("Depois: fim %d \n", (*fim)->valor);
  printf("Depois: anterior %d \n", (*anterior)->valor);
  printf("Depois: fim %p \n", (*fim)->proximo);
  printf("Depois: anterior %p \n", (*anterior)->proximo);
  Module *newModule = malloc(sizeof(Module));
  printf("Depois: new  %p \n", newModule);
  int resposta = 0;
  if (*anterior == *fim) {
    *fim = newModule;
    (*fim)->proximo = newModule;
    resposta = 1;
  } else {
    newModule->proximo = (*anterior)->proximo;
    (*anterior)->proximo = newModule;
    resposta = 1;
    // printf("Depois: ultimo %d \n", newModule->valor);
  }
  newModule->valor = novo;
  newModule->boolean = 1;
  
  printf("Depois: ultimo %p \n", newModule->proximo);
  printf("Depois: fim %p \n", (*fim)->proximo);
  printf("Depois: anterior %p \n", (*anterior)->proximo);
  return resposta;
}

Module *excluiDaFila(int novo, Module ** inicio, Module **fim) {
  Module *newModule = malloc(sizeof(Module));
  if (*inicio == NULL) {
    *inicio = newModule;
    *fim = newModule;
  } else {
    (*fim)->proximo = newModule;
    *fim = newModule;
  }
  newModule->valor = novo;
  newModule->boolean = 1;
  newModule->proximo = NULL;
  printf("add: Novo valor: %d \n", newModule->valor);
  return newModule;
}


int main(void) {
  Module * mod1;
  Module * mod2; 
  Module * mod3;

  addFila(1, &mod1, &mod2);
  addFila(2, &mod1, &mod2);
  mod3 = addFila(3, &mod1, &mod2);
  addFila(5, &mod1, &mod2);
  addFila(4, &mod1, &mod2);
  addDepois(6 ,&mod3, &mod2);
  
}