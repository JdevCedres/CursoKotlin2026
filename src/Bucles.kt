fun main() {
    /**
     *  Bucles
     *  Un bucle le permite a tu programa repetir un bloque de codigo varias veces.
     *  bucles FOR, WHILE, DO-WHILE
     */

    // BUCLE FOR: Cuando sabes cuantas veces repetir (o sobre que recorrer)
    // En Kotlin, for esta pensado para recorrer algo iterable: un rango de numeros, arrays, una lista, los caracteres
    // de un texto.

    // Recorrer un rango de numeros (de 1 al 5, incluyendo 5)
    for (i in 1..5){
        println(i)
    }
    println("-------------------------------------------")
    // Variante de del rango

    // Excluyendo el ultimo numero (de 1 al 4, sin incluir el 5)
    for (i in 1 until 5){
        println(i)
    }
    println("-------------------------------------------")
    // Hacia atras
    for (i in 5 downTo 1){
        println(i)
    }
    println("-------------------------------------------")

    // Saltando de a varios (step)
    for (i in 1..10 step 2){
        println(i)
    }
    println("-------------------------------------------")

    // Recorriendo un array o una lista directamente:
    val numeros = intArrayOf(10, 20, 30)
    for (n in numeros){
        println(n)
    }

    println("-------------------------------------------")
    // Si necesitas  tambien el indice de cada elemento:
    val frutas = arrayOf("Manzanas", "Peras", "Uva")
    for (indice in frutas.indices){
        println("$indice: ${frutas[indice]}")
    }
    println("-------------------------------------------")
    // Formas mas idiomatica de kotlin (indice y valor a la vez)
    for ((indice, fruta) in frutas.withIndex()){
        println("$indice: $fruta")
    }

    /**
     *  BUCLE WHILE: mientras se cumpla una condicion
     *  "while" repite un bloque de codigo MIENTRAS una condicion siga siendo verdadera. Lo usas cuando no sabes de
     *  antemano cuantas vueltas vas a necesitar - depende de algo que va cambiando durante la ejecucion.
      */

    println("BUCLE WHILE: mientras se cumpla una condicion")
    var contador = 1
    while (contador <= 5){
        println(contador)
        contador++
    }


}