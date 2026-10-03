// 9.8.2 Astres (classes scellées)
package test

// 1. Classe mère scellée représentant les familles d'astres
sealed class Astre(open val nom:String) {
    /* sous-classe de type data -> pas de simple paramètre, juste des properties
    -> obligation de redéfinir nom -> open et override
     */
    data class Etoile(
        override val nom : String,
        val couleur: String,
        val temperatureKelvin: Int
    ) : Astre(nom)

    // Sous-classe : les planètes
    data class Planete(
        override val nom : String,
        val diametreKm: Double,
        val nombreSatellites: Int
    ) : Astre(nom)

    // Sous-classe : les comètes
    data class Comete(
        override val nom : String,
        val periodeAnnees: Double
    ) : Astre(nom)

    // Sous-classe : les satellites naturels
    data class SatelliteNaturel(
        override val nom : String,
        val planeteHote: String
    ) : Astre(nom)
}

// 2. Fonction de description d'un astre
//  Grâce à "sealed", le when est exhaustif : aucun else n'est nécessaire.
fun decrire(astre: Astre) {
    when (astre) {
        is Astre.Etoile ->
            println("${astre.nom} -> Classe : ${astre::class.simpleName}, Couleur : ${astre.couleur}, Température : ${astre.temperatureKelvin} K")
        is Astre.Planete ->
            println("${astre.nom} -> Classe : ${astre::class.simpleName}, Diamètre : ${astre.diametreKm} km, Satellites : ${astre.nombreSatellites}")
        is Astre.Comete ->
            println("${astre.nom} -> Classe : ${astre::class.simpleName}, Période orbitale : ${astre.periodeAnnees} ans")
        is Astre.SatelliteNaturel ->
            println("${astre.nom} -> Classe : ${astre::class.simpleName}, Orbite autour de : ${astre.planeteHote}")
    }
}

// 3. Programme principal
fun main() {
    println("--- OBSERVATOIRE ASTRONOMIQUE ---")
    val soleil = Astre.Etoile(nom="Soleil", couleur="Jaune",temperatureKelvin=5778) // paramètres nommés
    val sirius = Astre.Etoile("Sirius", temperatureKelvin=9940, couleur="Bleu-blanc") // paramètres nommés
    val mars   = Astre.Planete("Mars", 6779.0,2)
    val halley = Astre.Comete("Halley", 75.3)
    val titan  = Astre.SatelliteNaturel("Titan", "Saturne")

    val catalogue = listOf(soleil, sirius, mars, halley, titan)

    for (astre in catalogue) {
        decrire(astre)
    }
}
