package com.example.miprimerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class busquedaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_busqueda)
        // recuperar la categoria con intent desde la actividad principal
        var intent = intent
        val categoria = intent.getStringExtra("Categoria")
        // Se envia la categoria recibida a la funcion CurrentData
         getCurrentData(categoria)
    }

    internal fun getCurrentData(categ:String) {
        val retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        when(categ){
            in "Popular"-> {
                val service = retrofit.create(MoviesService::class.java)
                val call = service.getCurrentMoviesData(AppId)
                val recyclerView: RecyclerView = findViewById(R.id.recycler)
                recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
                //se recuperan las peliculas de la categoria: popular
                call.enqueue(object : Callback<MoviesResponse> {
                    override fun onResponse(call: Call<MoviesResponse>, response: Response<MoviesResponse>) {
                        if (response.code() == 200) {
                            val moviesResponse = response.body()!!
                            var ind:Int=0
                            val peliculas = ArrayList<Movie>()
                            while (ind < moviesResponse.results.size) {
                                peliculas.add(Movie(moviesResponse.results[ind].title.toString(), moviesResponse.results[ind].overview.toString(),moviesResponse.results[ind].poster_path.toString()))
                                ind+=1
                            }
                            val adapter = AdapterMovie(peliculas)
                            recyclerView.adapter = adapter
                        }
                    }
                    override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                        val peliaux2 = Movie(" "," "," ")
                        peliaux2.titulo = t.message.toString()
                    }
                })
            }
            in "Top Rated"->{
                val service = retrofit.create(MoviesTopratedService::class.java)
                val call = service.getCurrentMoviesData(AppId)
                val recyclerView: RecyclerView = findViewById(R.id.recycler)
                recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
                //Se recuperan las peliculas de la categoria: Top Rated
                call.enqueue(object : Callback<MoviesResponse> {
                    override fun onResponse(call: Call<MoviesResponse>, response: Response<MoviesResponse>) {
                        if (response.code() == 200) {
                            val moviesResponse = response.body()!!
                            var ind:Int=0
                            val peliculas = ArrayList<Movie>()
                            while (ind < moviesResponse.results.size) {
                                peliculas.add(Movie(moviesResponse.results[ind].title.toString(), moviesResponse.results[ind].overview.toString(),moviesResponse.results[ind].poster_path.toString()))
                                ind+=1
                            }
                            val adapter = AdapterMovie(peliculas)
                            recyclerView.adapter = adapter
                        }
                    }
                    override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                        val peliaux2 = Movie(" "," "," ")
                        peliaux2.titulo = t.message.toString()
                    }
                })
            }
            in "Upcoming"->{
                val service = retrofit.create(MoviesUpcomingService::class.java)
                val call = service.getCurrentMoviesData(AppId)
                val recyclerView: RecyclerView = findViewById(R.id.recycler)
                recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
                //Se recuperan las peliculas de la categoria: Upcoming
                call.enqueue(object : Callback<MoviesResponse> {
                    override fun onResponse(call: Call<MoviesResponse>, response: Response<MoviesResponse>) {
                        if (response.code() == 200) {
                            val moviesResponse = response.body()!!
                            var ind:Int=0
                            val peliculas = ArrayList<Movie>()
                            while (ind < moviesResponse.results.size) {
                                peliculas.add(Movie(moviesResponse.results[ind].title.toString(), moviesResponse.results[ind].overview.toString(),moviesResponse.results[ind].poster_path.toString()))
                                ind+=1
                            }
                            val adapter = AdapterMovie(peliculas)
                            recyclerView.adapter = adapter
                        }
                    }
                    override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                        val peliaux2 = Movie(" "," "," ")
                        peliaux2.titulo = t.message.toString()
                    }
                })
            }
            else ->{
                val recyclerView: RecyclerView = findViewById(R.id.recycler)
                recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
                // En caso que no ingrese la categoria deseada se muestran los mensajes de error correspondiente
                val peliculas = ArrayList<Movie>()
                peliculas.add(Movie("No existe la categoria seleccionada","Por favor vuelva a ingresar una categoria nueva"," "))
                val adapter = AdapterMovie(peliculas)
                recyclerView.adapter = adapter
            }
        }
    }
    companion object {
        var BaseUrl = "https://api.themoviedb.org/"
        var AppId = "5798275f697fa5200ae5828f22015eb8"
    }
}
