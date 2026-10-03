import kotlin.math.round

fun calculerVAN(flux: Double, taux: Double, annees: Int, transformation: (Double) -> Double): Double {
    val vanBrute = flux / Math.pow(1 + taux, annees.toDouble())
    return transformation(vanBrute)
}

fun main() {
    val fluxFutur = 1000.0
    val tauxActualisation = 0.07 // 7%
    val duree = 10 // années

    val resultat = calculerVAN(fluxFutur, tauxActualisation, duree) { it }
    println("VAN brute, sans transformation : $resultat")

    val vanSecurisee = calculerVAN(fluxFutur, tauxActualisation, duree) { it * 0.95 }
    println("VAN  avec marge de sécurité de 5% : $vanSecurisee")

    // Cas 3 : On veut un affichage propre en chaîne de caractères
    val affichage = calculerVAN(fluxFutur, tauxActualisation, duree) { round(it) }
    println("VAN  brute arrondie à l'entier le plus proche : $affichage")

    // Lambda : Conversion en USD (x 1.08) avec une marge de sécurité de 2% (x 0.98)
    val vanEnDollars = calculerVAN(fluxFutur, tauxActualisation, duree) {it * 1.08 * 0.98}
    println("VAN brute, estimée en Dollars (1EUR=1.08 USD), avec risque de change de 2% : $vanEnDollars $")
}
