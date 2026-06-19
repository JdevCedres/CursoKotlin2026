fun main() {
    /*
        Condicionales
        Un condicional le permite a tu programa toma de decisiones
     */

    // 1. If/else: La base de todo

    val edad = 20
    if (edad >= 18){
        println("Eres mayor edad")
    } else {
        println("Eres menor de edad")
    }
    // Encadenando varias condicionales con else if:
    val nota = 75
    if (nota >= 90) {
        println("Sobresaliente")
    } else if (nota >= 70){
        println("Aprobado")
    } else if (nota >= 50){
        println("Necesitas mejorar")
    } else {
        println("Suspendido")
    }
    // Kotlin evalúa de arriba a abajo y se detiene en la primera condición que sea verdadera. El orden importa: si
    // Pusieras el nota >= 50 primero primero, nunca llegarías a comprobar si es sobresaliente.

    // 2.  IF como expresión (devuelve un valor)
    // If puede devolver un valor directamente sin necesidad de un return explicito dentro de cada rama

    val age = 20
    val mensaje = if (edad >= 18) "Mayor de edad " else "Menor de edad"

    // Aplicado en una función
    fun maximo(a: Int, b: Int): Int {
        return if (a>b) a else b
    }

    // 3. WHEN: La alternativa más legible a muchos else if

    // When compara un valor contra varias opciones, es mucho más legible que encadenar else if seguidos

    val dia = 3
    when (dia){
        1 -> println("Lunes")
        2 -> println("Martes")
        3 -> println("Miercoles")
        4 -> println("Jueves")
        5 -> println("Viernes")
        6,7 -> println("Lunes")
        else -> println("Día invalido")

    }

    // When sin argumentos( cada rama con su condición boobleana)

    val note = 75

    when {
        note >= 90 -> println("SOBRESALIENTE")
        note >= 70 -> println("APROBADO")
        note >= 90 -> println("SUFICIENTE")
        else -> println("Suspendido")
    }

    // When con rangos

    val ageBoy = 15
    when (ageBoy){
        in 0..12 -> println("Eres niñato")
        in 13..17 -> println("Eres muy niñato")
        in 18..64 -> println("Eres adulto")
        else -> println("Eres pureta")
    }

    // when como expresión (devuelve valor, igual que vimos con if

    val categoria = when (ageBoy){
        in 0..12 -> "Eres niñato"
        in 13..17 -> "Eres muy niñato"
        else -> "Eres adulto"
    }
    println(categoria)

    // Operadores Lógicos: combinando condiciones

    /**
     *  Muchas veces una sola comparación no es suficiente. Para combinar condiciones usamos:
     *  &&(Y) -> ambas condiciones deben ser verdaderas
     *  ||(O) -> al menos una debe ser verdadera
     *  !(NO) -> invierte el valor booleano lo que true pasa false
     */

    val miEdad = 25
    val tieneCarnet = false
    if (miEdad >= 18 && tieneCarnet){
        println("Puede conducir")
    } else {
        println("No puede conducir")
    }
    val esFinDeSemana = false
    val esFiesta = true

    if (esFinDeSemana || esFiesta){
        println("Hoy no se trabaja")
    }
    if (!tieneCarnet){
        println("Necesita sacar el carnet")
    }

    // Condicionales anidados
    // Puedes poner un condicional dentro del otro. Es útil, pero cuidado: si anidas demasiados niveles, el código se vuelve
    // difícil de leer. Cuando eso eso pase, casi siempre es mejor combinar las condiciones con && || en de anidar

    val edadEntrada = 19
    val tieneEntrada = false

    if (edadEntrada >= 18){
        if (tieneEntrada){
            println("Entra al concierto")
        } else {
            println("Necesita comprar la entrada")
        }
    } else {
        println("No tienes la edad mínima")
    }

    /**
     *  PRACTICAS
     */

    // Ejercicio 1. -- Par Impar
    esPar(2)
    esPar(3)

}

fun esPar(numero: Int): Boolean{
    if (numero % 2 == 0){
        return true
    } else {
        return false
    }
}