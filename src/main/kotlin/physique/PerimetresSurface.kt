package physique

import kotlin.math.pow
fun PerimetreCercle(pRayon: Double): Double  = 2 * kotlin.math.PI * pRayon
fun SurfaceCercle(pRayon: Double): Double = kotlin.math.PI * pRayon.pow(2)
fun PerimetreRectangle(pLongueur: Double, pLargeur: Double): Double = (pLongueur + pLargeur) * 2
fun SurfaceRectangle(pLongueur: Double, pLargeur: Double): Double = pLongueur * pLargeur