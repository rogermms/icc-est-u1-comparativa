import experimentos.EjecutorExperimentos;
import java.util.List;
import modelos.Resultado;

public class App {
    public static void main(String[] args) {
        EjecutorExperimentos ejecutor = new EjecutorExperimentos();
        List<Resultado> resultados = ejecutor.ejecutarBenchmarkCompleto();

        System.out.println("==========================================================================");
        System.out.println("LISTA COMPLETA DE RESULTADOS (" + resultados.size() + " mediciones)");
        System.out.println("==========================================================================");
        for (Resultado r : resultados) {
            System.out.println(r);
        }
        System.out.println("==========================================================================");
    }
}

