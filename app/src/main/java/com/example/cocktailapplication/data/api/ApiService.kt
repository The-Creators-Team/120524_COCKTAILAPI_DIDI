package com.example.cocktailapplication.data.api

import com.example.cocktailapplication.data.model.CocktailResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search.php")
    fun searchCocktails(@Query("f") letter: String): Call<CocktailResponse>
}
