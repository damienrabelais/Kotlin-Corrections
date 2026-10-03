/* 4.5.2 Affichage répété (fonction repeat)
 */
fun main() {
    print("Mot à répéter ? ")
    val mot = readlnOrNull()
    print("Combien de répétitions ? ")
    val n = readlnOrNull()?.toIntOrNull() ?: 1
    repeat(n) {
        print("$mot ")
    }
}
