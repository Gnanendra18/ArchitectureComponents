package com.incrediblepath.architecturecomponents

import android.os.CountDownTimer
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SampleLiveDataViewModel: ViewModel() {
    lateinit var countDownTimer: CountDownTimer

    private val _seconds = MutableLiveData<Int>()
    val isTimerCompleted = MutableLiveData<Boolean>(false)
    val timer_end_time = MutableLiveData<Long>()
    fun seconds():LiveData<Int>{
        return _seconds
    }

    fun startTimer(){
        countDownTimer = object : CountDownTimer(timer_end_time.value!!, 1000){
            override fun onTick(p0: Long) {
                val inSeconds = p0 / 1000
                _seconds.value = inSeconds.toInt()
            }

            override fun onFinish() {
                isTimerCompleted.value = true
            }
        }
        countDownTimer.start()

    }
    fun stopTimer(){
        countDownTimer.cancel()
    }
}