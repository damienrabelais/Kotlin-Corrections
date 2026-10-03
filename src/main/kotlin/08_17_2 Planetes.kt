// CLASSES :
// 8.17.2 Planètes

data class Planete(
    val nom: String,
    val masse: Double,
    val rayon: Double,
    val distanceSoleil: Double
) {
    init {
        require(masse >= 0.0) { "La masse de la planète ${nom} doit être > 0." }
        require(rayon >= 0.0) { "Le rayon de la planète ${nom} doit être > 0." }
        require(distanceSoleil >= 0.0) { "La distance au Soleil de la planète ${nom} doit être > 0." }
    }
}

fun main() {
    try {
        val terre = Planete(nom = "Terre", masse = 1.0, rayon = 6371.0, distanceSoleil = 1.0)
        val mars = Planete(nom = "Mars", masse = 0.11, rayon = 3389.5, distanceSoleil = 1.52)
        val jupiter = Planete(nom = "Jupiter", masse = 317.8, rayon = 69911.0, distanceSoleil = 5.2)
        println("${terre.nom} -> Masse : ${terre.masse} M terrestre(s), Rayon : ${terre.rayon} km, Distance : ${terre.distanceSoleil} UA")
        println("${mars.nom} -> Masse : ${mars.masse} M terrestre(s), Rayon : ${mars.rayon} km, Distance : ${mars.distanceSoleil} UA")
        println("${jupiter.nom} -> Masse : ${jupiter.masse} M terrestre(s), Rayon : ${jupiter.rayon} km, Distance : ${jupiter.distanceSoleil} UA")

        // Test avec masse négative
        val nerio = Planete(nom = "Nerio", masse = -2.5, rayon = 1500.0, distanceSoleil = 3.1)
    } catch (e: IllegalArgumentException) {
        println("Erreur interceptée : ${e.message}")
    }
}
