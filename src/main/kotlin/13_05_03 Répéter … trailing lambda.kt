fun repeter(fois: Int, action: (Int) -> Unit) {
    for (i in 1..fois) {
        action(i)
    }
}

fun main() {
    repeter(3) { noTour ->
        println("Tour n°$noTour")
    }
}

/*
Commentaires :
-	{noTour->println("Tour n°$noTour") }  : noTour  = entrée (Int) envoyé à println("Tour n°$noTour") = fonction exécutée, retourne Unit.
-	For (i in 1..fois) {action(i)} : pour chaque i, i recopié dans noTour (paramètre formel), et exécution de println("Tour n°$noTour")
*/