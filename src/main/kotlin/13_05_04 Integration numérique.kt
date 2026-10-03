import kotlin.math.PI
import kotlin.math.sin

fun integrer(a: Double, b: Double, n: Int, f: (Double) -> Double): Double {
    val largeur = (b - a) / n
    var somme = 0.0
    var x = 0.0
    for (i in 1..n) {
        x = a + (i - 0.5) * largeur
        somme += f(x)
    }
    return largeur * somme
}

fun main() {
    val i1 = integrer(0.0, 1.0, 1000) { x -> x }
    println("Intégrale de x sur [0,1] : $i1")  // ≈ 0.5

    val i2 = integrer(0.0, 1.0, 1000) { x -> x * x }
    println("Intégrale de x² sur [0,1] : $i2")   // ≈ 0.3333

    val i3 = integrer(0.0, PI, 1000) { x -> sin(x) }  // fonction sin importée !
    println("Intégrale de sin(x) sur [0,π] : $i3")   // ≈ 2.0
}
