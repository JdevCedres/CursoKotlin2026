import kotlin.coroutines.coroutineContext

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

    /**
     * BUCLE DO-WHILE: Ejecuta primero, pregunta despues
     * Es casi identico a while, con una diferencia clave:el bloque de codigo se ejecuta al menos una vez, sin importar
     * cla condicion es verdader o falsa, porque la condicion se evalua al final, no al principio
     */

    var intentos = 0
    do {
        println("Intento numero ($intentos + 1)")
        intentos++
    }while (intentos < 3)

    // Se ejecuta 3 veces, igual que con lo while en este caso

    // La diferencia se nota cuando la condicion es falsa desde el principio:
    println("BUCLE DO-WHILE:")
    var numbers= 10

    // Con while: como la condicion ya es falsa, nunca entra al bucle
    while (numbers < 5){
        println("Esto nunca se imprime")
    }

    // Con do-while: se ejecuta una vez, SIEMPRE, sin importar la condicion

    do {
        println("Esto se imprime una vez, aunque numero ya sea 10")
    }while (numbers < 5)


    println("BREAK Y CONTINUE: Controlando el flujo dentro de un bucle")

    // break -> termina el bucle por completo de inmediato, sin importar cuantas vueltas quedaban
    // continue -> salta a la siguiente vuelta, sin ejecutar el resto del codigo  en particular
    println("-------------------------------------------")
    // break: detener apenas encontramos lo que buscamos
    for (i in 1..10){
        if (i == 5){
            break
        }
        println(i) // imprime 1 2 3 4 (Se detiene al llegar el 5)
    }
    println("-------------------------------------------")
    // continue: saltar los numeros pares, sin detener el bucle
    for (i in 1..10){
        if (i % 2 == 0){
            continue
        }
        println(i) // Imprime 1 3 5 7 9 ( se salta los pares, pero sigue hasta el final)
    }

    // BUCLES ANIDADOS: Un bucle dentro de otro
    // Igual que los condicionales, podemos meter un bucle dentro del otro, muy comun al trabajar con tablas, matrices,
    // o combinaciones (por ejemplo, recorrer filas y columnas)

    for (fila in 1..3){
        for (columna in 1..3){
            print("($fila,$columna)")
        }
        println() // Salto de linea al terminar cada fila

    }

    println("----------PRACTICAS----------")

    // Ejercicio 1 --Tabla de multiplicar
    tablaMultiplicar(8)
    // Ejercicio 2 --Tabla de Sumar pares
    sumaPares(2, 8)
    cuentaAtras(5)
    simularValidacion(5, listOf(1005, 303, 12344, 5, 90))
    simularMenu(listOf(1, 2, 3, 4))
    patronAnidados(5)
}


fun tablaMultiplicar(numero: Int){
    for (n in 1..10)
        println("$numero x $n = ${numero * n}")
}

var total = 0
fun sumaPares(num1: Int, num2: Int){
    for (n in num1..num2){
        if (n % 2 == 0){
            total += n
        }else
            continue
    }
    println(total)
}

fun cuentaAtras(num: Int){
    for (i in num downTo 0){
        if (i == 0){
            println("DESPEGUE")
        } else
            println(i)
    }
}

fun simularValidacion(codigoCorrecto: Int, intentos: List<Int>){
    var indice = 0
    var encontrado = false

    while (indice < intentos.size) {
        if (intentos[indice] == codigoCorrecto){
            println("Codigo correcto en el intento numero ${indice + 1}")
            encontrado = true
            break
        }
        indice++
    }
    if (!encontrado){
        println("Codigo incorrecto en todos los intentos")
    }
}

fun simularMenu(opciones: List<Int>){
    var indice = 0
    var opcionSeleccionada: Int
    do {
        opcionSeleccionada = opciones[indice]
        println("Opcion seleccionada: $opcionSeleccionada")
        indice++
    }while (opcionSeleccionada != 0 && indice < opciones.size)
    println("Saliendo del menu")
}

fun patronAnidados(n: Int){
    for (fila in 1..n){
        for (columna in 1..fila){
            print(" * ")
        }
        println()
    }
}