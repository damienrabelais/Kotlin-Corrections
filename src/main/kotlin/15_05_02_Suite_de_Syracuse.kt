fun main() {
    val u0 = 12 // Valeur initiale

    val suiteSyracuse = sequence {
        var un = u0 // On initialise u0

        // On envoie le terme actuel avant de calculer le suivant
        yield(un)

        // On continue tant que la condition d'arrêt n'est pas atteinte
        while (un != 1) {
            un = if (un % 2 == 0) {
                un / 2 // Cas pair
            } else {
                3 * un + 1 // Cas impair
            }
            yield(un) // On réinjecte le résultat calculé dans la séquence
        }
    }

    println("Calcul de la suite de Syracuse pour u0 = $u0 :")
    suiteSyracuse.forEach { print("$it ") }
}
