import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking {
    // MutableStateFlow contient l'état actuel de la batterie.
    // L'UI (la console) sera toujours informée de la valeur la plus récente.
    val etatBatterie = MutableStateFlow<Int>(100)
    // 1. Coroutine "Sonde" : Le Producteur
    val sondeJob = launch {
        val niveaux = listOf(80, 50, 20, 5)
        for (niveau in niveaux) {
            delay(1000) // Simulation de la consommation énergétique
            // On met à jour l'état. Le StateFlow prévient immédiatement la console.
            etatBatterie.value = niveau
            println("--- Sonde [Ares-1] : Nouveau niveau -> $niveau%")
        }
    }
    // 2. Coroutine "Console de contrôle" : Le Consommateur
    val consoleJob = launch {
        // Le collect attend que l'état change.
        etatBatterie.collect { niveauLu ->
            println(">>> Console : État reçu -> $niveauLu%")
            if (niveauLu < 20) {
                println("!!! ALERTE CRITIQUE : Énergie faible sur Ares-1 !!!")
            }
        }
    }
    // La simulation dure 5 secondes
    delay(5000)
    // Nettoyage
    sondeJob.cancel()
    consoleJob.cancel()
    println("--- Transmission terminée ---")
}
