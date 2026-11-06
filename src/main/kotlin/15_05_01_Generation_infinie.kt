fun main() {
    val puissancesDeDeux = sequence {
        var nombre = 1
        while (true) {
            yield(nombre)
            nombre *= 2
        }
    }
    val result = puissancesDeDeux.take(10).joinToString(", ")
    println("Les 10 premières puissances de 2 : $result")
}
