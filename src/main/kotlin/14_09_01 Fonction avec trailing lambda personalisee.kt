fun transformer(liste: List<Int>, operation: (Int) -> Int): MutableList<Int> {
    val resultat = mutableListOf<Int>()
    for (element in liste) {
        resultat.add(operation(element))
    }
    return resultat
}

fun main() {
    // Trailing lambda pour doubler
    val doubles = transformer(listOf(1, 2, 3, 4)) { x -> x * 2 }
    println(doubles)   // [2, 4, 6, 8]
}
