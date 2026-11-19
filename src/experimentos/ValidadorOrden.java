package experimentos;

import java.util.Arrays;

public class ValidadorOrden {

    public void validarInt(int[] original, int[] ordenado) {
        if (original == null || ordenado == null) {
            throw new IllegalStateException("Los arreglos no pueden ser nulos en la validación.");
        }
        if (original.length != ordenado.length) {
            throw new IllegalStateException("La cantidad de elementos cambió: esperado="
                    + original.length + ", obtenido=" + ordenado.length);
        }
        for (int i = 1; i < ordenado.length; i++) {
            if (ordenado[i - 1] > ordenado[i]) {
                throw new IllegalStateException("El arreglo no está ordenado en el índice " + i
                        + ": " + ordenado[i - 1] + " > " + ordenado[i]);
            }
        }
        int[] copiaEsperada = original.clone();
        Arrays.sort(copiaEsperada);
        if (!Arrays.equals(copiaEsperada, ordenado)) {
            throw new IllegalStateException("Los elementos o repeticiones no coinciden con la muestra original.");
        }
    }

    public void validarInteger(int[] original, Integer[] ordenado) {
        if (original == null || ordenado == null) {
            throw new IllegalStateException("Los arreglos no pueden ser nulos en la validación Integer[].");
        }
        if (original.length != ordenado.length) {
            throw new IllegalStateException("La cantidad de elementos cambió en Integer[]: esperado="
                    + original.length + ", obtenido=" + ordenado.length);
        }
        for (int i = 1; i < ordenado.length; i++) {
            if (Integer.compare(ordenado[i - 1], ordenado[i]) > 0) {
                throw new IllegalStateException("El arreglo Integer[] no está ordenado en el índice " + i);
            }
        }
        int[] copiaEsperada = original.clone();
        Arrays.sort(copiaEsperada);
        int[] ordenadoPrimitivo = new int[ordenado.length];
        for (int i = 0; i < ordenado.length; i++) {
            ordenadoPrimitivo[i] = ordenado[i];
        }
        if (!Arrays.equals(copiaEsperada, ordenadoPrimitivo)) {
            throw new IllegalStateException("Los elementos o repeticiones en Integer[] no coinciden con el original.");
        }
    }
}
