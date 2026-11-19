package algoritmos;

import java.util.Arrays;
import java.util.Comparator;

public class OrdenamientoBiblioteca {

    public static final String NOMBRE_V3 = "Arrays.sort int[] (V3)";
    public static final String NOMBRE_V4 = "Arrays.sort Comparator Integer[] (V4)";

    // Comparador seguro sin resta aritmética (evita overflow)
    public static final Comparator<Integer> COMPARADOR_ASCENDENTE_SEGURO = Integer::compare;

    public void ordenarPrimitivo(int[] arreglo) {
        if (arreglo == null || arreglo.length <= 1) {
            return;
        }
        Arrays.sort(arreglo);
    }

    public void ordenarConComparador(Integer[] arreglo, Comparator<Integer> comparador) {
        if (arreglo == null || arreglo.length <= 1) {
            return;
        }
        Arrays.sort(arreglo, comparador);
    }
}
