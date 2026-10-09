fun main () {
    val indices = (0..4)
    val suiteConvergente = indices.map { 1.0/Math.pow(2.0, it.toDouble()) }
    // OU val suiteConvergente = indices.map { n -> 1.0 / Math.pow(2.0, n.toDouble()) }
    suiteConvergente.forEach { println(it) }
}
