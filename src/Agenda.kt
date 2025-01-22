class Contacto(
    val nombre: String,
    val telefono: String
) {
    override fun toString(): String {
        return "Contacto(nombre='$nombre', telefono='$telefono')"
    }
}

class Agenda(var agendacontactos: ArrayList<Contacto>) {

    fun agregarContacto() {
        if (agendacontactos.size >= 10) {
            println("Ha alcanzado el número máximo de contactos que es 10.")
        } else {
            println("Escribe el Nombre del contacto:")
            val nombre = readln()

            println("Escribe el Teléfono del contacto:")
            val telefono = readln()

            val contacto = Contacto(nombre, telefono)
            agendacontactos.add(contacto)
            println("El contacto se ha añadido")
        }
    }

    fun mostrar() {
        if (agendacontactos.isEmpty()) {
            println("La agenda está vacía.")
        } else {
            println("Contactos en la agenda:")
            for (contacto in agendacontactos) {
                println(contacto)
            }
        }
    }

    fun buscar(nombre: String) {
        val contacto = agendacontactos.find { it.nombre == nombre }

        if (agendacontactos.isEmpty()) {
            println("La agenda está vacía.")
        } else {
            if (contacto != null) {
                for (contacto in agendacontactos) {
                    println(contacto)
                }
                println("Contacto $nombre eliminado.")
            } else {
                println("Contacto no encontrado.")
            }

        }
    }

    fun eliminar(nombre: String) {
        val contacto = agendacontactos.find { it.nombre == nombre }
        if (contacto != null) {
            agendacontactos.remove(contacto)
            println("Contacto $nombre eliminado.")
        } else {
            println("No se ha eliminado el contacto no existe.")
        }
    }

    fun existe(nombre: String) {
        val contacto = agendacontactos.find { it.nombre == nombre }
        if (contacto != null) {

            println("Contacto $nombre Existe.")
        } else {
            println("Contacto no encontrado.")
        }
    }

    fun agendaLlena(): Boolean {
        return agendacontactos.size >= 10
    }

    fun tamanoAgenda():Int{
        var tamano = 10-(agendacontactos.size-1)
        return tamano
    }
}

fun main() {
    val agenda = Agenda(ArrayList())

    var opcion: Int = -1

    while (opcion != 8) {
        println("\n1. Añadir contacto")
        println("2. Listar Contactos")
        println("3. Buscar contacto")
        println("4. Existe contacto")
        println("5. Eliminar contacto")
        println("5. Mostrar contactos disponibles")
        println("6. Ver si la agenda está llena")
        println("7. Agenda llena")
        println("8. Salir")
        println("Escribe una opción:")

        opcion = readln().toInt()

        when (opcion) {
            1 -> agenda.agregarContacto()
            2 -> agenda.mostrar()
            3 -> {
                println("Escribe el nombre del contacto que deseas buscar:")
                val nombre = readln()
                agenda.buscar(nombre)
            }
            4->{
                println("Escribe el nombre del contacto que deseas saber si existe:")
                val nombre = readln()
                agenda.existe(nombre)
            }
            5 -> {
                println("Escribe el nombre del contacto que deseas eliminar:")
                val nombre = readln()
                agenda.eliminar(nombre)
                     }
            6 -> {
                if (agenda.agendaLlena()) {
                    println("La agenda está llena.")
                } else {
                    val  ta:Int = agenda.tamanoAgenda()
                    println("La agenda no está llena, puedes agregar $ta contactos.")
                }
            }
            7 -> if (agenda.agendaLlena()) println("La agenda está llena.") else println("La agenda tiene espacio disponible.")
            8 -> println("Saliendo...")
            else -> println("Opción no válida.")
        }
    }
}
