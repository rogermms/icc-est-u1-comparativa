/*
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

        //LOS 3 ARREGLOS BASE
        //10000
        List<Integer> list1 = g.generate(10000);
        //50000
        List<Integer> list2 = g.generate(10000);
        //100000
        List<Integer> list3 = g.generate(10000);

        //1 = List <List>Integer>> listas = List.of(list1,list2,list3);
        //2 = List<-Integer>[] listas = new List<Integer>[](list1);
        
        Results resultaM1S1 = Benchmark.medir(()-> m.sortBubble(list))






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