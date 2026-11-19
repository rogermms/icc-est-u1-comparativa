package generador;

import java.util.Random;

public class GeneradorMuestras {
    private Random random;

    public GeneradorMuestras() {
        this.random = new Random();
    }

    public GeneradorMuestras(long semilla) {
        this.random = new Random(semilla);
    }

    public int[] generarMuestra(int n) {
        if (n < 0) {
            System.out.println("Error: el tamaño no puede ser negativo: " + n);
            return null;
        }
        if (n == 0) {
            return new int[0];
        }

        int[] arreglo = new int[n];
        long limite = (long) n + 1L;
        for (int i = 0; i < n; i++) {
            long numero = (long) (random.nextDouble() * limite);
            if (numero > n) {
                numero = n;
            }
            arreglo[i] = (int) numero;
        }
        return arreglo;
    }

    public int[] clonar(int[] original) {
        int[] copia = new int[original.length];
        for (int i = 0; i < original.length; i++) {
            copia[i] = original[i];
        }
        return copia;
    }

    public Integer[] clonarComoInteger(int[] original) {
        Integer[] copia = new Integer[original.length];
        for (int i = 0; i < original.length; i++) {
            copia[i] = original[i];
        }
        return copia;
    }
}