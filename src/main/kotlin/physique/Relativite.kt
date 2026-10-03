package physique

import kotlin.math.*

// C : vitesse de la lumière en km/s
const val C = 299792.458

fun dureeSurTerre(pDuree: Double, pVitesseFusee: Double): Double {
    return pDuree / sqrt(1 - pVitesseFusee.pow(2) / C.pow(2))
}

fun longueurSurTerre(pLongueurFusee: Double, pVitesseFusee: Double): Double {
    return pLongueurFusee * sqrt(1 - pVitesseFusee.pow(2) / C.pow(2))
}

fun vitesseRepereTerre(pVitesseRepereFusee: Double, pVitesseFusee: Double): Double {
    return (pVitesseRepereFusee + pVitesseFusee) / (1 + pVitesseRepereFusee * pVitesseFusee / C.pow(2))
}