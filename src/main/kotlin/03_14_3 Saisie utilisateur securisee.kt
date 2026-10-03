/* 3.14.3 Saisie utilisateur sécurisée
Cette correction combine readlnOrNull(), toIntOrNull() pour éviter
les exceptions de conversion, et l’opérateur Elvis pour la valeur de secours.
*/
fun main() {
    print("Votre âge ? ")
    val age = readlnOrNull()?.toIntOrNull() ?: 18
    println("Âge retenu : $age")
}

/* Fonctionne également avec readln(), mais :
-	readlnOrNull() : Récupère la ligne lue sous forme de chaîne nullable (String?). Elle protège contre la fin de flux (EOF)
en retournant null si le canal est fermé.
-	?.toIntOrNull() : Si la chaîne n’est pas nulle, elle tente de la convertir en entier (Int?). Contrairement à .toInt(),
si l'utilisateur entre du texte non numérique (ex: "abc") ou appuie simplement sur Entrée (chaîne vide ""), cette
fonction retourne null au lieu de faire planter le programme avec une NumberFormatException.
-	?: 18 : Si valeur null à gauche de l’opérateur Elvis, alors ce même opérateur retourne la valeur de repli, soit, ici, 18.
*/