package com.incrediblepath.architecturecomponents.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.incrediblepath.architecturecomponents.SampleLiveDataViewModel
import com.incrediblepath.architecturecomponents.api.RetrofitInstance
import com.incrediblepath.architecturecomponents.databinding.ActivitySampleRetrofitBinding
import com.incrediblepath.architecturecomponents.model.Post
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
        binding.getPost.setOnClickListener{
            //val postNo = binding.postNo.text.toString().toInt()
            viewModel.addPost(Post(3,999,"Gnanendra","This is sample post"))
        }
        viewModel.listOfPosts.observe(this,{
            if(it.isSuccessful){
                val posts = it.body()
                binding.response.text = posts.toString()
                posts?.forEach{
                    Log.e("USERID",it.userId.toString())
                    Log.e("id",it.id.toString())
                    Log.e("body",it.body)
                    Log.e("title",it.title)
                    Log.e("Reposne","-------------------------")
                }
            }else{
                Log.e("Reposne",it.errorBody().toString())
                Log.e("Reposne",it.code().toString())
                Log.e("Reposne",it.message().toString())
            }


        })

        viewModel.response.observe(this,{
            binding.response.text = it.toString()
        })
    }
}