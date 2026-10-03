fun main() {
    val doubler: (Int) -> Int = { x -> x * 2 }
    println(doubler(5))     // 10

    val additionner: (Int, Int) -> Int = { a, b -> a + b }
    println(additionner(3, 4)) // 7

    val saluer: () -> String = { "Bonjour" }
    println(saluer())      // Bonjour
}
