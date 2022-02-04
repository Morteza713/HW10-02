package com.example.geoquizrefactor

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.geoquizrefactor.databinding.FragmentQuestionBinding

class QuestionFragment:Fragment(R.layout.fragment_question) {

    lateinit var viewModel: QuestionViewModel
    private lateinit var binding: FragmentQuestionBinding
    var listNum:MutableList<Int> = mutableListOf()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentQuestionBinding.bind(view)
        viewModel = ViewModelProvider(this).get(QuestionViewModel::class.java)

        val navController = findNavController()

        var list: HashMap<Int, Pair<String, String>> = hashMapOf()
        list[1] = Pair("Is london in England", "true")
        list[2] = Pair("Is berlin in Germany", "true")
        list[3] = Pair("Is paris in spain", "false")
        list[4] = Pair("Is alaska in canada", "false")
        list[5] = Pair("Is texas in USA", "true")
        list[6] = Pair("Is texas in USA", "true")
        list[7] = Pair("Is texas in USA", "true")
        list[8] = Pair("Is texas in USA", "true")
        list[9] = Pair("Is texas in USA", "true")
        list[10] = Pair("Is texas in USA", "true")
        list[11] = Pair("f", "d")

        binding.tvQuestions.text = list[viewModel.getCount()]?.first

        disBtn(listNum,list)

        if(viewModel.getCount() == 1){
            binding.btnPerv.isEnabled = false
        }
        binding.btnNext.setOnClickListener {
            viewModel.inc()

            binding.btnPerv.isEnabled = true
            binding.tvQuestions.text = list[viewModel.getCount()]?.first.toString()
            if (viewModel.getCount() >= list.size-1) {
                binding.btnNext.isEnabled = false
            }
            if (listNum.isNotEmpty()){
                disBtn(listNum,list)
            }
        }
        binding.btnPerv.setOnClickListener {
            viewModel.minus()
            binding.tvQuestions.text = list[viewModel.getCount()]?.first.toString()
            if (viewModel.getCount() == 1) {
                binding.btnPerv.isEnabled = false
            } else {
                binding.btnNext.isEnabled = true
            }
            if (listNum.isNotEmpty()){
                disBtn(listNum,list)
            }
        }
        binding.btnFalse.setOnClickListener {
            var flag: Boolean = false
            for (i in 0 until list.size) {
                if (binding.tvQuestions.text.toString() == list[i]?.first && list[i]?.second == "false") {
                    flag = true
                } else {
                    flag
                }
            }
            if (flag) {
                Toast.makeText(this.context, "Correct", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this.context, "InCorrect", Toast.LENGTH_SHORT).show()
            }
        }
        binding.btnTrue.setOnClickListener {
            var flag: Boolean = false
            for (i in 0 until list.size) {
                if (binding.tvQuestions.text.toString() == list[i]?.first && list[i]?.second == "true") {
                    flag = true
                } else {
                    flag
                }
            }
            if (flag) {
                Toast.makeText(this.context, "Correct", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this.context, "InCorrect", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnCheat.setOnClickListener {
            listNum.add(viewModel.getCount())
            navController.navigate(QuestionFragmentDirections.actionQuestionFragmentToCheatFragment(findCheat(list,binding.tvQuestions.text.toString())))
        }
        NavigationUI.setupActionBarWithNavController(requireActivity() as AppCompatActivity,navController)

    }
    private fun findCheat(list: HashMap<Int,Pair<String,String>> , text:String):String{
        var findText = list.map {
            if (it.value.first == text){
                return it.value.second
            }
        }
        return findText.toString()
    }
    private fun disBtn(list: MutableList<Int> , listKey:HashMap<Int,Pair<String,String>>){
        for (i in list.indices){
            if (list.isNotEmpty()){
                if (listKey[list[i]]?.first == binding.tvQuestions.text){
                    binding.btnFalse.isEnabled = false
                    binding.btnTrue.isEnabled = false
                }else{
                    binding.btnFalse.isEnabled = true
                    binding.btnTrue.isEnabled = true
                }
            }
        }
        if (list.isEmpty()){
            binding.btnFalse.isEnabled = true
            binding.btnTrue.isEnabled = true
        }
    }

}
