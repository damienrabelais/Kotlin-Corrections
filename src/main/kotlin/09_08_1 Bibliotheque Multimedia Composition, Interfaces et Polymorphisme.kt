
// 9.8.1 Bibliothèque Multimédia : Composition, Interfaces et Polymorphisme
interface IDocument {
    val titre: String
    val auteur: String
    val editeur: String
    val dateParution: String
    fun afficherDetails(): String
}

class Livre(
    override val titre: String,
    override val auteur: String,
    override val editeur: String,
    override val dateParution: String,
    val quatriemeDeCouverture: String,
    val nombrePages: Int
) : IDocument {
    override fun afficherDetails() = "Livre : $titre, écrit par $auteur, publié par $editeur en $dateParution. ($nombrePages pages)"
}

class Photo(
    override val titre: String,
    override val auteur: String,
    override val editeur: String,
    override val dateParution: String,
    val resolutionHorizontale: Int,
    val resolutionVerticale: Int,
    val estCouleur: Boolean
) : IDocument {
    override fun afficherDetails(): String {
        val type = if (estCouleur) "couleur" else "noir et blanc"
        return "Photo : $titre par $auteur. Résolution: ${resolutionHorizontale}x${resolutionVerticale}px, $type."
    }
}

class Bibliotheque {
    private val catalogue = ArrayList<IDocument>()

    fun ajouterDocument(doc: IDocument) {
        catalogue.add(doc)
    }

    fun afficherTout() {
        println("--- Contenu de la bibliothèque ---")
        for (doc in catalogue) {
            println(doc.afficherDetails())
        }
    }
}

fun main() {
    val maBiblio = Bibliotheque()

    // Ajout des classiques de la SF avec leurs éditeurs français historiques
    maBiblio.ajouterDocument(
        Livre(
            "Fondation",
            "Isaac Asimov",
            "Editions Opta",
            "1957",
            "La chute de l'Empire Galactique et la création d'une science prédictive.",
            255
        )
    )

    maBiblio.ajouterDocument(
        Livre(
            "Fahrenheit 451",
            "Ray Bradbury",
            "Denoël",
            "1955",
            "Un futur où les livres sont brûlés par des pompiers pyromanes.",
            165
        )
    )

    maBiblio.ajouterDocument(Photo("Coucher de soleil", "Robert Doisneau", "Archive", "1950", 1920, 1080, true))
    maBiblio.afficherTout()
}
