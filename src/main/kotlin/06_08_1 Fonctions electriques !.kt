// 6.8.1 Fonctions électriques !
// Fonctions top-level : fichier electricite.kt dans le package Utils

// 1. Fonction Top-Level : Calcul de la Tension (Loi d'Ohm : U = R * I)
// le type retour aurait pu être inféré
fun calculerTension(resistance: Double, intensite: Double): Double = resistance * intensite

// 2. Fonction Top-Level : Calcul de la Puissance (Loi de la Puissance : P = U * I)
// type retour inféré ici
fun calculerPuissance(tension: Double, intensite: Double) = tension * intensite

// Fichier main.kt


fun main() {
    print("Valeur de la résistance (en Ohm) (>=0) ? ")
    val resistance = readlnOrNull()?.toDoubleOrNull()
    print("Valeur de l'intensité (en Ampère) (>=0) ? ")
    val intensite = readlnOrNull()?.toDoubleOrNull()
    if (resistance != null && intensite != null) {
        if (resistance > 0 && intensite > 0) {
            val tension = calculerTension(resistance, intensite)
            println("Tension du Circuit (U) : $tension Volt")
            println("Puissance (P) : ${calculerPuissance(tension, intensite)} Watt")
        } else {
            println("Erreur(s) de saisie  : résistance ou intensité < 0.")
        }
    } else {
        println("Erreur(s) de saisie sur la résistance ou l'intensité.")
    }
}
