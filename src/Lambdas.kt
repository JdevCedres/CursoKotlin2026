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


}