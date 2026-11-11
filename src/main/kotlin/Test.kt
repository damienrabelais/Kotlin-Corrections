class ServiceUtilisateur {
    // 1. La déclaration 'lateinit'
    // On ne donne pas de valeur initiale car on ne l'a pas encore.
    // On promet au compilateur : "Je garantis que j'initialiserai cette variable
    // avant de tenter de l'utiliser." (Attention : nomUtilisateur n’est pas nullable !)
    // Note : C'est forcément 'var' car la valeur va changer de "vide" à "remplie".
    lateinit var nomUtilisateur: String

    fun configurer(nom: String) {
        // 2. L'initialisation manuelle
        // C'est ici que le "remplissage" se produit.
        nomUtilisateur = nom
    }

    fun afficherNom() {
        // 3. Sécurité optionnelle mais recommandée
        // on teste si le propriété nomUtilisateur est prête.
        if (::nomUtilisateur.isInitialized) { // :: permet "l'inspection" de nomUtilisateur
            println("L'utilisateur est : $nomUtilisateur")
        } else {
            println("Attention : nomUtilisateur n'a pas encore été configuré !")
        }
    }
}

fun main() {
    val service = ServiceUtilisateur()

    // 1. Tentative d'affichage avant toute configuration
    // (La variable lateinit n'est pas encore prête -> active le 'else')
    service.afficherNom()

    // 2. Configuration effective de la variable
    service.configurer("Alice")

    // 3. Nouvel affichage après configuration
    // (La variable est initialisée -> active le 'if')
    service.afficherNom()
}