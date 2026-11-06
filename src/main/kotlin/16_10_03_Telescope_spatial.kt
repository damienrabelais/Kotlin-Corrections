import kotlinx.coroutines.*

suspend fun recupererDonneesCamera(): String {
    println("recupererDonneesCamera : Début caméra")
    delay(2000)
    println("recupererDonneesCamera : Fin caméra (après 2s)")
    return "Image Infrarouge"
}

suspend fun recupererDonneesSpectro(): String {
    println("recupererDonneesSpectro : Début spectro")
    delay(2000)
    println("recupererDonneesSpectro : Fin spectro (après 2s)")
    return "Analyse Spectrale"
}

fun main() = runBlocking {
    println("main : Début de la mission ---")

    // On lance les deux en parallèle avec async
    val cameraDeferred = async { recupererDonneesCamera() }
    val spectroDeferred = async { recupererDonneesSpectro() }

    println("main : Récupération des données en cours...") // après appels fonctions !

    // await : attente des retours coroutines :
    val resultat = "Résultats : ${cameraDeferred.await()} + ${spectroDeferred.await()}"

    println(resultat)
    println("main : Mission terminée")
}
