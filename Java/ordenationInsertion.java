package Java;

import java.util.ArrayList;
import java.util.List;

public class ordenationInsertion {

    public static List<Integer> preencherLista(List<Integer> lista, int n) {
        for (int i = 0; i < n; i++) {
            lista.add((int) (Math.random() * 100));
        }
        return lista;
    }
    public static List<Integer> ordenarPorInsercao(List<Integer> lista, int n) {
        for (int i = 1; i < n; i++) {
            int chave = lista.get(i);
            int j = i - 1;
            while (j >= 0 && lista.get(j) > chave) {
                lista.set(j + 1, lista.get(j));
                j--;
            }
            lista.set(j + 1, chave);
            System.out.println(lista);
        }
        return lista;
    }
    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<Integer>();
        lista = preencherLista(lista, 8);
        lista = ordenarPorInsercao(lista, 8);
        System.out.println(lista);
    }
}
