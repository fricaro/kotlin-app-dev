package br.edu.ifpb.pdm.expobre.francsco

import java.util.*

object MegaSena {

    fun getInstance() : List<Int> {
        val random = Random()
        var numeros = mutableSetOf<Int>()

        while (numeros.size < 6) {
            numeros.add(random.nextInt(60) + 1)
        }

        return numeros.toList().sorted()

    }

}