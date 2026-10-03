package physique

// TESTS UNITAIRES :
// 7.3.2 Périmètres, Surfaces

import kotlin.test.Test
import kotlin.test.assertEquals

class GeometrieTest {

    @Test
    fun testPerimetreCercle() {
        // Rayon = 10.0 -> 2 * PI * 10 ≈ 62.83185
        val resultat = PerimetreCercle(10.0)
        assertEquals(62.83185, resultat, 0.0001)
    }

    @Test
    fun testSurfaceCercle() {
        // Rayon = 10.0 -> PI * 10² ≈ 314.159265
        val resultat = SurfaceCercle(10.0)
        assertEquals(314.159265, resultat, 0.0001)
    }

    @Test
    fun testPerimetreRectangle() {
        // Longueur = 10.0, Largeur = 10.0 -> (10 + 10) * 2 = 40.0
        val resultat = PerimetreRectangle(10.0, 10.0)
        assertEquals(40.0, resultat, 0.0001)
    }

    @Test
    fun testSurfaceRectangle() {
        // Longueur = 10.0, Largeur = 10.0 -> 10 * 10 = 100.0
        val resultat = SurfaceRectangle(10.0, 10.0)
        assertEquals(100.0, resultat, 0.0001)
    }
}
