/* 4.3.3 Montant après remise (when, nullable).
 */
fun main() {
    print("Montant avant remise ? ")
    val montant: Float? = readlnOrNull()?.toFloatOrNull()
    if (montant != null) {
        // grace à ce test ‘montant passe’ a type Float non-nullable dans le when (Smart Casting)
        val remise = when {
            montant < 2000 -> 0
            montant <= 5000 -> 1
            else -> 2
        }
        println("La remise est de $remise%")
        val montantNet = montant - (montant * (remise / 100.0))
        println("Montant net après remise = $montantNet")
    } else {
        println("Erreur : veuillez saisir un montant valide.")
    }
}
