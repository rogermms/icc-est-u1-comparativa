package noaplicables;
import java.util.ArrayList;
import java.util.List;

public class Generador {
    // Es el que da numeros aleatorios para la generacion de la lista
    /*
    genera un lista de tamaño size con numeros aleatorios 
    entre 0 a size.
    */
    public static List<Integer> generate(int size){
        // Integer pq List guarda objetos y no primitivos.
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < size; i++){
            list.add((int)(Math.random() * size));
            /*
            se multiplica por size para que el numero aleatorio este entre 0 y size
            y como el math random da double el se le hace un cast con int para que 
            sea un numero entero y no un decimal.
            */
        }
        return list;



    }
}
