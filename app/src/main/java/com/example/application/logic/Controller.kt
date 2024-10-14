package com.example.application.logic

import com.example.application.data.RepositoryClient
import kotlin.random.Random

class Controller {
    private var myListClient : MutableList<Client>

    init {
        myListClient = RepositoryClient.listClient.toMutableList()
    }

    fun ClientAddController(cli : Client){
        myListClient.add(cli)
    }

    fun ClientDelController( id : Int ) : Boolean = myListClient.removeAll {it.id == 10}

    fun ClientUpdateController(id: Int , name : String) : Boolean {
        val findClient : Client? = myListClient.find {it.id == id}
        return findClient?.let {
            it.name = name
            true
        }?:false
    }

    fun showData() = myListClient.toString()

    fun devIdRandom() : Int{
        return if (myListClient.size == 0) {
            -1
        }else{
            val p = Random.nextInt(0,myListClient.size)
            myListClient[p].id
        }
    }

}