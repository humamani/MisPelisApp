package com.example.miprimerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // definicion de categorias para luego mostrar en multitext view
        var categorias= arrayOf<String> ("Popular","Top Rated","Upcoming")
        var adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,categorias)
        mltCategorias.threshold=0
        mltCategorias.setAdapter(adapter)
        mltCategorias.setOnFocusChangeListener { view, b-> if(b) mltCategorias.showDropDown()}
        //
        val btIniciar = findViewById<Button>(R.id.btIniciar)
        //se envia el campo usario a la actividad de busqueda de peliculas
        btIniciar.setOnClickListener {
            val categoria:String=mltCategorias.text.toString()
            val intent=Intent(this,busquedaActivity::class.java)
            intent.putExtra("Categoria",categoria)
            startActivity(intent)
        }
    }
}
