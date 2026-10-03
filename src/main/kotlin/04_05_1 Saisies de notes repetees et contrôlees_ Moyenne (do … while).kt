/* 4.5.1 Saisies de notes répétées et contrôlées. Moyenne (do … while)
 */
fun main() {
    var somme = 0.0
    var compteur = 0
    var note: Double?
    do {
        print("Note ? (-1 pour sortir) ")
        note = readlnOrNull()?.toDoubleOrNull()
        // Smart cast actif : note est garantie non nulle et différente de -1.0
        if (note != null && note != -1.0) {
            somme += note
            compteur++
        }
    } while (note != -1.0)
    if (compteur > 0) {
        println("Somme : $somme")
        println("Compteur : $compteur")
        println("Moyenne = ${somme / compteur}")
    }
    println("Au revoir")
}
