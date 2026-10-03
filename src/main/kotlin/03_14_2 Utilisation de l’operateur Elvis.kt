/*3.14.2 Utilisation de l’opérateur Elvis
L’opérateur Elvis permet de fournir une valeur de repli lorsque 
l'expression de gauche évalue à null.
 */
fun main() {
    val pseudo: String? = null
    val affichage = pseudo ?: "Utilisateur Anonyme"
    println(affichage)
}
