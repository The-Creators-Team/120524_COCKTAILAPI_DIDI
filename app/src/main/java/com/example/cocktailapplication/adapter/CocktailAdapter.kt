package com.example.cocktailapplication.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cocktailapplication.data.model.Cocktail
import com.example.cocktailapplication.databinding.ItemCocktailBinding

class CocktailAdapter(private var cocktails: List<Cocktail>) : RecyclerView.Adapter<CocktailAdapter.CocktailViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailViewHolder {
        val binding = ItemCocktailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CocktailViewHolder(binding)
    }


    override fun onBindViewHolder(holder: CocktailViewHolder, position: Int) {
        val cocktail = cocktails[position]
        holder.bind(cocktail)
    }

    override fun getItemCount(): Int {
        return cocktails.size
    }


    inner class CocktailViewHolder(private val binding: ItemCocktailBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cocktail: Cocktail) {

            binding.tvCocktailName.text = cocktail.strDrink
            Glide.with(binding.root.context)
                .load(cocktail.strDrinkThumb)
                .into(binding.ivCocktailImage)
        }
    }
}
