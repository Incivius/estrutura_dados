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

    // Inicia no intervalo e troca enquanto for verdade
    public static List<Integer> ordenarShell1(List<Integer> lista, int n) {
        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                int chave = lista.get(i);
                int j = i;
                while (j >= h && lista.get(j - h) > chave) {
                    lista.set(j, lista.get(j - h));
                    j -= h;
                }
                lista.set(j, chave);
            }
            h = h / 3;
        }

        return lista;
    }

    // Inicia no intervalo e troca se for verdade
    public static List<Integer> ordenarShell2(List<Integer> lista, int n) {
        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                int chave = lista.get(i);
                int j;
                for (j = i; (j >= h) && (lista.get(j - h) > chave); j -= h) {
                    lista.set(j, lista.get(j - h));
                }
                lista.set(j, chave);
            }
            h = h / 3;
        }
        return lista;
    }

    // Inicia no primeiro index e troca enquanto for verdade
    public static List<Integer> ordenarShell3(List<Integer> lista, int n) {
        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }
        while (h > 0) {
            for (int i = 0; i < n - h; i++) {
                int chave = lista.get(i);
                int j = i;
                while (j < n - h && chave > lista.get(j + h)) {
                    lista.set(j, lista.get(j + h));
                    j += h;
                    lista.set(j, chave);
                }
            }
            h = h / 3;
        }
        return lista;
    }

    // Inicia no primeiro index e troca se for verdade
    public static List<Integer> ordenarShell4(List<Integer> lista, int n) {
        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }
        while (h > 0) {
            for (int i = 0; i < n - h; i++) {
                int chave = lista.get(i);
                if (chave > lista.get(i + h)) {
                    int temp = i + h;
                    lista.set(i, lista.get(temp));
                    lista.set(temp, chave);
                }
            }
            h = h / 3;
        }
        return lista;
    }

    // Inicia no primeiro index e troca se for verdade
    public static List<Integer> ordenarShell5(List<Integer> lista, int n) {
        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = 0; i < n - h; i++) {
                int chave = lista.get(i);
                int j = i + h;
                if (chave > lista.get(j)) {
                    lista.set(i, lista.get(j));
                    lista.set(j, chave);
                }
            }
            h = h / 3;
        }
        return lista;
    }

    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<>();
        int n = 10;
        lista = preencherLista(lista, n);

        System.out.println("Lista antes da ordenação:");
        System.out.println(lista);

        lista = ordenarShell1(lista, n);

        System.out.println("Lista após a ordenação:");
        System.out.println(lista);
    }
}
