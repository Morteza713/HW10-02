package com.example.movieapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.movieapp.databinding.FragmentProfileBinding

class ProfileFragment:Fragment(R.layout.fragment_profile) {

    lateinit var binding: FragmentProfileBinding
    private lateinit var takePictureActivityResultLauncher: ActivityResultLauncher<Void>
    private lateinit var takeImageGallery : ActivityResultLauncher<String>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentProfileBinding.bind(view)
        getImageFromGallery()
        createTakePictureIntentActivityResultLauncher()

        binding.btnRegister.setOnClickListener {
            if (binding.etFirstName.text.isNotEmpty() && binding.etLastName.text.isNotEmpty()
                &&binding.etEmailText.text.isNotEmpty()&&binding.etUsername.text.isNotEmpty()
                &&binding.etPhoneNumber.text.isNotEmpty()
            ){

                    Toast.makeText(this.context, "DATA Saved", Toast.LENGTH_SHORT).show()
                // do save data
                // action argument true to activity
            }else{
                Toast.makeText(this.context, "Fill DATA", Toast.LENGTH_SHORT).show()
            }
        }
        binding.profilePic.setOnClickListener {
            AlertDialog.Builder(this.requireContext())
                .setTitle("Choose")
                .setMessage("Choose Gallery Or Camera")
                .setPositiveButton("Gallery")
                { _,_ ->
                    takeImageGallery.launch("Image/*")
                }
                .setNegativeButton("Camera")
                { _,_ ->
                    takePictureActivityResultLauncher.launch(null)
                }
                .setCancelable(true)
                .show()
        }



    }
    private fun createTakePictureIntentActivityResultLauncher() {
        takePictureActivityResultLauncher = registerForActivityResult(ActivityResultContracts.TakePicturePreview()) {
            binding.profilePic.setImageBitmap(it)
        }
    }
    private fun getImageFromGallery(){
        takeImageGallery = registerForActivityResult(ActivityResultContracts.GetContent()){
            binding.profilePic.setImageURI(it)
        }
    }
}
