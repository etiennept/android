package com.example.myproject

object nav_graph {
    // Counter for id's. First ID will be 1.
    var id_counter = 1

    val id = id_counter++

    object dest {
        val firstFragmentId= id_counter++
        val secondFragment = id_counter++
    }

    object action {
        val firstFragment_to_secondFragment = id_counter++
        val secondFragment_to_firstFragment = id_counter++
    }

    object args {
        const val plant_id = "plantId"
    }
}