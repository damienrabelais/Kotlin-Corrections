// 8.17.4 Objets Messier

class ObjetMessier(
    val numero: Int,
    val nom: String,
    typeInitial: String // Paramètre simple du constructeur (pas une propriété)
) {
    init {
        require(numero in 1..110) { "Le numéro Messier $numero est invalide. Il doit être compris entre 1 et 110." }
    }
    // Propriété initialisée à partir du paramètre du constructeur
    val type: String = typeInitial.uppercase()

    // Propriété modifiable avec un setter personnalisé et un backing field (field)
    var magnitudeApparente: Double = 0.0
        set(value) {
            if (value <= 30.0) {
                field = value
            } else {
                field = 30.0
            }
        }

    // Propriété calculée avec un getter personnalisé
    val estVisibleAOeilNu: Boolean
        get() = magnitudeApparente < 6.0
}

fun main() {
    val m31 = ObjetMessier(31, "Galaxie d'Andromède", "galaxie")
    // Modification valide de la magnitude
    m31.magnitudeApparente = 3.4
    println("M${m31.numero} (${m31.nom} - Type : ${m31.type})")
    println("Magnitude : ${m31.magnitudeApparente} -> Visible à l'œil nu ? ${m31.estVisibleAOeilNu}")
    // Test de la protection du setter avec une valeur supérieure à la limite
    m31.magnitudeApparente = 35.0
    println("Après affectation d'une valeur excessive, magnitude enregistrée : ${m31.magnitudeApparente}")
    // Test du bloc init avec un numéro invalide
    try {
        val invalide = ObjetMessier(150, "Objet Inconnu", "nébuleuse")
    } catch (e: IllegalArgumentException) {
        println("Erreur interceptée avec succès : ${e.message}")
    }
}
