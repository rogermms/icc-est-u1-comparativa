package algoritmos;

public class OrdenamientoInsercion {

    public static final String NOMBRE = "Insercion (Caso1)";

    public void ordenar(int[] arreglo) {
        if (arreglo == null || arreglo.length <= 1) {
            return;
        }

        for (int i = 1; i < arreglo.length; i++) {
            int clave = arreglo[i];
            int j = i - 1;

            while (j >= 0 && arreglo[j] > clave) {
                arreglo[j + 1] = arreglo[j];
                j--;
            }
            arreglo[j + 1] = clave;
        }
    }
}
