package com.incrediblepath.architecturecomponents.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.incrediblepath.architecturecomponents.ViewModelFactory
import com.incrediblepath.architecturecomponents.databinding.ActivitySampleRetrofitBinding
import com.incrediblepath.architecturecomponents.repository.Repository
import com.incrediblepath.architecturecomponents.viewmodels.SampleRetrofitViewModel
import com.incrediblepath.architecturecomponents.viewmodels.SampleViewModelFactory

class SampleRetrofitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //posts/1 this is path
        //posts?userid=3 this is query parameter


        val binding = ActivitySampleRetrofitBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val repo = Repository()
        val viewModel = ViewModelProvider(this, SampleViewModelFactory(repo)).get(SampleRetrofitViewModel::class.java)
        viewModel.getAllPostsOfUserId(3)
        viewModel.listResponse.observe(this,{
            binding.response.text = it.toString()
        })

    }
}