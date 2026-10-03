// CLASSES :
// 8.17.3 Musique !

class Compositeur(val nom: String, val anneeNaissance: Int, pAnneeDeces : Int = 0) {

    // Propriété modifiable avec un setter personnalisé et un backing field (field)
    var anneeDeces: Int = pAnneeDeces
        set(value) {
            if (value >= anneeNaissance) {
                field = value
            } else {
                field = 0
            }
        }

    // Propriété calculée avec un getter personnalisé
    // val ageAuDeces: Int = 0 Impossible, pas de backing field... pas une property 'classique' ici
    // var ageAuDeces: Int = 0 OK, var -> génération d'un backing field
    val ageAuDeces: Int
        get() = anneeDeces - anneeNaissance
}

fun main() {
    val mozart = Compositeur("Mozart", 1756, pAnneeDeces = 1791)
    // Modification valide
    println("${mozart.nom} est décédé à l'âge de ${mozart.ageAuDeces} ans.")
    // Test de la protection du setter avec une année de décès antérieure à la naissance
    mozart.anneeDeces = 1750
    println("Après affectation d'une année invalide, année de décès = ${mozart.anneeDeces}")
}
