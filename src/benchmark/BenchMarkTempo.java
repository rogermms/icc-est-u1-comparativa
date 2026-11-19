package benchmark;

import modelos.Resultado;

public class BenchMarkTempo {

    public Resultado medir(String nombreMetodo, int sample, Runnable operacion) {
        long inicio = System.nanoTime();
        operacion.run();
        long fin = System.nanoTime();

        long duracionNs = fin - inicio;
        return new Resultado(nombreMetodo, sample, duracionNs);
    }
}

