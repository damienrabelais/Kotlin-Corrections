data class Exoplanete(val nom: String, val distanceAl: Int, val estHabitable: Boolean)

fun main() {
    val catalogue = listOf(
        Exoplanete("Proxima Centauri b", 4, true),
        Exoplanete("Kepler-452b", 1400, true),
        Exoplanete("WASP-17b", 1300, false),
        Exoplanete("TRAPPIST-1e", 39, true),
        Exoplanete("HD 189733b", 64, false)
    )

    // Pipeline : Filtrer -> Trier -> Transformer en texte -> Assembler
    val rapportHabitables = catalogue
        .filter { it.estHabitable }
        .sortedBy { it.distanceAl }
        .map { "${it.nom} (${it.distanceAl} AL)" }
        .joinToString(separator = " / ")

    println("Catalogue des mondes habitables : $rapportHabitables")
    // Résultat : "Proxima Centauri b (4 AL) / TRAPPIST-1e (39 AL) / Kepler-452b (1400 AL)"
}
