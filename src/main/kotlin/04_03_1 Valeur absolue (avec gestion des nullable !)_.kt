/* 4.3.1 Valeur absolue (avec gestion des nullable !).
Type retourné par readlnOrNull : String? (nullable)
*/

fun main() {
    print("Nombre ? ")
    val nombre = readlnOrNull()?.toIntOrNull() // Ici, le type de nombre est Int?
    if (nombre != null) {
        // À l'intérieur, Kotlin sait que 'nombre' n'est plus null.
        // Il "Smart Caste" nombre en Int. Sinon erreur à la compilation, ‘sur’ l'opérateur <
        println(if (nombre < 0) -nombre else nombre)
    } else {
        println("Ce n'est pas un nombre valide.")
    }
}

/* On peut écrire aussi, de manière nettement moins sécurisée (pour information) :
fun main() {
    print("Nombre ? ")
    val nombre = readlnOrNull()!!.toInt()
    // Si readlnOrNull() retourne null ou pas un nombre, crash !
    println(if (nombre < 0) -nombre else nombre)
}

Avec les « !! » on promet que le retour du readlnOrNull() sera non null. Par ailleurs toInt() ne sait pas gérer une chaine qui ne représente pas un nombre ou qui est vide.
*/