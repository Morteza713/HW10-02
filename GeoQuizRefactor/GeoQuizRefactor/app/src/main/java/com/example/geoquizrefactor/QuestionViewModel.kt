package com.example.geoquizrefactor

import androidx.lifecycle.ViewModel

class QuestionViewModel:ViewModel() {

    private var count: Int = 1

    fun getCount():Int{
        return count
    }
    fun inc():Int{
        return count++
    }
    fun minus():Int{
        return count--
    }


}