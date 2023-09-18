#include <stdio.h>
#include <stdlib.h>

struct CarModule {
  int valor;
  int boolean;
  struct CarModule *proximo;
};

struct CarModule *createModule() {
  struct CarModule *head = malloc(sizeof(struct CarModule));
  head->valor = 0;
  head->boolean = 1;
  head->proximo = NULL;
  return head;
}

struct CarModule *addModule(int novo, struct CarModule **head) {
    struct CarModule *newModule = malloc(sizeof(struct CarModule));
    newModule->valor = novo;
    newModule->boolean = 1;
    newModule->proximo = NULL;

    if (*head == NULL) {
        *head = newModule;
    } else {
        struct CarModule *current = *head;
        while (current->proximo != NULL) {
            current = current->proximo;
        }
        current->proximo = newModule;
    }

    printf("add: Novo valor: %d \n", newModule->valor);
    return *head;
}

struct CarModule *selectModule(int atual, struct CarModule *head) {
    struct CarModule *mod = head;

    while (mod != NULL) {
        if (mod->valor == atual) {
            printf("select: Valor: %d Local: %p \n", mod->valor, mod);
            break;
        }
        mod = mod->proximo;
    }

    if (mod == NULL) {
        printf("select: Valor %d não encontrado na lista.\n", atual);
    }

    return mod;
}

int activeCar(struct CarModule *head) {
    struct CarModule *mod = head;
    int i = 1;
    while (mod->proximo != NULL || mod->proximo  == NULL) {
        if (mod->boolean == 1) {
          printf("actives: Valor: %d | Status: %d \n", mod->valor, mod->boolean);
          mod = mod-> proximo;
          int i = 1;
        }
        else{
          int i = 0;
        }
    }
  return i;
}

struct CarModule *updateModule(int atual, struct CarModule *head, int boolean) {
  struct CarModule *mod = selectModule(atual, head);
  mod->valor = atual;
  mod->boolean = boolean;
  printf("update: Valor: %d | Status: %d \n", mod->valor, mod->boolean);
  return mod;
}

struct CarModule * deleteModule(int atual, struct CarModule * head) {
    struct CarModule *mod = selectModule(atual, head);
    struct CarModule *ant = head;
    if (mod == NULL) {
        printf("delete: Valor %d não encontrado na lista.\n", atual);
    }
    if (head == mod) {
        head = mod->proximo;
    } else {
        while (head->valor != mod->valor) {
            ant = head;
            head = head->proximo;
        };
        ant->proximo = mod->proximo;
    }
    printf("delete: Valor: %d | Local: %p \n", ant->valor, ant->proximo);
    free(mod);
  return ant;
}

int main(void) {
  struct CarModule *car = createModule();
  addModule(2, &car);
  addModule(3, &car);
  addModule(4, &car);
  selectModule(3, car);
  updateModule(4, car, 1);
  deleteModule(2, car);
  activeCar(car);
}