import kotlin.properties.Delegates

class CapteurMoteur {
    // La lambda est déclenchée après que le changement a eu lieu.
    var temperature: Double by Delegates.observable(20.0) { _, ancien, nouveau ->
        // On vérifie les limites après coup
        if (nouveau !in -20.0..150.0) {
            println("[ALERTE] Température invalide détectée : $nouveau°C. (Plage autorisée: -20 à 150)")
            // la valeur a été changée, mais on notifie l'anomalie
        } else {
            println("[CAPTEUR] Nouvelle température enregistrée : $nouveau°C")
        }
    }
}

fun main() {
    val capteur = CapteurMoteur()
    capteur.temperature = 50.0   // Valide -> Notification enregistrement
    capteur.temperature = 200.0  // Invalide -> Notification d'alerte (mais la valeur est modifiée)
}
