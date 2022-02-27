package com.incrediblepath.architecturecomponents

import android.util.Log
import androidx.lifecycle.ViewModel

class MainActivityViewModel(defaultNumber:Int): ViewModel() {

    var number = defaultNumber
    fun incrementNumber(){
        number++
    }

}