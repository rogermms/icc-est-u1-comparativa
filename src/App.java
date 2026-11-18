import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Generador g = new Generador();
        Benchmark b = new Benchmark();

        List<Integer> list = g.generate(100000);
        System.out.println(list);

        Results benGenList = b.medir(() -> g.generate(100000), "Generacion");
        // Un runnable siempre va con el ejecutar q es () y el lambda
        // el generate es un metodo y mientras lo sea puede entrar en el runnable
        System.out.println(benGenList);






        /* 
        ______________________NOTAS DE INTRODUCCION_______________________________
        //nanoTime : Es un cronometro de alta resolucion en nanosegundos.
        long nanoTime = System.nanoTime();
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println(" Tiempo actual en nanoseconds: " + nanoTime);
        System.out.println(" Tiempo actual en milliseconds: " + currentTimeMillis);

        // funcion de ejecucion que ejecuta la funcion lambda
        Runnable funcion = () -> System.out.println("Ejecutando la Tarea ");
        System.out.println("Ejecucion de la funcion runnable"); 
        funcion.run();
        */
        // funcion de ejecucion que ejecuta la funcion lambda con metodo burbuja
        /* 
        List<Integer> list = new ArrayList<>();
        MetodosOrd m0 = new MetodosOrd();
        m0.burbuja(list);
        Runnable funcion2 = () -> m0.burbuja(list); 
        //Runnable  
        System.out.println("Ejecucion de la funcion runnable con metodo burbuja");
        funcion2.run();
        */
        // funcion de ejecucion que ejecuta la funcion lambda con metodo insercion
        
    }
}
