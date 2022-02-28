package com.incrediblepath.architecturecomponents.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.incrediblepath.architecturecomponents.databinding.ActivitySampleRetrofitBinding
import com.incrediblepath.architecturecomponents.repository.Repository
import com.incrediblepath.architecturecomponents.viewmodels.SampleRetrofitActivityViewModel
import com.incrediblepath.architecturecomponents.viewmodels.SampleRetrofitActivityViewModelFactory

class SampleRetrofitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySampleRetrofitBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val repo = Repository()
        val viewModelFactory = SampleRetrofitActivityViewModelFactory(repo)
        val viewModel = ViewModelProvider(this,viewModelFactory).get(SampleRetrofitActivityViewModel::class.java)
        /*viewModel.getPostData();
        viewModel.response.observe(this,{
            if(it.isSuccessful) {
                Log.e("Response",it.body()!!.body)
            }else{
                Log.e("Response",it.errorBody().toString())
            }
        })*/

        binding.getPost.setOnClickListener{
            val no = binding.postNo.text.toString().toInt()
            viewModel.getPostDataOfPostNo(no)
            viewModel.response.observe(this,{
                if(it.isSuccessful) {
                    Log.e("Response",it.body()!!.body)
                    binding.response.text = it.body().toString()
                }else{
                    Log.e("Response",it.errorBody().toString())
                    binding.response.text = it.errorBody().toString()
                }
            })
        }

        binding.getPost.setOnClickListener{
            val no = binding.postNo.text.toString().toInt()
            viewModel.getUserPosts(no)
            viewModel.userPostsResponse.observe(this,{
                if(it.isSuccessful) {
                    binding.response.text = it.body().toString()
                    it.body()?.forEach{
                       Log.e("Reposne",it.body)
                    }
                }else{
                    Log.e("Response",it.errorBody().toString())
                    binding.response.text = it.errorBody().toString()
                }
            })
        }

    }
}