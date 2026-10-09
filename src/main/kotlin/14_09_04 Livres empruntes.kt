package lambda.rabelais

data class Livre(val titre: String, val estEmprunte: Boolean)

fun main() {
    val bibliotheque = listOf(
        Livre("Le Petit Prince", true),
        Livre("1984", false),
        Livre("La guerre des mouches", true),
        Livre("Fondation", false)
    )
    bibliotheque.filter {it.estEmprunte}
        .sortedBy { it.titre }
        .forEach { println("Le livre '${it.titre}' est emprunté.") }
    //OU : .forEach { livre -> println("Le livre '${livre.titre}' est emprunté.") }
}
