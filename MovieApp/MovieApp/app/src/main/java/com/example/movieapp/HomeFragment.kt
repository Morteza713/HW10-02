package com.example.movieapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.movieapp.databinding.FragmentHomeBinding

class HomeFragment:Fragment(R.layout.fragment_home) {

    lateinit var binding: FragmentHomeBinding
//    val navController by lazy { findNavController(R.id.homeFragment) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

//        var navController = findNavController()
//        NavigationUI.setupActionBarWithNavController(requireActivity() as AppCompatActivity,navController)
//        navcontroller.navigate(HomeFragmentDirections.actionHomeFragmentToComingSoonFragment())

    }

}