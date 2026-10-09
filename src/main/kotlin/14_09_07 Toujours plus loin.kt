data class CorpsCeleste(val nom: String, val distanceUA: Double)

const val UA_EN_MILLIONS_KM = 149.6

fun main () {
    val catalogueSpatial = listOf(
        CorpsCeleste("Mercure", 0.39),
        CorpsCeleste("Venus", 0.72),
        CorpsCeleste("Terre", 1.0),
        CorpsCeleste("Mars", 1.52),
        CorpsCeleste("Jupiter", 5.2),
        CorpsCeleste("Saturne", 9.5),
        CorpsCeleste("Uranus", 19.2),
        CorpsCeleste("Neptune", 30.1),
        CorpsCeleste("Pluton", 39.5),
        CorpsCeleste("Eris", 67.7),
        CorpsCeleste("Sedna", 480.0)
    )

    // 1. Filtrer (retour : nouvelle List<CorpsCeleste>)
    val transNeptuniens = catalogueSpatial.filter { it.distanceUA > 30.0 }
        .map { // 2. Mapper (retour : List<String>)
        val km = (it.distanceUA * UA_EN_MILLIONS_KM).toInt()
        "Objet lointain : ${it.nom} à ${km} millions de km."
        // Dernière ligne du bloc = valeur retournée par la lambda
        }.forEach { println(it) } // 3. Consommer (on affiche)

    /* AUTRE ECRITURE POSSIBLE :
        // 1. Filtrer (retour : nouvelle List<CorpsCeleste>)
        val transNeptuniens = catalogueSpatial.filter { it.distanceUA > 30.0 }
        // 2. Mapper (retour : List<String>)
        val rapports = transNeptuniens.map {
            val km = (it.distanceUA * UA_EN_MILLIONS_KM).toInt()
            "Objet lointain : ${it.nom} à ${km} millions de km."
            // Dernière ligne du bloc = valeur retournée par la lambda
        }
        // 3. Consommer (on affiche)
        rapports.forEach { println(it) }
     */
}
