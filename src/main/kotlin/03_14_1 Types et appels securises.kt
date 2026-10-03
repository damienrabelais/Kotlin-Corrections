/* 3.14.1 Correction de types et appels sécurisés
Il faut ajouter un point d’interrogation (?) pour déclarer 
un type nullable, et utiliser l'opérateur d'appel sécurisé « ?. » 
pour éviter un plantage si la variable vaut null.
*/

fun main() {
    val texte: String? = null
    println(texte?.length) // Affiche "null" proprement au lieu de crasher
}
