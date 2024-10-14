package com.example.application.view

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.application.R
import com.example.application.logic.Client
import com.example.application.logic.Controller
import com.example.application.logic.interfaces.OperationsInterface

class MainActivity : AppCompatActivity() , OperationsInterface {
    private lateinit var myButtonAdd : ImageView
    private lateinit var myButtonUpdate : ImageView
    private lateinit var myButtonDel : ImageView
    private lateinit var myDialog: Dialog
    private val controller = Controller()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        Log.d(TAG,"Esto es un ejemplo de Log")
        start()
    }

    private fun start() {
        myButtonAdd = findViewById(R.id.iv_add)
        myButtonUpdate = findViewById(R.id.iv_edit)
        myButtonDel = findViewById(R.id.iv_delete)
        myDialog = Dialog(controller)

        myDialog.setListener(this)
        myButtonAdd.setOnClickListener{
            myDialog.show(0)
        }

        myButtonUpdate.setOnClickListener{
            myDialog.show(1)

        }

        myButtonDel.setOnClickListener( {
            myDialog.show(2)
        })

    }

    companion object{
        const val TAG = "------SALIDA------"
    }

    override fun ClientAdd(id: Int, name: String) {
        val newClient = Client (id, name)
        controller.ClientAddController(newClient)
        var mensaje =  "El cliente con id = $id, ha sido insertado correctamente"

        Log.d(TAG, mensaje)
    }

    override fun ClientDel(id: Int) {
        var mensaje = ""
        val delete = controller.ClientDelController(id)
        if (delete)
            mensaje =  "El cliente con id = $id, ha sido eliminado correctamente"
        else
            mensaje = "El cliente con id = $id, no ha sido encontrado para eliminar"

        Log. d(TAG, mensaje)
    }

    override fun ClientUpdate(id: Int, name: String) {
        var msg = ""
        val update = controller.ClientUpdateController(id, name)  //borramos el 2.
        if (update)
            msg =  "El cliente con id = $id, ha sido eliminado correctamente"
        else
            msg = "El cliente con id = $id, no ha sido encontrado para eliminar"

        Log. d(TAG, msg)
    }
}