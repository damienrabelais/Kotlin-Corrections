import kotlinx.coroutines.*
// Fonction "suspendue" : elle peut être mise en pause sans bloquer le thread
suspend fun telechargerPochette() {
    println("telechargerPochette: Début du téléchargement de la pochette...")
    delay(2000) // Simulation d'une attente réseau
    println("telechargerPochette: Pochette téléchargée !")
}

fun main() = runBlocking {
    println("main: Ouverture de l'application")
    // On lance la coroutine : cela crée une tâche en arrière-plan
    val job = launch {
        telechargerPochette()
    }
    // Cette ligne s'exécute IMMÉDIATEMENT, sans attendre la fin du téléchargement
    println("main: Menu principal (disponible, pendant le téléchargement)")
    job.join()// On attend la fin de la coroutine … puis passage à l’instruction ci-après
    println("main: Fin de l'application")
}
