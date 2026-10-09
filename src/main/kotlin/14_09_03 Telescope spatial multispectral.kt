data class Observation(
    val objet: String,
    val temperatureK: Int,
    val typeSpectral: String,
    val estValide: Boolean
)

fun main () {
    val fluxDonnees = listOf(
        Observation("Etoile-A", 5500, "G", true),
        Observation("Etoile-B", 3000, "M", false), // Donnée invalide
        Observation("Etoile-C", 12000, "B", true),
        Observation("Etoile-D", 4500, "K", true),
        Observation("Etoile-E", 25000, "O", true)
    )
    val ciblesPrioritaires = fluxDonnees.filter {
        it.estValide && it.temperatureK > 5000
        // OU : obs -> obs.estValide && obs.temperatureK > 5000
    }
    ciblesPrioritaires.forEach { obs ->
        if (obs.temperatureK > 10000) {
            println("Priorité Haute : ${obs.objet} (${obs.typeSpectral}) détectée.")
        } else {
            println("Analyse standard : ${obs.objet} (${obs.typeSpectral}) en cours.")
        }
    }
}
