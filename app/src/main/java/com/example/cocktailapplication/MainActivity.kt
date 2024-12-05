package com.example.cocktailapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cocktailapplication.adapter.CocktailAdapter
import com.example.cocktailapplication.viewmodel.CocktailViewModel
import com.example.cocktailapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var cocktailViewModel: CocktailViewModel
    private lateinit var cocktailAdapter: CocktailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)


        setContentView(binding.root)


        cocktailViewModel = ViewModelProvider(this).get(CocktailViewModel::class.java)


        cocktailAdapter = CocktailAdapter(emptyList())
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = cocktailAdapter


        cocktailViewModel.cocktails.observe(this, Observer { cocktails ->

            cocktailAdapter = CocktailAdapter(cocktails)
            binding.recyclerView.adapter = cocktailAdapter
        })


        binding.buttonLoadCocktails.setOnClickListener {

            cocktailViewModel.fetchCocktails()
        }
    }
}
