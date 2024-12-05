package com.example.cocktailapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cocktailapplication.data.api.RetrofitInstance
import com.example.cocktailapplication.data.model.Cocktail
import com.example.cocktailapplication.data.model.CocktailResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CocktailViewModel(application: Application) : AndroidViewModel(application) {

    private val _cocktails = MutableLiveData<List<Cocktail>>()
    val cocktails: LiveData<List<Cocktail>> get() = _cocktails

    fun fetchCocktails() {
        RetrofitInstance.api.searchCocktails("a").enqueue(object : Callback<CocktailResponse> {
            override fun onResponse(call: Call<CocktailResponse>, response: Response<CocktailResponse>) {
                if (response.isSuccessful) {
                    _cocktails.value = response.body()?.drinks ?: emptyList()
                }
            }

            override fun onFailure(call: Call<CocktailResponse>, t: Throwable) {
                _cocktails.value = emptyList()
            }
        })
    }
}
