package com.incrediblepath.architecturecomponents

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    var number = 0
    fun incrementNumber(){
        number++
    }

}