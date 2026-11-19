package algoritmos;

public class OrdenamientoQuickSort {

    public static final String NOMBRE = "QuickSort (Caso2)";

    public void ordenar(int[] arreglo) {
        if (arreglo == null || arreglo.length <= 1) {
            return;
        }
        quickSort(arreglo, 0, arreglo.length - 1);
    }

    private void quickSort(int[] arreglo, int bajo, int alto) {
        while (bajo < alto) {
            int indicePivote = particionar(arreglo, bajo, alto);

            // Recurrir primero al subarreglo más pequeño para limitar la profundidad de pila
            if (indicePivote - bajo < alto - indicePivote) {
                quickSort(arreglo, bajo, indicePivote - 1);
                bajo = indicePivote + 1;
            } else {
                quickSort(arreglo, indicePivote + 1, alto);
                alto = indicePivote - 1;
            }
        }
    }

    private int particionar(int[] arreglo, int bajo, int alto) {
        int pivote = arreglo[alto];
        int i = bajo - 1;

        for (int j = bajo; j < alto; j++) {
            if (arreglo[j] <= pivote) {
                i++;
                intercambiar(arreglo, i, j);
            }
        }
        intercambiar(arreglo, i + 1, alto);
        return i + 1;
    }

    private void intercambiar(int[] arreglo, int i, int j) {
        if (i != j) {
            int temp = arreglo[i];
            arreglo[i] = arreglo[j];
            arreglo[j] = temp;
        }
    }
}