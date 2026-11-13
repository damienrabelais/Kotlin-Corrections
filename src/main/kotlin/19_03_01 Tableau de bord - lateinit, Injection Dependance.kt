// 1. Le contrat (Interface commune)
interface SourceDonnees {
    fun recupererDonnees(): String
}
// 2. Première implémentation : Base de données locale (SQLite)
class SourceSqlite : SourceDonnees {
    override fun recupererDonnees(): String {
        return "Données tableau de bord issues de la base SQLite (Mode Hors-ligne)"
    }
}
// 3. Seconde implémentation : Service distant (API REST)
class SourceApiRest : SourceDonnees {
    override fun recupererDonnees(): String {
        return "Données tableau de bord récupérées via l’API REST (Serveur distant)"
    }
}
// 4. Le gestionnaire d'écran
class GestionnaireTableauDeBord {
    // On promet au compilateur que la source de données sera injectée plus tard,
    // tout en gardant un type non-nullable (SourceDonnees).
    lateinit var sourceDonnees: SourceDonnees

    fun afficherTableauDeBord() {
        // Vérification de sécurité obligatoire avec lateinit et ::
        if (!::sourceDonnees.isInitialized) {
            println("Attention : Aucune source de données n'a été configurée !")
            return
        }
        println("Chargement de l'écran...")
        val resultat = sourceDonnees.recupererDonnees()
        println("Affichage : $resultat")
    }
}

fun main() {
    val gestionnaire = GestionnaireTableauDeBord()
    // A. Tentative avant configuration (Promesse non tenue -> déclenche le 'if' de sécurité)
    gestionnaire.afficherTableauDeBord()
    // B. Injection tardive d'une source SQLite (ex: l'application démarre hors-ligne)
    gestionnaire.sourceDonnees = SourceSqlite()
    gestionnaire.afficherTableauDeBord()
    // C. Changement de stratégie : Injection d'une API REST (ex: connexion réseau retrouvée)
    gestionnaire.sourceDonnees = SourceApiRest()
    gestionnaire.afficherTableauDeBord()
}
/*
Pourquoi un type non-nullable (SourceDonnees et non SourceDonnees?) ?
Pour éviter le risque d’un appel de méthode (recupererDonnees()) sur une référence null et s’affranchir de la lourdeur des vérifications ou des appels sécurisés (?.) partout dans le code.

Pourquoi obligatoirement un var (et non un val) ?
Parce que la propriété subit une mutation : elle passe d’un état vide à une affectation, et peut être modifiée en cours d’exécution (changement de stratégie SQLite, API REST). Un val étant immuable, il est par définition incompatible avec l’initialisation tardive.
 */
