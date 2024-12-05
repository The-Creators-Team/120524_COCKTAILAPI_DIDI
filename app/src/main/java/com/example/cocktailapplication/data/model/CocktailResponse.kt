package com.example.cocktailapplication.data.model

data class CocktailResponse(
    val drinks: List<Cocktail>
)

data class Cocktail(
    val strDrink: String,
    val strDrinkThumb: String,
    val idDrink: String
)
