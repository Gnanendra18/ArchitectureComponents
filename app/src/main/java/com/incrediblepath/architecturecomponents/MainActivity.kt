package com.incrediblepath.architecturecomponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.incrediblepath.architecturecomponents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var number = 0
        binding.button.setOnClickListener{
            number++
            binding.textView.text = number.toString()
        }
    }
}