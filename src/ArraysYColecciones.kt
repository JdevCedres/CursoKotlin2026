fun main() {

    // Array: la colección más básica
    // Un Array es un bloque de tamaño fijo que guarda varios valores del mismo tipo, uno detrás del otro. Cada valor
    // tiene una posición (índice), empezando en 0.

    val numeros = arrayOf(10, 20, 30, 40)
    val nombres = arrayOf("Ana", "Luis", "Eva")

    println(numeros[0])
    println(nombres[2])
    println(numeros.size)

    // Arrays de tipo específico (más eficientes para tipos primitivos)
    val entero = intArrayOf(1, 2, 3)
    val decimales = doubleArrayOf(1.5, 2.5, 3.5)

    // La gran limitación de un Array: su tamaño es fijo desde que lo creas. No puedes agregarle ni quitarle elementos
    // después--solo puedes cambiar el valor de una posición ya existente

    val numbers = arrayOf(10, 20, 30)
    numbers[1] = 99 // Esto sí se puede: cambiar un valor existente
    println(numbers[1]) // 99
    // numbers.add(4o) // Esto NO existe en Array, daría error de compilación

    // LIST: la colección que vas a usar siempre
    // Un List es como una Array, peor mucho más flexible y con mucha mas funciones útiles ya construidas.

    // Existen dos versiones muy importantes de distinguir:
    // List (con listOf) -> inmutable: una vez creada, no puedes agregar ni quitar elementos
    // MutableList(con mutableListOf) -> mutable: sí puedes agregar, quitar o modificar elementos después de creada

    // Lista inmutable
    val frutas: List<String> = listOf("Manzana", "Pera", "Uva")
    println(frutas[0])  // Manzana
    println(frutas.size)
    // frutas.add("Naranja")  // Error: list no tiene add()

    // Lista mutable
    val compras: MutableList<String> = mutableListOf("Pan", "Leche")
    compras.add("Huevos")  // Agregar un elemento
    compras.removeAt(0)  // Quitar el elemento en la posición 0 (Pan)
    compras[0] = "Leche descremada"  // Modificar un elemento existente
    println(compras)  // [Leche descremada, Huevos]

    // Funciones más usadas de List:

    val nums = listOf(5, 3, 8, 1, 9)

    println(nums.size)  // 5 (cantidad de elementos)
    println(nums.isEmpty())  // false
    println(nums.contains(8))  // true
    println(nums.indexOf(8))  // posición donde está el 8
    println(nums.first())  // 5
    println(nums.last())  // 9
    println(nums.max())  // 9
    println(nums.min())  // 1
    println(nums.sum())  // 26
    println(nums.sorted()) // [1, 3, 5, 8, 9]
    println(nums.reversed())  // [9, 1, 8, 3, 5]

    // SET: cuando no quieres elementos repetidos
    /*
      Un set es una colección que no permite elementos duplicados y, además, normalmente no garantiza un orden
      especifico. Es ideal cuando lo que te importa es "¿ qué elementos únicos tengo?", no el orden ni las repeticiones
     */

    val exampleNumeros = setOf(1, 2, 2, 3, 3, 3, 3, 4)
    println(exampleNumeros) // [1, 2, 3, 4]  (los duplicados se eliminan automáticamente)

    val mutableSet = mutableSetOf("rojo", "verde")
    mutableSet.add("azul")
    mutableSet.add("rojo") // No pasa nada, "rojo" ya estaba - no se duplica
    println(mutableSet) // [rojo, verde, azul]
    println(mutableSet.size) // 3, no 4

    /*
       Caso de uso típico: si tienes una lista de correos electrónicos que se fueron registrando (con posibles repetidos
       por error) y quieres saber cuántas personas distintas se registraron, conviertes esa lista a SET
     */

    val correosRegistrados = listOf("ana@mail.com", "luis@mail.com", "ana@mail.com")
    val correosUnicos = correosRegistrados.toSet()
    println(correosUnicos)


}