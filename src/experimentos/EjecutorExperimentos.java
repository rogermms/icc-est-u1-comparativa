package experimentos;

import algoritmos.OrdenamientoBiblioteca;
import algoritmos.OrdenamientoInsercion;
import algoritmos.OrdenamientoQuickSort;
import benchmark.BenchMarkTempo;
import generador.GeneradorMuestras;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import modelos.Resultado;

public class EjecutorExperimentos {

    public static final int[] TAMANOS_OBLIGATORIOS = {10_000, 50_000, 100_000};

    private final GeneradorMuestras generador;
    private final BenchMarkTempo timer;
    private final ValidadorOrden validador;
    private final OrdenamientoInsercion insercion;
    private final OrdenamientoQuickSort quickSort;
    private final OrdenamientoBiblioteca biblioteca;

    public EjecutorExperimentos() {
        this.generador = new GeneradorMuestras();
        this.timer = new BenchMarkTempo();
        this.validador = new ValidadorOrden();
        this.insercion = new OrdenamientoInsercion();
        this.quickSort = new OrdenamientoQuickSort();
        this.biblioteca = new OrdenamientoBiblioteca();
    }

    public List<Resultado> ejecutarBenchmarkCompleto() {
        List<Resultado> resultados = new ArrayList<>();

        for (int n : TAMANOS_OBLIGATORIOS) {
            // 1. Generar una única muestra base por tamaño (fuera del cronómetro)
            int[] muestraBase = generador.generarMuestra(n);
            int[] muestraBaseIntacta = generador.clonarArreglo(muestraBase);

            // V1: Inserción
            int[] copiaV1 = generador.clonarArreglo(muestraBaseIntacta);
            Resultado resV1 = timer.medir(OrdenamientoInsercion.NOMBRE, n, () -> insercion.ordenar(copiaV1));
            validador.validarInt(muestraBaseIntacta, copiaV1);
            resultados.add(resV1);

            // V2: Quick Sort
            int[] copiaV2 = generador.clonarArreglo(muestraBaseIntacta);
            Resultado resV2 = timer.medir(OrdenamientoQuickSort.NOMBRE, n, () -> quickSort.ordenar(copiaV2));
            validador.validarInt(muestraBaseIntacta, copiaV2);
            resultados.add(resV2);

            // V3: Arrays.sort int[]
            int[] copiaV3 = generador.clonarArreglo(muestraBaseIntacta);
            Resultado resV3 = timer.medir(OrdenamientoBiblioteca.NOMBRE_V3, n, () -> biblioteca.ordenarPrimitivo(copiaV3));
            validador.validarInt(muestraBaseIntacta, copiaV3);
            resultados.add(resV3);

            // V4: Arrays.sort Integer[] + Comparator seguro (preparación fuera del cronómetro)
            Integer[] copiaV4 = generador.convertirAIntegerClon(muestraBaseIntacta);
            Comparator<Integer> comparador = OrdenamientoBiblioteca.COMPARADOR_ASCENDENTE_SEGURO;
            Resultado resV4 = timer.medir(
                    OrdenamientoBiblioteca.NOMBRE_V4,
                    n,
                    () -> biblioteca.ordenarConComparador(copiaV4, comparador)
            );
            validador.validarInteger(muestraBaseIntacta, copiaV4);
            resultados.add(resV4);
        }

        return resultados;
    }
}