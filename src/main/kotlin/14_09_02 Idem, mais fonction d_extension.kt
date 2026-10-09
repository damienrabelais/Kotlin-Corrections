// Déclaration de la fonction d'extension sur List<Int>
fun List<Int>.transformer(operation: (Int) -> Int): MutableList<Int> {
    val resultat = mutableListOf<Int>()
    // 'this' représente l'instance de la liste sur laquelle on appelle la fonction
    for (element in this) {
        resultat.add(operation(element))
    }
    return resultat
}

fun main() {
    // Appel de la fonction d'extension directement sur la liste
    val doubles = listOf(1, 2, 3, 4).transformer { it * 2 }
    // OU val doubles = listOf(1, 2, 3, 4).transformer { x -> x * 2 }
    println(doubles)  // [2, 4, 6, 8]
}
