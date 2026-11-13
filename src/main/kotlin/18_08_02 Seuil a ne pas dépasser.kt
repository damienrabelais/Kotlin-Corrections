import kotlin.reflect.KProperty

class SeuilMaxDelegate(private val seuilMax: Int) {
    private var valeur: Int = 0

    operator fun getValue(thisRef: Any?, propriete: KProperty<*>): Int {
        return valeur
    }

    operator fun setValue(thisRef: Any?, propriete: KProperty<*>, nouvelleValeur: Int) {
        if (nouvelleValeur > seuilMax) {
            println("[INFO] Limite atteinte sur '${propriete.name}' : $nouvelleValeur plafonné à $seuilMax.")
            valeur = seuilMax
        } else {
            valeur = nouvelleValeur
        }
    }
}

class ReglagesAppareil {
    var volume: Int by SeuilMaxDelegate(100)
    var luminosite: Int by SeuilMaxDelegate(50)
}

fun main() {
    val reglages = ReglagesAppareil()
    reglages.volume = 120    // Plafonné à 100
    reglages.luminosite = 60   // Plafonné à 50
    println("Volume : ${reglages.volume}, Luminosité : ${reglages.luminosite}")
}
