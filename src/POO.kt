import kotlin.math.pow

fun main() {
    /**
     *  PROGRAMACIÓN ORIENTADA A OBJETO.
     */

    /*
        La programación orientad a objetos es una forma de organizar tu código moldeando cosas del mundo real como
        objetos.
        Piensa en una pastilla de nuestra futura app: tiene un nombre, una dosis, una hora de toma (eso son características
        ), y puede marcarse como tomada o reprogramarse(eso son comportamiento). En POO, moldearias esto como una clase
        Pastilla.
     */


    // Clase y Objetos: La diferencia clave
    /*
        Una clase: es el molde o plano - define qué características y comportamientos va a tener algo, pero no ese algo en
        sí.
        Un objeto: (También llamado instancia) es una cosa concreta creada a partir de ese molde.

     */


    // Ejemplo clase Persona:

    // Objeto (instancia)
    val persona1 = Persona("Manuel", 8) // Creamos el objeto (Instancia)
    val persona2 = Persona("Elena", -1) // Creamos otro objeto independiente del primero.

    println("${persona1.nombre} tiene ${persona1.edad} años")
    persona1.saludar()
    persona1.cumplirAnos()
    println("${persona2.nombre} tiene ${persona2.edad} años")
    persona2.saludar()
    persona2.cumplirAnos()
    // Ejemplo con constructor
    // Edad es con var -> se puede reasignar, el nombre es con val -> NO se puede reasignar


    /**
     *  CONSTRUCTORES: Crear objetos con datos desde el inicio
     */

    // En el ejemplo anterior, creamos el objeto vacío y luego le asignamos los valores uno por uno, Es más práctico
    //  (y es lo que vamos a ver el 99% del código real) definir los datos directamente del constructor de la clase


    /**
     * MÉTODOS: comportamiento dentro de una clase
     */

    // Un metodo es simplemente una función definida dentro de una clase. Representa algo que un objeto de esa clase
    // puede hacer


    /**
     *  INIT: código que se ejecuta al crear el objeto
     */

    // Vas a usar init con bastante frecuencia para "validar" datos de entrada, asegurándote de que un objeto nunca
    // exista en un estado inválido (por ejemplo que una pastilla nunca tenga una dosis negativa)


    /**
     *  HERENCIA: reutilizar y especializar clases
     */

    // La herencia te permite crear una clase nueva basada en otra existente, heredando sus propiedades y métodos,
    // y agregando o modificando lo que necesites. La clase original se llama clase padre (o superclase), y la nueva se
    // llama clase hija (o subclase)
    // En Kotlin, las clases son "final" por defecto (no se puede heredar)--necesitas marcar explícitamente la clase
    //padre con la palabra "open" para permitir que otras clases hereden de ella

    val perro = Perro("Rex")
    val gato = Gato("Michi")
    perro.hacerSonido()
    gato.hacerSonido()


    /**
     * DATA CLASS: clases pensadas para guardar datos
     */

    // Cuando una clase existe principalmente para guardar información (sin mucha lógica compleja), Kotlin te ofrece un
    // atajo muy poderoso: data class. Vas a usarla constantemente en Android (por ejemplo, para representar cada pastilla
    // de tu app)

    // data class Pastilla (val nombre: String, val dosis: String, val hora: String)
    // Una "DATA CLASS" te da automáticamente, sin escribir nada extra:
    /**
     * Una representación en texto legible al imprimir el objeto
     * Comparación por contenido con == (en una clase normal, == compararía si son el mismo objeto en memoria no si tiene
     * los mismos datos)
     * Una función "copy()"para crear una copia modificando solo algunos campos.
     */

    val pastilla1 = Pastilla("Paracetamol", "500mg", "08:00")
    val pastilla2 = Pastilla("Paracetamol", "500mg", "08:00")
    println(pastilla1) // Pastilla(nombre=Paracetamol, dosis=500mg, hora="08:00")
    println(pastilla1 == pastilla2) // true: compara el CONTENIDO, no si son el mismo objeto.





    /**
     *  Prácticas
     */

    // Ejercicio 1--Tu primera clase
    val libro1 = Libro("La paciente silenciosa", "Alex Michaelides", 345)
    libro1.mostraInfo()
    val libro2 = Libro("El poder de estar solo", "Brian Alba", 373)
    libro2.mostraInfo()

    // Ejercicio 2-- Metodos que cambian el estado.
    val miCuenta1 = CuentaBancaria(340.0)
    miCuenta1.depositar(120.0)
    val miCuenta2 = CuentaBancaria(1340.0)
    miCuenta2.retirar(2000.0)

    // Ejercicio 3--Validación con init
    val producto1 = Producto("Peras", -22.00)
    val producto2 = Producto("Platanos", 222.00)

    // Ejercicio 4--Herencia básica

    val gerente1 = Gerente("Jose", 10000.00)
    val gerente2 = Gerente("Elena", 20000.00)
    println(gerente1.salarioBase)
    println(gerente2.salarioBase)
    println("Mi nombre es ${gerente1.nombre} y mi salario neto es ${gerente1.salarioBase} más mi bonus es ${gerente1.calcularSalario()}")
    println("Mi nombre es ${gerente2.nombre} y mi salario neto es ${gerente2.salarioBase} más mi bonus es ${gerente2.calcularSalario()}")

    // Ejercicio 5 Polimorfismo con varias clases hijas
    val circulo = Circulo(4.53)
    val rectangulo = Rectangulo(6.70, 4.76)
    println(circulo.area())
    println(rectangulo.area())

    val figuras: List<Figura> = listOf(circulo, rectangulo)

    for (figura in figuras) {
        println("Área: ${figura.area()}")
    }

    // Ejercicio 5--data class básica

    val estudiante1 = Estudiante("Manuel", 9.86)
    val estudiante2 = Estudiante("Elena", 10.00)
    val estudiante3 = Estudiante("Jose", 10.54)
    val estudiante4 = Estudiante("Adrian", 9.99)
    val estudiante5 = Estudiante("Aitana", 9.12)

    val estudiantes: List<Estudiante> = listOf(estudiante1, estudiante2, estudiante3, estudiante4, estudiante5)
    var mejor = estudiantes[0]
    for (estudiante in estudiantes ){
        if (estudiante.nota > mejor.nota) {
            mejor = estudiante
        }
    }
    println(mejor)

    // Ejercicio 8
    // Agregas las figuras a la lista (puedes usar las mismas que ya creaste en el Ejercicio 5)
    addFigure(figurasEjer8, Circulo(4.53))
   addFigure(figurasEjer8, Rectangulo(6.70, 4.76))

    // Imprimes la suma de todas las áreas
    println("Área total: ${totalArea(figurasEjer8)}")
}



// Ejemplo Clase
/*
class Persona {
    var nombre: String = ""
    var edad: Int = 0
}
 */
// Ejemplo con constructor

class Persona(val nombre: String, var edad: Int) {
    // Constructor primario es la forma más común de declarar clases en kotlin

    // Ejemplo init:
    init {
        if (edad < 0) {
            println("Advertencia: la edad no puede ser negativa, se ajusta a 0")
            edad = 0
        }
        println("se creó una persona llamada $nombre")
    }

    // Ejemplo metodos -> saludar y cumplir años:
    fun saludar() {
        println("Hola soy $nombre y tengo $edad años")
    }

    fun cumplirAnos() {
        edad++
        println("$nombre ahora tiene $edad años")
    }
}

// EJEMPLO HERENCIA

// Clase Padre o Superclase
open class Animal(val nombre: String) {
    open fun hacerSonido() {
        println("$nombre hace un sonido")
    }
}

// Clase hija o subclase
class Perro(nombre: String) : Animal(nombre) {
    override fun hacerSonido() {
        println("$nombre dice: Guau!")
    }
}

class Gato(nombre: String) : Animal(nombre) {
    override fun hacerSonido() {
        println("$nombre dice: Miau!")
    }

}

// Rex dice: Guau!
// Michi dice: Miau!

// Ejemplo data class

data class Pastilla(val nombre: String, val dosis: String, val hora: String)


/**
 *  PRÁCTICAS POO
 */

// Ejercicio 1-- Tu primera clase

class Libro(val titulo: String, val autor: String, val paginas: Int) {
    fun mostraInfo() {
        println("El título del libro es: $titulo, su autor $autor y tiene $paginas páginas")
    }
}

// Ejercicio 2-- Metodos que cambian el estado.

class CuentaBancaria(var saldo: Double) {
    fun depositar(monto: Double) {
        saldo += monto
        println("Tú saldo actual es: $saldo ")
    }

    fun retirar(monto: Double) {
        if (monto > saldo) {
            println("Saldo insuficiente, tu saldo actual es $saldo")
        } else {
            saldo -= monto
            println("Tu saldo actual es: $saldo")
        }
    }
}

// Ejercicio 3--Validación con init

class Producto(val nombre: String, var precio: Double){
    init {
        if (precio < 0){
            println("El precio no puede ser menor de cero, se ajusta a 0")
            precio = 0.0
        }
        println("Se creó el producto con nombre: $nombre y precio: $precio")
    }
}

// Ejercicio 4--Herencia Básica
open class Empleado(val nombre: String, val salarioBase: Double){
    open fun calcularSalario() = salarioBase
}

class Gerente(nombre: String,salarioBase: Double): Empleado(nombre, salarioBase){
    override fun calcularSalario(): Double {
        return (salarioBase + 500.00)
    }
}

// Ejercicio 5--Polimorfismo con varias clases hijas
open class Figura(){
    open fun area(): Double{return 0.0}
}

class Circulo(val radio: Double):Figura(){
    override fun area(): Double = Math.PI * radio.pow(2.0)

}

class Rectangulo(val base: Double, val altura: Double):Figura(){
    override fun area() : Double = (base * altura)
}

// Ejercicio 6--data class básicas

data class Estudiante(val nombre: String, val nota: Double)

// Ejercicio 8--Sistema de figuras con Mutable List

val figurasEjer8: MutableList<Figura> = mutableListOf()

fun addFigure(figurasEjer8: MutableList<Figura>, figura: Figura){
    figurasEjer8.add(figura)
}

fun totalArea(figurasEjer8: MutableList<Figura>): Double {
    var total = 0.0
    for (figura in figurasEjer8){
        total += figura.area()
    }
    return total
}