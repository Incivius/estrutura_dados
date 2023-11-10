package Java;

import java.util.ArrayList;
import java.util.List;

public class ordenationMerge {
    
    public static List<Integer> preencherLista(List<Integer> lista, int n) {
        for (int i = 0; i < n; i++) {
            lista.add((int) (Math.random() * 100));
        }
        return lista;
    }
    
    
 public static List<Integer> mergeSort(List<Integer> lista, int n) {
    if (n <= 1) {
        return lista;
    }

    int meio = n / 2;

    esquerda = mergeSort(esquerda, meio);
    direita = mergeSort(direita, meio);

    List<Integer> resultado = new ArrayList<>();
    int i = 0;
    int j = 0;

    while (i < esquerda.size() && j < direita.size()) {
        if (esquerda.get(i) < direita.get(j)) {
            resultado.add(esquerda.get(i));
            i++;
        } else {
            resultado.add(direita.get(j));
            j++;
        }
    }

    resultado.addAll(esquerda.subList(i, esquerda.size()));
    resultado.addAll(direita.subList(j, direita.size()));

    return resultado;
}

// public static List<Integer> mergeSort2(List<Integer> lista) {
//     if (lista.size() <= 1) {
//         return lista; // A lista já está ordenada
//     }

//     int meio = lista.size() / 2;

//     List<Integer> esquerda = new ArrayList<>();
//     for (int i = 0; i < meio; i++) {
//         esquerda.add(lista.get(i));
//     }

//     List<Integer> direita = new ArrayList<>();
//     for (int i = meio; i < lista.size(); i++) {
//         direita.add(lista.get(i));
//     }

//     esquerda = mergeSort(esquerda);
//     direita = mergeSort(direita);

//     List<Integer> resultado = new ArrayList<>();
//     for (int i = 0; i < esquerda.size(); i++) {
//         resultado.add(esquerda.get(i));
//     }
//     for (int i = 0; i < direita.size(); i++) {
//         resultado.add(direita.get(i));
//     }

//     return resultado;
// }

    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<>();
        int n = 10;
        lista = preencherLista(lista, n);

        System.out.println("Lista antes do Merge Sort:");
        System.out.println(lista);

        lista = mergeSort(lista);

        System.out.println("Lista após o Merge Sort:");
        System.out.println(lista);
    }
}
