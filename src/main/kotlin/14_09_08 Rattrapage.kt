fun List<Candidat>.getListCandidatsRepeches(): String = this
    .filter { it.moyenneGenerale < 10 && it.moyenneGenerale > 8 && it.moyennePro > 10 }
    .sortedWith(compareBy({ it.prenom }, { it.nom }))
    .joinToString(separator = "\n") {
        "${it.nom} ${it.prenom}, ${it.moyenneGenerale} - ${it.moyennePro}"
    }

data class Candidat(
    val nom: String,
    val prenom: String,
    val moyenneGenerale: Double,
    val moyennePro: Double
)

fun main() {
    val lesCandidats = listOf(
        Candidat("Dupont", "Pierre", 11.0, 12.0), // OK
        Candidat("Durant", "Jean", 8.5, 11.0), // rattrapage OK
        Candidat("Jaouen", "Yann", 7.0, 8.0), // recalé
        Candidat("Le Flem", "Paul", 7.5, 15.0), // recalé
        Candidat("Ropartz", "Guy", 15.0, 17.0), // OK
        Candidat("Cras", "Jean", 9.0, 14.0), // rattrapage OK
        Candidat("Ravel", "Marcel", 9.5, 10.0), // recalé, moyenne<10
    )

    println("Liste des candidats repêchés :\n${lesCandidats.getListCandidatsRepeches()}")
}
