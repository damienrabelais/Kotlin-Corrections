// CLASSES ET FONCTIONS GENERIQUES
// 8.19.1 Armorique Shipping

data class MaterielInformatique(val designation: String, val assembleur: String)
data class CaisseBoisson(val appellation: String, val volumeLitres: Double)

// Classe générique Conteneur
class Conteneur<T>(val contenu: T, poidsInitial: Double) {
    init {
        require(poidsInitial >= 0.0) { "Le poids initial du conteneur doit être >= à 0" }
        println("Conteneur initialisé avec succès")
    }
    var poids: Double = poidsInitial
        private set(value) {
            field = if (value >= 0.0) value else 0.0
        }
    fun ajouterPoids(poidsAjoute: Double) {
        require(poidsAjoute >= 0.0) { "Le poids à ajouter doit être >= à 0." }
        this.poids += poidsAjoute
    }
    override fun toString(): String {
        return "$contenu, Poids total : $poids t"
    }
}

fun main() {
    // 1. Conteneur transportant MaterielInformatique (poids initial = 0.0)
    val pc = MaterielInformatique("PC ProDesk", "HP")
    val conteneurPC = Conteneur(pc, 0.0)
    println("État initial : $conteneurPC")
    conteneurPC.ajouterPoids(1.2)
    println("Après +1.2t : $conteneurPC")
    conteneurPC.ajouterPoids(0.4)
    try {
        println("Tentative ajout -3.0")
        conteneurPC.ajouterPoids(-3.0)
    } catch (e: IllegalArgumentException) {
        println("Erreur interceptée : ${e.message}")
    }
    println("Après +0.4t : $conteneurPC")
    println()
    // 2. Conteneur transportant CaisseBoisson (poids initial = 0.0)
    val cidre = CaisseBoisson("Cidre breton", 30.0)
    val conteneurCidre = Conteneur(cidre, 0.0)
    println("État initial : $conteneurCidre")
    conteneurCidre.ajouterPoids(2.5)
    try {
        println("Tentative ajout -1.0")
        conteneurCidre.ajouterPoids(-1.0)
    } catch (e: IllegalArgumentException) {
        println("Erreur interceptée : ${e.message}")
    }
    println("Après +2.5t : $conteneurCidre")

    println("\nECHEC CREATION CONTENEUR : poids initial < 0")
    try {
        val mauvais = Conteneur(cidre, -5.0)
        println("Objet créé : $mauvais")
    } catch (e: IllegalArgumentException) {
        println("Erreur interceptée : ${e.message}")
    }
}
