package com.example.application.view

import com.example.application.data.RepositoryClient
import com.example.application.logic.Controller
import com.example.application.logic.interfaces.OperationsInterface

class Dialog(var controller: Controller) {
    private var listener: OperationsInterface? = null

    private var action : Int = 0

    fun setListener ( _listener : OperationsInterface){
        listener = _listener

    }

    fun show(typeAction : Int){
        listener?.let{
            val posibleName = "cambiado"
            val posibleId = controller.devIdRandom()
            when (typeAction){
                0 -> onAccept()
                1 ->
                    if (posibleId != -1)
                        onEdit(posibleId, "CAMBIADO")
                2 ->
                    if (posibleId != -1)
                        onDelete(posibleId)

            }
        }
    }

    private fun onDelete(id : Int) {
        listener!!.ClientDel(id)
    }

    private fun onEdit(id: Int, name : String) {
        listener!!.ClientUpdate(id, name)
    }

    private fun onAccept() {
        listener!!.ClientAdd(RepositoryClient.incrementPrimary(), "NUEVO CLIENTE")
    }
}