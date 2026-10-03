fun calculer(x: Double, f: (Double) -> Double): Double {
    return f(x)
}

fun main() {
    println("Carré de 3.5 : ${calculer(3.5) { x -> x * x }}")
    println("Cube de 2.0 : ${calculer(2.0) { x -> x * x * x }}")
    println("Inverse de 4.0 : ${calculer(4.0) { x -> 1 / x }}")
    println("Opposé de 7.2 : ${calculer(7.2) { x -> -x }}")
    println("Valeur absolue de -6.5 : ${calculer(-6.5) { x -> if (x < 0) -x else x }}")
}
