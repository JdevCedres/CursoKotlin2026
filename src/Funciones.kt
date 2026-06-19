fun main() {
    //Funciones practicas
    println(isPar(3))
    saludar("Jose" , "fr" )
    println(sumar(1.2, 2.8))
    println(resta(6.2, 2.8))
    println(multi(6.2, 2.0))
    println(div(6.2, 2.0))
    println(div(6.2, 0.0))


}

// Ejercicio 1
fun isPar(numero:Int): Boolean{
    return numero % 2 == 0
    }

// Ejercicio 2

fun saludar(name: String, idioma: String = "es"){
    val saludo = when(idioma){

        "en" -> "Hello"
        "fr" -> "Bonjour"
        else -> "Hola"
    }
    println(" $saludo, $name")
}
// Ejercicio 2

fun sumar(num1: Double, num2: Double) = num1 + num2
fun resta(num1: Double, num2: Double) = num1 - num2
fun multi(num1: Double, num2: Double) = num1 * num2
fun div(num1: Double, num2: Double): Double {
     if (num2 == 0.0) {
         println("No se puede dividir entre 0")
         return 0.0
     }
    return num1 / num2
}
