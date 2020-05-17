package com.example.miprimerapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class AdapterMovie(var list: ArrayList<Movie>):RecyclerView.Adapter<AdapterMovie.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v=LayoutInflater.from(parent.context).inflate(R.layout.conten_item,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: AdapterMovie.ViewHolder, position: Int) {
        holder.bindItems(list[position])
    }
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        fun bindItems(data:Movie){
            val titulo:TextView=itemView.findViewById(R.id.txtTitle)
            val descripcion:TextView=itemView.findViewById(R.id.txtDescrip)
            val imagen:ImageView=itemView.findViewById(R.id.imageMovie)

            titulo.text=data.titulo
            descripcion.text=data.descripcion
            Picasso.get().load("https://image.tmdb.org/t/p/w1280"+data.imagen).into(imagen)

            itemView.setOnClickListener{
                Toast.makeText(itemView.context,"Pelicula ${data.titulo}",Toast.LENGTH_LONG).show()
            }
        }
    }
}