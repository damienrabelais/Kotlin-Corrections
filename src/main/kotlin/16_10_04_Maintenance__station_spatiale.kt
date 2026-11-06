import kotlinx.coroutines.*

fun main() = runBlocking {
    println("--- Début de la maintenance station ---")
    // 1. On lance la tâche et on garde la référence dans 'jobMaintenance'
    val jobMaintenance = launch {
        for (i in 1..10) {
            println("Réparation panneau solaire $i/10")
            delay(1000) // Simulation d'une tâche longue
        }
    }
    // 2. Le programme principal attend 2,5 secondes
    delay(2500)
    println(">>> ALERTE : Annulation d'urgence !")
    // 3. On utilise le "handle" pour annuler la tâche spécifique
    jobMaintenance.cancel()
    println("--- Mission terminée ---")
}
