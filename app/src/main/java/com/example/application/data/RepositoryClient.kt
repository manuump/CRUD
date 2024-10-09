package com.example.application.data

import com.example.application.logic.Client

class RepositoryClient {
    companion object{
        var primary = 100

        val listClient  : List<Client> = listOf(
            Client (incrementPrimary(),"Manu"),
            Client (incrementPrimary(),"Manu"),
            Client (incrementPrimary(),"Manu"),
            Client (incrementPrimary(),"Manu")
        )
        fun incrementPrimary() = primary ++
    }
}