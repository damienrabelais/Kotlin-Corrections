package org.exemple
import kotlinx.coroutines.*

fun main() = runBlocking {
    val scopeLancement = CoroutineScope(Dispatchers.Default)
    println("--- Centre de contrôle : Début de la séquence ---")
    val jobLancement = scopeLancement.launch {
        var étape = 1
        // Le while s'arrête si la coroutine n'est plus active OU si on a dépassé 5 étapes
        while (isActive && étape <= 5) {
            println("Étape $étape : Vérification des systèmes...")
            delay(1000)
            étape++
        }
        // On vérifie pourquoi la boucle s'est arrêtée
        if (étape > 5) {
            println("--- DÉCOLLAGE : Allumage des moteurs ! ---")
        } else {
            println("!!! ALERTE : Séquence interrompue par sécurité !!!")
        }
    }

    /* ON PEUT AUSSI ECRIRE : *
        val jobLancement = scopeLancement.launch {
      for (étape in 1..5) {
        // Vérification de sécurité : si le scope est annulé, on arrête tout
        if (!isActive) {
        println("!!! ALERTE : Séquence interrompue par sécurité !!!")
        return@launch
        }
        println("Étape $étape : Vérification des systèmes...")
        delay(1000)
      }
      println("--- DÉCOLLAGE : Allumage des moteurs ! ---")
      }
    */

    delay(2500)
    println(">>> Capteur : Anomalie détectée ! Annulation du lancement !")
    jobLancement.cancelAndJoin()
    println("--- Fin de mission ---")
}
