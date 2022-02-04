package com.example.geoquizrefactor

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.geoquizrefactor.databinding.FragmentCheatBinding

class CheatFragment:Fragment(R.layout.fragment_cheat) {

    private lateinit var binding: FragmentCheatBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentCheatBinding.bind(view)
        val navController = findNavController()


        binding.btnShowAns.setOnClickListener {
            binding.tvSeeAns.text = arguments?.getString("Answer")
            binding.tvSeeAns.visibility = View.VISIBLE
        }
    }
}
