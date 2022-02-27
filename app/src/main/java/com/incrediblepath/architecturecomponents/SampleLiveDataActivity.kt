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
        //live data ensures UI match state
        //lifecycle aware
        //no memory leaks, no crashes
        val binding = ActivitySampleLiveDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModel = ViewModelProvider(this).get(SampleLiveDataViewModel::class.java)

        binding.start.setOnClickListener{
            if (!binding.time.text.isEmpty() && binding.time.text.length>=4){
                viewModel.endTImeInMillis.value = binding.time.text.toString().toLong()
                viewModel.startTimer()
            }
        }

        viewModel.seconds().observe(this,{
            binding.output.text = it.toString()
        })

        viewModel.isTimerFinished.observe(this,{
            if(it) {
                Toast.makeText(this, "Finished", Toast.LENGTH_SHORT).show()
            }
        })

        binding.stop.setOnClickListener{
            viewModel.stopTimer()
            binding.output.text = "0"
        }

    }
}