import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

// La data class représente l'état complet à un instant T.
data class EtatDrone(
    val altitude: Int = 0,
    val statut: String = "Au sol"
)

fun main() = runBlocking {
    // droneStateFlow : flux d'état pour le drone, c'est notre "Source" = producteur.
    val droneStateFlow = MutableStateFlow<EtatDrone>(EtatDrone(0, "Au sol"))
    // Coroutine "Drone" : producteur
    launch {
        delay(1000)
        droneStateFlow.value = EtatDrone(50, "En vol")
        println("--- Drone : Décollage effectué, ${droneStateFlow.value} ---")
        delay(1000)
        droneStateFlow.value = EtatDrone(0, "Livré")
        println("--- Drone : Colis déposé, ${droneStateFlow.value} ---")
    }
    // Coroutine "Moniteur" :
    // Ecoute le droneStateFlow, chaque modification de la propriété 'value'
    // lance automatiquement la lambda avec en entrée la nouvelle 'value'
    launch {
        droneStateFlow.collect { etatLu ->
            println(">>> Moniteur : Altitude=${etatLu.altitude}m | Statut=${etatLu.statut}")
        }
    }
    delay(3000)
    println("--- Mission terminée ---")
}
