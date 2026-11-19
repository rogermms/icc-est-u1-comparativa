package experimentos;

import algoritmos.OrdenamientoBiblioteca;
import algoritmos.OrdenamientoInsercion;
import algoritmos.OrdenamientoQuickSort;
import benchmark.BenchMarkTempo;
import generador.GeneradorMuestras;
import java.util.Arrays;
import modelos.Resultado;

public class PruebasAceptacion {

    public static void main(String[] args) {
        GeneradorMuestras generador = new GeneradorMuestras(42L);
        BenchMarkTempo timer = new BenchMarkTempo();
        ValidadorOrden validador = new ValidadorOrden();
        OrdenamientoInsercion v1 = new OrdenamientoInsercion();
        OrdenamientoQuickSort v2 = new OrdenamientoQuickSort();
        OrdenamientoBiblioteca bib = new OrdenamientoBiblioteca();

        // CA01
        for (int n : new int[]{10_000, 50_000, 100_000}) {
            int[] arr = generador.generarMuestra(n);
            if (arr.length != n) throw new AssertionError("Fallo CA01 longitud en " + n);
            for (int x : arr) {
                if (x < 0 || x > n) throw new AssertionError("Fallo CA01 rango en " + n);
            }
        }
        System.out.println("CA01 OK");

        // CA02
        int[] vacio = generador.generarMuestra(0);
        if (vacio.length != 0) throw new AssertionError("Fallo CA02 n=0");
        boolean rechazoNegativo = false;
        try {
            generador.generarMuestra(-5);
        } catch (IllegalArgumentException e) {
            rechazoNegativo = true;
        }
        if (!rechazoNegativo) throw new AssertionError("Fallo CA02 n negativo");
        System.out.println("CA02 OK");

        // CA03 & CA04
        int[] baseCA04 = {7, 2, 7, 0, 4, 2};
        int[] esperadoCA04 = {0, 2, 2, 4, 7, 7};
        int[] c1 = generador.clonarArreglo(baseCA04);
        int[] c2 = generador.clonarArreglo(baseCA04);
        int[] c3 = generador.clonarArreglo(baseCA04);
        Integer[] c4 = generador.convertirAIntegerClon(baseCA04);

        v1.ordenar(c1);
        v2.ordenar(c2);
        bib.ordenarPrimitivo(c3);
        bib.ordenarConComparador(c4, OrdenamientoBiblioteca.COMPARADOR_ASCENDENTE_SEGURO);

        if (!Arrays.equals(c1, esperadoCA04) || !Arrays.equals(c2, esperadoCA04) || !Arrays.equals(c3, esperadoCA04)) {
            throw new AssertionError("Fallo CA04 int[]");
        }
        Integer[] c4Esp = {0, 2, 2, 4, 7, 7};
        if (!Arrays.equals(c4, c4Esp)) {
            throw new AssertionError("Fallo CA04 Integer[]");
        }
        validador.validarInt(baseCA04, c1);
        System.out.println("CA03 y CA04 OK");

        // CA05 y CA06
        int[][] casosBorde = {
                {},
                {5},
                {3, 3, 3},
                {0, 1, 2, 3},
                {3, 2, 1, 0}
        };
        for (int[] caso : casosBorde) {
            int[] a1 = caso.clone();
            int[] a2 = caso.clone();
            v1.ordenar(a1);
            v2.ordenar(a2);
            validador.validarInt(caso, a1);
            validador.validarInt(caso, a2);
        }
        System.out.println("CA05 y CA06 OK");

        // CA08 & CA09
        int[] muestraTest = {4, 1, 3, 2};
        Resultado rTest = timer.medir(OrdenamientoQuickSort.NOMBRE, muestraTest.length, () -> v2.ordenar(muestraTest));
        System.out.println("CA08 OK -> " + rTest);

        boolean falloCapturado = false;
        try {
            timer.medir("OperacionConFallo", 4, () -> {
                throw new IllegalStateException("Fallo simulado de prueba CA09");
            });
        } catch (RuntimeException ex) {
            falloCapturado = (ex.getCause() instanceof IllegalStateException);
        }
        if (!falloCapturado) throw new AssertionError("Fallo CA09");
        System.out.println("CA09 OK");
    }
}