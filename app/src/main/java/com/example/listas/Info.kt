package com.example.listas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class Info : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater =menuInflater
        inflater.inflate(R.menu.menu_principal, menu)
        for (i in 0 until menu.size()){
            if (i == MainActivity.actividadActual) menu.getItem(i).isEnabled = false
            else menu.getItem(i).isEnabled = true
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.Peliculas -> {
                val intent = Intent(this, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                MainActivity.actividadActual = 0;
                startActivity(intent)
                true
            }

            R.id.AnadirPelicula -> {
                val intent = Intent(this, AnadirPelicula::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                MainActivity.actividadActual = 1;
                startActivity(intent)
                true
            }
            R.id.App -> {
                val intent = Intent(this, Info::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                MainActivity.actividadActual = 2;
                startActivity(intent)
                true
            }
            R.id.salir ->{
                mostrarDialogo()
                true
            }
            else -> super.onOptionsItemSelected(item)

        }
    }
    fun mostrarDialogo(){
        AlertDialog.Builder(this)
            // Aqui asignamos el titulo
            .setTitle("Guardar")
            // Aqui asignamos el mensaje
            .setMessage("¿Desea salir?")
            // Aqui indicamos que solo se podra cerrar en caso de pulsar alguno de los dos botones
            .setCancelable(false)
            // Mensaje en caso de pulsar "OK"
            .setPositiveButton(android.R.string.ok, { dialog, which -> Toast.makeText(applicationContext, "El usuario desea salir de la aplicacion.", Toast.LENGTH_SHORT).show() })
            // Mensaje en caso de pulsar "Cancel"
            .setNegativeButton(android.R.string.cancel,  { dialog, which -> Toast.makeText(applicationContext, "Ha cancelado la accion.", Toast.LENGTH_SHORT).show() })
            // Aqui mostramos el cuadro de dialogo
            .show()
    }
}