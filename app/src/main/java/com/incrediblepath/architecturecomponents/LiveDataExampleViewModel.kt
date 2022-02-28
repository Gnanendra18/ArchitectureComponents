package com.incrediblepath.architecturecomponents

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LiveDataExampleViewModel:ViewModel() {

    lateinit var countDownTimer: CountDownTimer
    var seconds = MutableLiveData<Int>()

    val isTimerFinished = MutableLiveData<Boolean>(false)

    val timeInMillis = MutableLiveData<Long>()

    fun startTimer(){
        countDownTimer = object : CountDownTimer(timeInMillis.value!!, 1000) {
            override fun onTick(l: Long) {
                val inSeconds = l/1000
                seconds.value = inSeconds.toInt()

            }
            override fun onFinish() {
                isTimerFinished.value = true
            }
        }
        countDownTimer.start()
    }

    fun stopTimer() {
        countDownTimer.cancel()
    }

}