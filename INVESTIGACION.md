# Investigación del Algoritmo Implementado: Quick Sort 
Nombre: Roger Joel Macas Mendoza

## 1. Identificación del algoritmo, variante, clases, métodos y rutas del código fuente
* **Algoritmo elegido:** Quick Sort[cite: 4, 12].

* **Variante implementada:** [Indicar aquí la variante concreta que implementaremos en código, por ejemplo: partición de Lomuto / partición de Hoare con pivote central o pivote al final][cite: 12].
* **Clases y métodos involucrados:**
  * Clase principal del algoritmo: `[NombreClaseQuickSort]` (por ejemplo, `src/algoritmos/QuickSort.java`)[cite: 12].
  * Método público invocado desde la lambda: `[ordenar(int[] arreglo)]`[cite: 5, 12].
  * Métodos auxiliares internos (recursión y partición): `[quickSort(...), particionar(...), intercambiar(...)]`[cite: 12].
* **Rutas en el repositorio:**
  * Código fuente: `[src/algoritmos/QuickSort.java]`[cite: 12].
  * Coordinador/experimentos donde se invoca V2: `[src/experimentos/...]`[cite: 5, 12].

## 2. Proceso paso a paso, parámetros, caso base, progreso de recursión y propiedad conservada
* **Parámetros:** Recibe el arreglo `int[]` y los índices de rango (`bajo` / `inicio` y `alto` / `fin`)[cite: 12].
* **Caso base:** Cuando el subarreglo tiene 0 o 1 elemento (`bajo >= alto` o `inicio >= fin`), se detiene la recursión porque un arreglo vacío o unitario ya está ordenado[cite: 12].
* **Progreso de la recursión:** En cada llamada recursiva se particiona el rango actual alrededor de un pivote y se reduce el tamaño de los subproblemas (llamadas sobre `[bajo .. indicePivote - 1]` y `[indicePivote + 1 .. alto]`, o según el esquema de partición elegido), avanzando estrictamente hacia el caso base[cite: 12].
* **Propiedad que se conserva (invariante / orden y elementos):**
  * Se conservan todos los elementos del arreglo original y sus repeticiones (no se pierden ni se duplican valores)[cite: 1, 12].
  * [Completar aquí la invariante exacta según tu partición: por ejemplo, tras particionar, los elementos a un lado respetan la relación respecto al pivote y el pivote queda en su posición definitiva en el arreglo ordenado][cite: 12].

## 3. Selección del pivote, partición, límites de las llamadas y tratamiento de repetidos
* **Selección del pivote:** [Explicar cómo se elige el pivote en tu implementación concreta][cite: 12].
* **Partición:** [Explicar cómo reordena los elementos en torno al pivote][cite: 12].
* **Límites de las llamadas recursivas:** [Explicar los índices exactos pasados a cada llamada recursiva para evitar bucles infinitos o accesos fuera de rango][cite: 12].
* **Tratamiento de elementos repetidos:** [Explicar cómo se comportan valores iguales al pivote o repetidos en general durante la partición y los intercambios][cite: 12].

## 4. Traza manual sobre `[7, 2, 7, 0, 4, 2]`
* **Arreglo inicial:** `[7, 2, 7, 0, 4, 2]` (6 elementos)[cite: 12, 15].
* **Salida esperada:** `[0, 2, 2, 4, 7, 7]`[cite: 15].
* **Subdivisiones / particiones, resultados intermedios y salida final:**
  * *Paso 1:* [Registrar partición/subarreglo, pivote, intercambios y estado del arreglo][cite: 12].
  * *Paso 2:* [Registrar partición/subarreglo, pivote, intercambios y estado del arreglo][cite: 12].
  * *Paso ...:* [Registrar partición/subarreglo, pivote, intercambios y estado del arreglo][cite: 12].
  * **Salida final verificada:** `[0, 2, 2, 4, 7, 7]`[cite: 12, 15].

## 5. Complejidad temporal, memoria auxiliar, pila recursiva y estabilidad
* **Complejidad temporal:**
  * **Mejor caso:** $O(n \log n)$ — [justificar cuándo ocurre en tu implementación][cite: 12].
  * **Caso promedio:** $O(n \log n)$ — [explicitar supuestos del promedio, como entradas aleatorias uniformes/independientes][cite: 12].
  * **Peor caso:** $O(n^2)$ — [justificar cuándo ocurre, por ejemplo, particiones muy desbalanceadas según pivote y entrada][cite: 12].
* **Memoria auxiliar y pila recursiva:**
  * El ordenamiento in-place usa $O(1)$ de arreglo auxiliar adicional para los datos[cite: 12].
  * La **pila de recursión** consume $O(\log n)$ de espacio en casos balanceados, pero puede llegar a $O(n)$ en el peor caso de desbalance (o $O(\log n)$ si se recurre primero al subarreglo más pequeño)[cite: 12].
* **Estabilidad:** [Indicar si la implementación entregada es **inestable** o **estable** y justificarlo con base en los intercambios realizados sobre elementos con igual valor][cite: 12].

## 6. Caso desfavorable y prueba real
* **Escenario desfavorable:** [Describir la entrada o condición que degrada el rendimiento o estresa la recursión de tu versión][cite: 12].
* **Prueba real ejecutada:** [Describir el tamaño/entrada probada y el resultado obtenido][cite: 12].
* **Fallo observado (si ocurrió por profundidad recursiva o índices) y corrección aplicada:** [Registrar qué ocurrió, cómo se diagnosticó y qué cambio en el código lo corrigió; si no hubo fallo en esa prueba, indicarlo explícitamente][cite: 12].

## 7. Relación con resultados experimentales y fuentes técnicas
* **Observaciones en la tabla de benchmarking (al menos 2):**
  1. [Observación 1 comparando Quick Sort (V2) frente a Inserción (V1) o `Arrays.sort` (V3/V4) en tamaños `10 000`, `50 000` o `100 000` con datos reales][cite: 7, 12, 23].
  2. [Observación 2 vinculando el comportamiento medido con el crecimiento del tamaño de muestra, memoria/pila o sobrecarga de variantes][cite: 7, 12, 23].
* **Fuentes técnicas consultadas (al menos 2, con datos/enlaces y fecha de consulta):**
  1. [Título / Autor / Libro o documentación oficial] — [URL o referencia bibliográfica] — Consultado el: `[YYYY-MM-DD]`[cite: 12].
  2. [Título / Autor / Libro o documentación oficial] — [URL o referencia bibliográfica] — Consultado el: `[YYYY-MM-DD]`[cite: 12].
* **Adaptación y modificaciones realizadas:** [Explicar qué partes provienen de las fuentes consultadas, qué adaptaste a Java/`int[]` y qué modificaciones propias hiciste][cite: 12, 19].