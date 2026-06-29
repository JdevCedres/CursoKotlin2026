fun main() {
    /**
     * Una lambda es, literalmente, una función sin nombre que puedes guardar en una variable, pasar como argumento a
     * otra función, o devolver desde una función. Hasta ahora, toda función que escribiste tenía un nombre
     * (fun saludar(){}). Una lambda es ese mismo concepto, pero más ligero y sin necesidad de declararla a aparte con fun
     */

    // Sintaxis básicas de una lambda

    val saludar = { println("Hola!")}
    saludar() // Hola!

    val sumar = {a: Int, b: Int -> a + b}
    println(sumar(3, 4)) // 7

    /**
     * Piezas clave:
     *   Todo bloque va entre { } (no parentis)
     *   Si la lambda recibe parámetros, se escribe al principio, seguidos de una flecha ->, y después el código
     *   El resultado de la última línea dentro de la lambda es, automáticamente, lo que "devuelve"(no necesias escribir
     *   un return)
     */

    // Comparación lado a lado con una función normal:

    // Función normal (con nombre)
    fun sumar2(a: Int, b: Int): Int {
        return a + b
    }
    // Lambda (sin nombre, guardada en una variable)

    val sumar3 = {a: Int, b: Int -> a + b}

    println(sumar2(3, 4)) // 7
    println(sumar3(3, 4))  //-- mismo resultado, dos formas distintas de escribirlo

    /**
     * FUNCIONES DE ORDEN SUPERIOR: funciones que reciben (o devuelven) otras funciones
     * Es simplemente una función qu recibe otra función como parámetros, o que devuelva una función como resultado.
     * Esto es posible porque, en kotlin, las funciones son "ciudadanos de primera clase"--se puede tratar como cualquier
     * otro dato(igual que pasas Int o un String)
     */
    fun operar(a: Int, b: Int, operacion:(Int, Int) -> Int): Int {
        return operacion(a, b)
    }
    val suma = {x: Int, y: Int -> x + y}
    val resta = {x: Int, y: Int -> x - y}

    println(operar(10, 4, suma))
    println(operar(10, 4, resta))

    /**
     * Fíjate en el tipo de parámetro "operacion: (Int, Int) -> Int". Esto significa:"recibo algo que es una función, que
     * toma dos Int y devuelve un Int". Es exactamente el mismo "molde" que tiene tus lambdas "suma" y "resta", por eso encajan
     * perfecto cuando las pasas por defecto
     */

    /**
     * Lambdas que ya usamos sin saberlo: funciones de colección
     *
     * En el tema 5 calculamos sumas y máximos con un for. Muchas funciones de List en realidad son funciones de orden
     * superior, que reciben una lambda para decirles "qué hacer con cada elemento".
     */

    val numeros = listOf(1, 2, 3, 4, 5, 6)

    // filter: se queda solo con los elementos que cumplen la condición

    val pares = numeros.filter { n -> n % 2 == 0 }
    println(pares) // [2, 4, 6]

    // map: transforma cada elemento en otra cosa
    val alCuadrado = numeros.map { n -> n * n }
    println(alCuadrado) // [1, 4, 9, 16, 25, 36]

    // forEach: ejecuta una acción por cada elemento (como un for, pero como lambda)

    numeros.forEach { n -> println("Número: $n") }

    /**
     * Recuerda el Ejercicio 6 del Tema 4 (numerosMayores), donde filtrabas una lista a mano con un for y un if.
     * Eso es exactamente lo que hace .filter {} en una sola línea
     */

    // La versión manual del Tema 4

    fun numerosMayoresA(numeros: List<Int>, limite: Int): List<Int>{
        val resultado = mutableListOf<Int>()
        for (n in numeros){
            if (n > limite){
                resultado.add(n)
            }
        }
        return resultado
    }

    // Con filter, el mismo resultado:

    fun numerosMayoresB(numero: List<Int>, limite: Int): List<Int>{
        return numeros.filter { n -> n > limite }
    }

    /**
     * It: el parámetro implícito
     *
     * Cuando una lambda recibe un solo parámetro, kotlin te deja omitir su nombre y la flecha por completo--puedes
     * referirte a ese parámetro co la palabra especial it.
     */

    val numbers = listOf(1, 2, 3, 4, 5, 6)

    // Forma explícita (con nombre de parámetro)
    val peers = numbers.filter { n -> n % 2 == 0 }

    // Forma con it (más corta muy común en Kotlin)
    val peers2 = numbers.filter { it % 2 == 0 }

    println(peers)
    println(peers2)

    /**
     * Sintaxis al final: lambda como último parámetro
     *
     * Cuando el último (o único) parámetro de una función es una lambda, Kotlin te permite escribirla fuera de los
     * paréntesis--esto es lo que ya viste con filter {}, sin paréntisis vacíos delante.
     */

    val numeros2 = listOf(1, 2, 3, 4, 5, 6)

    // Forma completa (con paréntesis)
    val pares3 = numeros2.filter { it % 2 == 0 }

    // Forma idiomática de Kotlin (paréntesis omitidos cuando la lambda es el único argumento)
    val pares4 = numeros2.filter { it % 2 == 0 }

    // Por eso, en tu función personalizada operar(10, 4, suma) de antes, también podrías escribirla así si la lambda
    // fuera directamente al llamarla:
    println(operar(10, 4) {x, y -> x + y})
    // La lambda {x, y -> x + y} queda fuera de los paréntesis, porque es el último parámetro


    /**
     *  Prácticas
     */

    // Ejercicio 1:

    val multiplicar = {x: Int, y: Int -> x * y}
    println("Ejercicio 1")
    println(multiplicar(2, 4))
    println(multiplicar(2, 5))
    println( multiplicar(8, 5))

    // Ejercicio 2:
    println("Ejercicio 2")
    fun aplicarOperacion(a: Int, b: Int, ejecutar:(Int, Int) -> Int): Int{
        return ejecutar(a, b)
    }
    val sumas = {x: Int, y: Int -> x + y}
    val restas = {x: Int, y: Int -> x - y}
    val multiplicacion = {x: Int, y: Int -> x * y}
    println(aplicarOperacion(19, 20, sumas))          // 39
    println(aplicarOperacion(19, 20, restas))         // -1
    println(aplicarOperacion(19, 20, multiplicacion)) // 380
}


