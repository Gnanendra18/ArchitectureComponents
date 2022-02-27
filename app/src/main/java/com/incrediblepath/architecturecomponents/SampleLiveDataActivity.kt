package com.incrediblepath.architecturecomponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.incrediblepath.architecturecomponents.databinding.ActivitySampleLiveDataBinding

class SampleLiveDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySampleLiveDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewmodel = ViewModelProvider(this).get(SampleLiveDataViewModel::class.java)
        binding.start.setOnClickListener{
            if(!binding.time.text.isEmpty() && binding.time.text.length>4){
                viewmodel.timer_end_time.value = binding.time.text.toString().toLong()
                viewmodel.startTimer()
            }

        }
        binding.stop.setOnClickListener{
            viewmodel.stopTimer()
        }

        viewmodel.seconds().observe(this, Observer {
            binding.output.text = it.toString()
        })

        viewmodel.isTimerCompleted.observe(this,{
            if(it){
                Toast.makeText(this,"TImer completed",Toast.LENGTH_SHORT).show()
            }
        })


    }
}