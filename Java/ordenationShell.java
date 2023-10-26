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
        //Define o intervalo
        int h = 1;
        
        //Busca o intervalo maximo
        while (h < n / 3) {
            h = 3 * h + 1;
        }
        //Enqunato o intervalo for maior ou igual a 1
        while (h >= 1) {

            //Inicia o loop no index de mesmo valor do intervalo, i é o valor que queremos ordenar
            for (int i = h; i < n; i++) {
                //cria uma variavél que armazena o valor de i
                int chave = lista.get(i);
                //cria uma variavél que armazena o index de i
                int j = i;
                //Enquanto J for 'maior ou igual' ao valor do intervalo ou o valor contido no index anterior em relação ao intervalo
                //for maior que o valor contido no index atual.
                while (j >= h && lista.get(j - h) > chave) {
                    lista.set(j, lista.get(j - h));
                    j -= h;
                }
                //Atribui a posição J o valor chave
                lista.set(j, chave);
            }
            //Divide o intervalo em 3
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

        lista = ordenarShell(lista, n);

        System.out.println("Lista após a ordenação:");
        System.out.println(lista);
    }
}
