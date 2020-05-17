package com.example.miprimerapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesTopratedService {
    @GET("3/movie/top_rated?")
    fun getCurrentMoviesData(@Query("api_key") app_id: String): Call<MoviesResponse>
}