package com.example.miprimerapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesService {
    @GET("3/movie/popular?")
    fun getCurrentMoviesData(@Query("api_key") app_id: String): Call<MoviesResponse>
}