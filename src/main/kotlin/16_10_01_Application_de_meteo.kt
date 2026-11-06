import kotlinx.coroutines.*

// Fonction simulant un appel API (c'est une opération longue)
suspend fun recupererMeteo(): String {
    // Simulation d'une attente réseau (ex: serveur distant)
    delay(3000)
    return "37°C, canicule !"
}

fun main() = runBlocking {
    println("--- Application Météo ---")
    println("Action : L'utilisateur clique sur le bouton 'Actualiser'")
    // On lance une coroutine pour exécuter la tâche en arrière-plan
    // Cela évite de "figer" l'interface (le thread principal)
    val tache = launch {
        println("... Chargement des données météo en cours ...")
        val meteo = recupererMeteo()
        println("Mise à jour de l'écran avec : $meteo")
    }
    println("L'interface reste réactive : l'utilisateur peut toujours cliquer ailleurs.")
    // On attend que la coroutine soit terminée avant de fermer l'application
    tache.join()
    println("--- Fin de l'application ---")
}
