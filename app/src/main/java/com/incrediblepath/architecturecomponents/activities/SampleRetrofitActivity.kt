package com.incrediblepath.architecturecomponents.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.incrediblepath.architecturecomponents.SampleLiveDataViewModel
import com.incrediblepath.architecturecomponents.api.RetrofitInstance
import com.incrediblepath.architecturecomponents.databinding.ActivitySampleRetrofitBinding
import com.incrediblepath.architecturecomponents.repository.Repository
import com.incrediblepath.architecturecomponents.viewmodels.MyViewModelFactory
import com.incrediblepath.architecturecomponents.viewmodels.SampleRetrofitViewModel

class SampleRetrofitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySampleRetrofitBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val factory = MyViewModelFactory(Repository())
        val viewModel = ViewModelProvider(this,factory).get(SampleRetrofitViewModel::class.java)
        viewModel.getOnePost()
        viewModel.response.observe(this,{
            binding.response.text = it.toString()
        })
    }
}