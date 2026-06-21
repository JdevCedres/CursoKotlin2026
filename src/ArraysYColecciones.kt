import java.lang.classfile.instruction.StackInstruction
import kotlin.math.E

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

    // MAP: pares clave-valor

    /**
     * Un Map guarda información en pares: una clave (key) asociada a un valor (value). En vez de buscar por posición
     * (como una List), busca por claves-es como un diccionario real: buscas una palabra(clave) y obtienes su significado
     * (valor)
     */

    val edades: Map<String, Int> = mapOf(
        "Ana" to 25,
        "Luis" to 30,
        "Eva" to 22
    )
    println(edades["Ana"])  // 25
    println(edades["Luis"]) // 30
    println(edades.size)  // 3
    println(edades.containsKey("Eva"))  // true

    // MAP MUTABLE:

    val inventario: MutableMap<String, Int> = mutableMapOf(
        "Manzana" to 50,
        "Peras" to 30
    )
    inventario["Uvas"] = 20  // Agregar una nueva clave-valor
    inventario["Manzana"] = 45  // Modificar el valor de una clave existente
    inventario.remove("Peras") // Eliminar una clave-valor

    // RECORRER UN MAP CON FOR

    val ages = mapOf("Ana" to 25, "Elena" to 6, "Manuel" to 8)
    for ((name, age) in ages){
        println("$name tiene $age años")
    }

    println("-----------PRACTICAS-------------")

    println("Ejercicio 1.")

    val product: MutableList<String> = mutableListOf("movil", "laptop", "server")
    product.add("monitor")
    product.add("impresora")
    product.remove("movil")
    println("${product.size} , $product " )

    println("Ejercicio 2.")

    val name: List<String> = listOf("Jose", "Manuel", "Elena", "Adrian", "Aitana")
    println(buscarEnLista("Manuel", name))

    println("Ejercicio 3.")
    val number1 = listOf<Int>(1, 2, 3, 3, 4, 5, 6, 6, 7)
    println(contarUnicos(number1))

    println("Ejercicio 4.")
    val capitales: Map<String, String> = mapOf(
        "España" to "Madrid",
        "Peru" to "Lima",
    )
    println(obtenerCapitales("España", capitales))
    println(obtenerCapitales("Francia", capitales))

    println("Ejercicio 5.")
    val inventarios = mutableMapOf(
        "television" to 50,
        "radios" to 30,
        "laptop" to 4,
        "antenas" to 16
    )
    venderProducto("television", 3, inventarios)

    println("Ejercicio 6.")
    val numerosAMano = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8)
    println(filtraAMano(numerosAMano, 3))

    println("Ejercicio 7.")
    val telefono: MutableMap<String, Int> = mutableMapOf(
        "Jose" to 693921827,
        "Manuel" to 676543219,
        "Elena" to 654323456
    )
}

fun buscarEnLista(elemento: String, lista: List<String>): Boolean{
    return  lista.contains(elemento)
}

fun contarUnicos(numeros: List<Int>): Set<Int> {
    return numeros.toSet()
}
fun obtenerCapitales(pais: String, capitales: Map<String, String>): String{
    return capitales.getOrDefault(pais, "capital no encontrada")
}

fun venderProducto(producto: String, cantidad: Int, inventarios : MutableMap<String, Int>){
    val stockActual = inventarios.getOrDefault(producto, 0)
    if (stockActual < cantidad) {
        println("No hay suficiente stock de $producto")
        return  // sales de la función sin hacer la resta
    } else {
        inventarios[producto] = stockActual - cantidad
        println("$producto: quedan ${inventarios[producto]} unidades")
    }
}
fun filtraAMano(lista : MutableList<Int>, limite: Int): MutableList<Int>{
    val numeros3: MutableList<Int> = mutableListOf()
    for (n in lista){
        if (n > limite){
            numeros3.add(n)
        }

    }
    return numeros3
}
fun agenda(name: String, telefono: List<Int>){

}