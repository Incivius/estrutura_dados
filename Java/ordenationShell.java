package Java;

import java.util.ArrayList;
import java.util.List;

public class ordenationShell {

    public static List<Integer> preencherLista(List<Integer> lista, int n) {
        for (int i = 0; i < n; i++) {
            lista.add((int) (Math.random() * 100));
        }
        return lista;
    }

    public static List<Integer> ordenarShell(List<Integer> lista, int n) {
        int intervalo = n / 2;
        while (intervalo > 0) {
            for (int j = intervalo; j < n; j = j + intervalo) {
                if (lista.get(j) < lista.get(j - intervalo)) {
                    int temp = j;
                    int temp2 = j - intervalo;
                    lista.set(j, lista.get(j - intervalo));
                    lista.set(temp2, temp);
                }
            }
            intervalo = intervalo/2;
            
        }
        return lista;
    }

    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<>();
        int n = 10;
        lista = preencherLista(lista, n);

        System.out.println("Lista antes da ordenação:");
        System.out.println(lista);

        lista = ordenarShell(lista, 10);

        System.out.println("Lista após a ordenação:");
        System.out.println(lista);
    }

}
