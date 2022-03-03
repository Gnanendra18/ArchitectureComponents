package com.incrediblepath.architecturecomponents.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.incrediblepath.architecturecomponents.R
import com.incrediblepath.architecturecomponents.databinding.ActivitySampleDatabaseBinding
import com.incrediblepath.architecturecomponents.model.Post
import com.incrediblepath.architecturecomponents.viewmodels.SampleDatabaseViewModel

class SampleDatabaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySampleDatabaseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModel = ViewModelProvider(this).get(SampleDatabaseViewModel::class.java)
        viewModel.listOfPost.observe(this){
            it.forEach{
                Log.e("Post",it.toString())
            }
        }

        binding.add.setOnClickListener {
            viewModel.addPost(Post(1,1,"Gnan","Kumar"))
            viewModel.retrievePosts()
            Toast.makeText(this,"Added",Toast.LENGTH_SHORT).show()
        }

        binding.update.setOnClickListener {
            viewModel.updatePost(Post(1,1,"Gnanendra","Kumar"))
            viewModel.retrievePosts()
            Toast.makeText(this,"Updated",Toast.LENGTH_SHORT).show()
        }
        binding.delete.setOnClickListener {
            viewModel.deletePost(Post(1,1,"Gnanendra","Kumar"))
            viewModel.retrievePosts()
            Toast.makeText(this,"Updated",Toast.LENGTH_SHORT).show()
        }



    }
}