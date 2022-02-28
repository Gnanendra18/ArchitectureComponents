package com.incrediblepath.architecturecomponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.incrediblepath.architecturecomponents.databinding.ActivitySampleLiveDataBinding

class LiveDataExample : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySampleLiveDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModel = ViewModelProvider(this).get(LiveDataExampleViewModel::class.java)

        binding.start.setOnClickListener{
            val timeInMillis = binding.time.text.toString()
            if(!timeInMillis.isEmpty() && timeInMillis.length>=4){
                viewModel.timeInMillis.value = timeInMillis.toLong()
                viewModel.startTimer()
            }else{
                Toast.makeText(this,"Enter Valid number",Toast.LENGTH_SHORT).show()
            }


        }

        binding.stop.setOnClickListener{
            viewModel.stopTimer()
            binding.time.setText((viewModel.seconds.value.toString().toLong()*1000).toString())
        }

        viewModel.seconds.observe(this,{
            binding.output.text = it.toString()
        })


        viewModel.isTimerFinished.observe(this,{
            if(it){
                Toast.makeText(this,"Timer finished",Toast.LENGTH_SHORT).show()
            }
        })

    }
}