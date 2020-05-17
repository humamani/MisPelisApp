package com.example.miprimerapp

import com.google.gson.annotations.SerializedName

import java.util.ArrayList

class MoviesResponse {
    @SerializedName("page")
    var page: Int = 0
    @SerializedName("results")
    var results = ArrayList<Movies>()
    @SerializedName("total_results")
    var total_results: Int = 0
    @SerializedName("total_pages")
    var total_pages: Int = 0
}
class Movies {
    @SerializedName("poster_path")
    var poster_path: String? = null
    @SerializedName("adult")
    var adult: Boolean = false
    @SerializedName("overview")
    var overview: String? = null
    @SerializedName("release_date")
    var release_date: String? = null
    @SerializedName("genre_ids")
    var genre_ids: Array<Int>? = null
    @SerializedName("id")
    var id: Int = 0
    @SerializedName("original_title")
    var original_title: String? = null
    @SerializedName("original_language")
    var original_language: String? = null
    @SerializedName("title")
    var title: String? = null
    @SerializedName("backdrop_path")
    var backdrop_path: String? = null
    @SerializedName("popularity")
    var popularity: Number = 0
    @SerializedName("vote_count")
    var vote_count: Int = 0
    @SerializedName("video")
    var video: Boolean = false
    @SerializedName("vote_average")
    var vote_average: Number = 0
}
