fun main() {
    /**
     * NULL SAFETY
     */


    /**
     * null representa la ausencia de un valor. Para prevenir este error en tiempo de compilación: el propio lenguaje
     *      te obliga a declarar explícitamente si una variable puede ser null o no, y te impide usarla de forma insegura sin
     *      que tú lo permitas a propósito. Por defecto ninguna variable puede ser null, a menos que tu indiques explícitamente
     *      con un signo de interrogación "?" después del tipo.
     */

    var name: String = "Ana"
   // name = null -> Error de compilación: String no puede ser null
    var surname: String? = "García" // El ? permite que pueda ser null
    surname = null  // Esto SÍ está permitido

    /**
     * Esto significa que si una función recibe un parámetro de tipo String (?), tienes la garantía absoluta de que jamás
     * te va a llegar null ahí-- el compilador no te deja ni intentarlo.
     * Piensa en el "?" como una advertencia visible en el propio tipo:" Esta variable PODRÍA no tener nada adentro, tenlo
     * en cuenta antes de usarla".
     */

    /**
     *  EL OPERADOR ?. (safe): acceder con seguridad
     *
     *  Si tienes una variable que puede ser "NULL", no puedes acceder a sus propiedades o metodos directamente con un
     *  punto normal--Kotlin te obliga a usar "?". en su lugar.
     */

    var apellido: String? = "García"

    // println(apellido.length) -> ERROR: no puedes usar . directamente en que puede ser null
    println(apellido?.length) // 6 (funciona porque usamos ?)
    apellido = null
    println(apellido?.length) // null (no falla, simplemente devuelve null en vez de explotar)
    // Léelo así: apellido?.length significa "si apellido NO es null, dame su length;si apellido ES null, no intentes nada
    // y dame null directamente". Esto evita por completo el error de intentar leer una propiedad de algo que no existe

    // Combinándolo con safe call(un patrón muy común)
    var apellidos: String? = null
    val longitud = apellidos?.length ?: 0
    println(longitud) // 0 (porque apellidos es null, así que ?. devuelve null, y ?: lo convierte en 0)

    /**
     * El operador !! (not-null assertion):"confío en que esto no es null"
     *
     * !! le dice a Kotlin:"sé que esta variable es de tipo anulable, pero te garantizo que en este punto exacto
     * NO es null--trátala como si no puediera serlo".
     */

    var calle: String? = "Calle Galicia"
    val height = calle!!.length // funciona, porque si tiene un valor
    println(height) // 6
    calle = null
   // val longitud2 = calle!!.length // ¡CRASH! Lanza una excepción en tiempo de ejecución

    /**
     * LET:ejecutar código solo si NO es null
     *
     * let es una función que te permite ejecutar un bloque de código solo si la variable no es null, sin tener que
     * escribir un if explícito. Se combina casi siempre con ?.
     */

    var ciudad: String? = "Arrecife"
    ciudad?.let {
        println("la ciudad tiene ${it.length} letras") // la ciudad tiene 8 letras
    }

    ciudad = null
    ciudad?.let {
        println("Esto núnca se imprime, porque ciudad es null") // No imprime nada
    }

    /**
     * Comprobación explícita con if (más simple de entender al principio)
     *
     * Se puede resolver con if normal--Kotlin es lo bastante inteligente para darse cuenta de que, dentro del bloque
     * la variable ya no puede ser null.
     */

    var isla: String? = "Lanzarote"
    if (isla != null){
        println("La isla tiene ${isla.length} letras")
        // Aquí, DENTRO del if, Kotlin sabe que isla no es null,
        // así que te deja usar isla.length sin ?. y !!
    } else {
        println("No hay apellido")
    }

    // Esto se llama smart cast (conversación inteligente): el compilador "recuerda" que ya comprobaste que no es null y
    // te deja trabajar con normalidad

    /**
     * ¿Cual usar?
     *
     * Usa ?. cuando solo quieras leer algo de forma segura, aceptando que el resultado final también podría sr null.
     * Usa ?: cuando quiera un valor de respaldo concreto en vez de null
     * Usa if(variable != null) cuando necesites ejecutar varias líneas de lógica distinta según el caso
     * Usa let cuado quieras ejecutar un bloque de código solo si hay un valor, de forma más compacta que el if
     * Evita !! casi siempre. Solo úsalo cuando estés 100% seguro(por ejemplo, justo después de validar con if) y no
     * encuentres una alternativa más segura.
     */

    // Practicas

    // Ejercicio 1 -- Tu primer tipo anulable

    var provincia: String? = null
    println(provincia?.length)
    provincia = "Las palmas"
    println(provincia.length)

    // Ejercicio 2 -- Elvis en acción

    println(obtenerNombreUsuario("Manuel"))  // Manuel  (texto no es null, lo devuelve tal cual)
    println(obtenerNombreUsuario(null))      // inválido  (texto es null, usa el valor de respaldo)

    // Ejercicio 3 -- Combinando ?. y ?:
    println(longitudSegura("josedamaso"))
    println(longitudSegura(null))

    // Ejercicio 4 -- Validar con If
    describirEdad(9)
    describirEdad(null)

    // Ejercicio 5 -- let para ejecutar bloques
    crearCorreos("manuel@chacho.com")
    crearCorreos(null)

    // Ejercicio 6 -- Lista de productos con precios anulables

    val producto1 = Product("Gomas", null)
    val producto2 = Product("cable", 4.25)
    val producto3 = Product("alicates", null)
    val producto4 = Product("navaja", 12.25)

    val products: List<Product> = listOf(producto1, producto2, producto3, producto4)
    for (product in products){
        if (product.precio != null){
            println("el Precio del producto: ${product.nombre} es ${product.precio} €")
        } else {
            println("Precio no disponible")
        }
    }

    // Ejercicio 7 -- Buscar en un Map con resultado anulable

    val productos: Map<String, Int> = mapOf(
        "ferrari" to 10,
        "porche" to 9,
        "corsa" to 12
    )
    println(consultarStock("ferrari", productos))
    println(consultarStock("bicicleta", productos))



}

fun obtenerNombreUsuario(texto: String?): String{
    return texto ?: "inválido"
}

// Ejercicio 3 -- Combinando ?. y ?:

fun longitudSegura(texto: String?): Int {
   val longitud: Int = texto?.length ?: 0
    return longitud
}
// Ejercicio 4 -- Validar con If

fun describirEdad(edad: Int?){
    if (edad != null){
        println("Tienes $edad años")
    }else {
        println("Edad desconocida o null")
    }
}

// Ejercicio 5 -- let para ejecutar bloques

fun crearCorreos(correo: String?){
    correo.let {
        println("${correo?.uppercase()}")
    }
}




// Ejercicio 6 -- Lista de productos con precios anulables

data class Product(var nombre: String, var precio: Double?)

// Ejercicio 7 -- Buscar en un Map con resultado anulable

fun consultarStock(producto: String, inventario: Map<String, Int>):String {
    val stock = inventario[producto] ?: return "Producto no registrado"
    return "$producto quedan $stock"
}