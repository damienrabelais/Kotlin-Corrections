/* 4.3.2 Catégories d’âge (when et nullable)
 */
fun main() {
    print("Veuillez saisir votre âge :")
    val saisie: String? = readlnOrNull() // Saisie au clavier (peut être null)
    val age: Int? = saisie?.toIntOrNull() // Tentative de conversion en Int
    // Utilisation de when avec smart casting (premier test)
    println(
        when {
            age == null -> // -> les comparaisons ne seront jamais faites avec un age  à null
                "Erreur : vous n'avez pas saisi un nombre valide."
            age < 0 -> "L'âge ne peut pas être négatif."
            // Kotlin sait que age est un Int grâce aux vérifications précédentes (Smart Casting)
            age in 0..12 -> "Vous êtes un enfant."
            age in 13..17 -> "Vous êtes un adolescent."
            age in 18..64 -> "Vous êtes un adulte."
            else -> "Vous êtes un senior."
        }
    )
}
