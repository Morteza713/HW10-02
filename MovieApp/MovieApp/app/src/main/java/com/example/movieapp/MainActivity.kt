package com.example.movieapp

import android.annotation.SuppressLint
import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.movieapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val navController by lazy { findNavController(R.id.nav_host_fragment_container) }
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        NavigationUI.setupActionBarWithNavController(this, navController )

        binding.bottomNavigationMain.menu.findItem(R.id.profileFragment).isChecked = true
        navController.navigate(R.id.profileFragment)
        pageSelect()


    }
    private fun pageSelect(){
        binding.bottomNavigationMain?.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.homeFragment -> {
                    navController.navigate(R.id.homeFragment)
                }
                R.id.comingSoonFragment -> {
                    navController.navigate(R.id.comingSoonFragment)
                }
                R.id.favoriteFragment -> {
                    navController.navigate(R.id.favoriteFragment)
                }
                R.id.profileFragment -> {
                    navController.navigate(R.id.profileFragment)
                }
            }
            true
        }
    }
}