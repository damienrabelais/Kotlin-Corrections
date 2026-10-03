
// TESTS UNITAIRES :
// 7.3.1 Tout est relatif …
package physique

import kotlin.test.Test
import kotlin.test.assertEquals

class RelativiteTest {

    @Test
    fun testDureeSurTerre() {
        val resultat = dureeSurTerre(60.0, 299000.0)
        assertEquals(825.7444, resultat, 0.001)
    }

    @Test
    fun testLongueurSurTerre() {
        val resultat = longueurSurTerre(100.0, 299000.0)
        assertEquals(7.2661, resultat, 0.001)
    }

    @Test
    fun testVitesseRepereTerre() {
        // En relativité, 150 000 + 150 000 ne fait pas 300 000 !
        val v1 = 150000.0
        val v2 = 150000.0
        val resultat = vitesseRepereTerre(v1, v2)
        // On vérifie que le résultat respecte la limite relativiste
        assert(resultat < 299792.458)
        assertEquals(239933.5359, resultat, 0.0001)
    }
}
