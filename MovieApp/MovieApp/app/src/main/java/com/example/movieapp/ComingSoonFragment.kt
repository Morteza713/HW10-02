package com.example.movieapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.movieapp.databinding.FragmentComingSoonBinding
import com.example.movieapp.databinding.FragmentProfileBinding

class ComingSoonFragment:Fragment(R.layout.fragment_coming_soon) {

    lateinit var binding: FragmentComingSoonBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentComingSoonBinding.bind(view)

        binding.img11.setOnClickListener {
            var intent =  Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_SUBJECT,binding.tvTitle11.text)
            intent.putExtra(Intent.EXTRA_TEXT , binding.tvDec12.text )
            intent.type = "text/plain"
            if (intent.resolveActivity(requireActivity().packageManager) != null){
                startActivity(intent)
            }
        }
    }

}