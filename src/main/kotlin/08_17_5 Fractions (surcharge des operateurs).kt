// 8.17.5 Fractions (surcharge des opérateurs)
data class Fraction(val numerateur: Int, val denominateur: Int) {
  init {
    require(denominateur != 0) { "Le dénominateur ne peut pas être nul." }
  }

  // Addition : (a/b) + (c/d) = (ad + bc) / bd
  operator fun plus(autre: Fraction): Fraction {
    return Fraction(
      this.numerateur * autre.denominateur + autre.numerateur * this.denominateur,
      this.denominateur * autre.denominateur
    )
  }

  // Soustraction : (a/b) - (c/d) = (ad - bc) / bd
  operator fun minus(autre: Fraction): Fraction {
    return Fraction(
      this.numerateur * autre.denominateur - autre.numerateur * this.denominateur,
      this.denominateur * autre.denominateur
    )
  }

  // Multiplication : (a/b) * (c/d) = (ac) / (bd)
  operator fun times(autre: Fraction): Fraction {
    return Fraction(
      this.numerateur * autre.numerateur,
      this.denominateur * autre.denominateur
    )
  }

  // Inversion de signe : -(a/b) = (-a/b)
  operator fun unaryMinus(): Fraction {
    return Fraction(-numerateur, denominateur)
  }

  override fun toString(): String = "$numerateur/$denominateur"
}

fun main() {
  val f1 = Fraction(1, 2)
  val f2 = Fraction(1, 3)

  println("Addition : ${f1 + f2}")    // 5/6
  println("Soustraction : ${f1 - f2}")  // 1/6
  println("Multiplication : ${f1 * f2}")// 1/6
  println("Inversion : ${-f1}")         // -1/2
}
