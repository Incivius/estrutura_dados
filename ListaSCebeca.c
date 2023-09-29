#include <stdio.h>
#include <stdlib.h>

typedef struct CarModule {
int valor;
int boolean;
  struct CarModule *proximo;
} Module;

Module *inseriPrimeira(int y, Module *p) {
  Module *nova;
nova = malloc(sizeof(Module));
nova->valor = y;
nova->boolean = 1;
nova->proximo = NULL;
p = nova;
printf("add: Novo valor: %d \n", p->valor);
return p;
}

Module *insereDepois(int y, Module *p) {
if (p == NULL) {
    p = malloc(sizeof(Module));
    p->valor = y;
    p->boolean = 1;
    p->proximo = NULL;
    printf("add caso seja o primeiro da lista: Novo valor: %d \n", p->valor);
    
} else {
    Module *nova;
    nova = malloc(sizeof(Module));
    nova->valor = y;
    nova->boolean = 1;
    nova->proximo = NULL;
    p->proximo = nova;
    p = nova;
    printf("add depois do module passado como paramêtro no ponteiro : Novo "
        "valor: %d \n",
        nova->valor);
}
return p;
}

int main(void) {
  Module *primeiro;
  Module *mod;

primeiro = insereDepois(1, primeiro);
mod = insereDepois(2, primeiro);
mod = insereDepois(3, mod);

primeiro = inseriPrimeira(0, primeiro);

return 0;
}