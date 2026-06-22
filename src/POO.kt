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
    val persona1 = Persona("Manuel",8) // Creamos el objeto (Instancia)
    val persona2 = Persona("Elena",-1) // Creamos otro objeto independiente del primero.

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

}

// Ejemplo Clase
/*
class Persona {
    var nombre: String = ""
    var edad: Int = 0
}
 */
 // Ejemplo con constructor

class Persona(val nombre: String, var edad: Int){
    // Constructor primario es la forma más común de declarar clases en kotlin

    // Ejemplo init:
    init {
        if (edad < 0){
            println("Advertencia: la edad no puede ser negativa, se ajusta a 0")
            edad = 0
        }
        println("se creó una persona llamada $nombre")
    }

    // Ejemplo metodos -> saludar y cumplir años:
    fun saludar(){
        println("Hola soy $nombre y tengo $edad años")
    }
    fun cumplirAnos(){
        edad++
        println("$nombre ahora tiene $edad años")
    }
}

