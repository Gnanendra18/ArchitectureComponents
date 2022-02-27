package com.incrediblepath.architecturecomponents

import android.os.CountDownTimer
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SampleLiveDataViewModel: ViewModel() {
    lateinit var countDownTimer: CountDownTimer
    val endTImeInMillis = MutableLiveData<Long>()
    val _seconds = MutableLiveData<Int>()
    val isTimerFinished = MutableLiveData<Boolean>(false)

    fun seconds():MutableLiveData<Int>{
        return _seconds
    }

    fun stopTimer(){
        countDownTimer.cancel()
    }

    fun startTimer(){
        countDownTimer = object :CountDownTimer(endTImeInMillis.value!!,1000){
            override fun onTick(p0: Long) {
                isTimerFinished.value = false
                val seconds = p0/1000
                _seconds.value = seconds.toInt()
            }

            override fun onFinish() {
                isTimerFinished.value = true
            }

        }
        countDownTimer.start()
    }
}