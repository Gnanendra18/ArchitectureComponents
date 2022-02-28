package com.incrediblepath.architecturecomponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.lifecycle.ViewModelProvider
import com.incrediblepath.architecturecomponents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //creating viewModel from Viewmodelprovider with ViewModel Factory
        val viewModel = ViewModelProvider(this,ViewModelFactory(10)).get(MainActivityViewModel::class.java)
        //accessing view model parameters
        //view model scope is available across all lifescycle methods
        //view models should not hold references to activities, fragments and any ui components and activity contexts
        binding.textView.text = viewModel.number.toString()
        binding.button.setOnClickListener{
            viewModel.incrementNumber()
            binding.textView.text = viewModel.number.toString()
        }
    }


}