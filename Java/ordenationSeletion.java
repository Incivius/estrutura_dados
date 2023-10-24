package Java;
import java.util.ArrayList;
import java.util.List;

public class ordenationSeletion {
    // Recebe uma lista e o tamanho dela e retorna um lista de inteiro
    public static List<Integer> preencherLista(List<Integer> lista, int n) {
        // Enquanto i for menor que o tamanho da lista
        for (int i = 0; i < n; i++) {
            // Adiciona valores aleatria na lista
            lista.add((int) (Math.random() * 100));
        }
        return lista;
    }

    public static List<Integer> ordenarPorSelecao(List<Integer> lista, int n) {
        // Enquanto i for menor que o tamanho da lista
        for (int i = 0; i < n-1; n--) {
            int indiceMaior = i;
            // Enquanto j for menor que o tamanho da lista
            for (int j = i + 1; j < n; j++) {
                // J é maior que indiceMaior? Se sim, indiceMaior = J
                if (lista.get(j) > lista.get(indiceMaior)) {
                    indiceMaior = j;
                    System.out.printf("Maior agora: %d ", lista.get(j));
                }
            }
                int temp = lista.get(indiceMaior);
                lista.set(indiceMaior, lista.get(n-1));
                lista.set(n-1, temp);
        }
        return lista;
    }
    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<>();
        int n = 10;
        lista = preencherLista(lista, n);
        
        System.out.println("Lista antes da ordenação:");
        System.out.println(lista);

        lista = ordenarPorSelecao(lista, 10);

        System.out.println("Lista após a ordenação:");
        System.out.println(lista);
    }
}
