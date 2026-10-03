fun appliquerDeuxFois(x: Double, f: (Double) -> Double): Double  = f(f(x))

fun composer(f: (Double) -> Double, g: (Double) -> Double): (Double) -> Double = { x -> g(f(x)) }

/* OU, de manière 'classique' :
fun appliquerDeuxFois(x: Double, f: (Double) -> Double): Double {
  return f(f(x))
}
fun composer(f: (Double) -> Double, g: (Double) -> Double): (Double) -> Double {
  return { x -> g(f(x)) }
} */

fun main() {
    val r1 = appliquerDeuxFois(5.0) { x -> x + 10 }
    println("f(f(5)) avec f(x)=x+10 : $r1")   // 25.0

    val r2 = appliquerDeuxFois(3.0) { x -> x * 2 }
    println("f(f(3)) avec f(x)=x*2 : $r2")  // 12.0

    val h = composer({ x -> x + 1 }, { x -> x * 2 })
    println("h(4) = ${h(4.0)}")         // 10.0
}
