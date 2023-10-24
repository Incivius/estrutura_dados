#include <stdio.h>
#include <stdlib.h>

typedef struct CarModule {
  int valor;
  int boolean;
  struct CarModule *proximo;
} Module;

Module *createModule() {
  Module *head = malloc(sizeof(Module));
  head->valor = 0;
  head->boolean = 1;
  head->proximo = NULL;
  return head;
}

Module *addModule(int novo, Module *head) {
  Module *newModule = malloc(sizeof(Module));
  newModule->valor = novo;
  newModule->boolean = 1;
  newModule->proximo = NULL;
  head->proximo = newModule;
  printf("add: Novo valor: %d \n", newModule->valor);
  return newModule;
}

Module *selectModule(int atual, Module *head) {
  while (head != NULL) {
    if (head->valor == atual) {
      printf("select: Valor: %d Local: %p \n", head->valor, head);
      break;
    }
    head = head->proximo;
  }
  if (head == NULL) {
    printf("select: Valor %d não encontrado na lista.\n", atual);
  }
  return head;
}

int activeCar(Module *head) {
  int i = 1;
  while (head->proximo != NULL || head->proximo == NULL) {
    if (head->boolean == 1) {
      printf("actives: Valor: %d | Status: %d \n", head->valor, head->boolean);
      head = head->proximo;
      int i = 1;
    } else {
      int i = 0;
    }
  }
  return i;
}

// Module *updateModule(Module *head, int atual, int boolean) {
//   Module *mod = selectModule(atual, head);
//   mod->valor = atual;
//   mod->boolean = boolean;
//   printf("update: Valor: %d | Status: %d \n", mod->valor, mod->boolean);
//   return mod;
// }

// struct Module *deleteModule(int atual, struct Module *head) {
//   struct Module *head = selectModule(atual, head);
//   struct Module *ant = head;
//   if (mod == NULL) {
//     printf("delete: Valor %d não encontrado na lista.\n", atual);
//   }
//   if (head == mod) {
//     head = mod->proximo;
//   } else {
//     while (head->valor != mod->valor) {
//       ant = head;
//       head = head->proximo;
//     };
//     ant->proximo = mod->proximo;
//   }
//   printf("delete: Valor: %d | Local: %p \n", ant->valor, ant->proximo);
//   free(mod);
//   return ant;
// }

// Module *createModuleFila() {
//   Module *head = malloc(sizeof(Module));
//   head->valor = 0;
//   head->boolean = 1;
//   head->proximo = NULL;
//   return head;
// }


Module *addFila(int novo, Module **inicio, Module **fim) {
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
  Module * mod1 = createModule();
  Module * mod2 = createModule();

  addFila(1, &mod1, &mod2);
  addFila(2, &mod1, &mod2);
  addFila(3, &mod1, &mod2);
  
}